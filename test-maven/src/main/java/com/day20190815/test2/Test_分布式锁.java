package com.day20190815.test2;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
public class Test_分布式锁 {


    @Autowired
    Redisson redisson;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Test_分布式锁.class,args);
    }

    /**
     * 不加任何锁
     * @return
     */
    @RequestMapping("/test1")
    public String test1(){
        Integer stock = Integer.parseInt(String.valueOf(stringRedisTemplate.opsForValue().get("stock")));
        if(stock > 0){
            stringRedisTemplate.opsForValue().set("stock",(stock-1)+"");
            System.out.println("扣减成功，当前库存："+(stock-1));
        }else {
            System.out.println("扣减失败，库存不足。");
        }
        return null;
    }

    /**
     * 通过Redis的setNx方法进行加锁
     * setNx：只能设置一次value值
     * @return
     */
    @RequestMapping("/test2")
    public String test2(){
        Integer stock = Integer.parseInt(String.valueOf(stringRedisTemplate.opsForValue().get("stock")));
        if(stock > 0){
            //stringRedisTemplate.opsForValue().set("stock",(stock-1)+"");
            //删除库存
            stringRedisTemplate.delete("stock");
            if (setNx("stock",(stock-1)+"")){
                System.out.println("扣减成功，当前库存："+(stock-1));
            }else {
                System.out.println("扣减失败");
            }
        }else {
            System.out.println("扣减失败，库存不足。");
        }
        return null;
    }

    /**
     * 通过Redis的increment方式加锁
     * increment：可以对一个key的值进行加一个数的操作，这个数为步长，可以为正也可以为负，默认从0开始，这个key-value可以作为锁
     *
     *
     * 缺陷：由于redis执行速度很快，导致一些线程没有拿到锁，就已经执行完了，导致不能有序的进行库存的消费，可能先请求的没有获取到锁，没有消费，后面的线程反而拿到锁了
     * @return
     */
    boolean isDelay = true;//是否延迟的变量
    @RequestMapping("/test3")
    public String test3(){
        Thread thread = null;
        try {
            //获取锁
            Long lock = stringRedisTemplate.opsForValue().increment("lock",1);//乐观锁
            stringRedisTemplate.expire("lock",10, TimeUnit.SECONDS);//将锁设置10秒有效时间，避免服务宕机，没有重置锁，造成其他服务获取不到锁

            //这里设置10秒，还存在一个问题：当下面的执行逻辑超过10秒时，当前线程还没执行完，锁已经失效了，其他线程会拿到锁，执行相应的程序，
            // 当第二个线程还没执行完，第一个线程执行完了，第一个线程执行到释放锁的步骤，这时如果释放锁，释放的实际上是第二个线程的锁，这样整个集群的锁就出现了混乱不可控的情况

            //解决方案：在这段程序段中另外启动一个线程，不断监听锁，如果锁还存在，给锁重新设置一个过期时间，保证程序未执行完锁不会失效
            //弊端，该锁为悲观锁，当前线程会阻塞其他线程拿到锁，纯increment的方式是乐观锁，
            if(lock == 1){
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while(isDelay){
                                Thread.sleep(1000);
                                if(stringRedisTemplate.opsForValue().get("lock") != null){
                                    System.out.println("开始延迟锁");
                                    stringRedisTemplate.expire("lock",10, TimeUnit.SECONDS);
                                }
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                });
                thread.start();
                Integer stock = Integer.parseInt(String.valueOf(stringRedisTemplate.opsForValue().get("stock")));
                if(stock > 0){
                    try {
                        //在这里模拟程序段超时，时间超过了锁的有效期
                        Thread.sleep(15000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    stringRedisTemplate.opsForValue().set("stock",(stock-1)+"");
                    System.out.println("扣减成功，当前库存："+(stock-1));
                }else {
                    System.out.println("扣减失败，库存不足。");
                }
            }
        }finally {
            if(thread != null){
                try{
                    thread.interrupt();
                }catch (Exception e){
                    e.printStackTrace();
                }
                isDelay = false;
            }
            stringRedisTemplate.opsForValue().increment("lock",-1);
        }
        return null;
    }


    /**
     * 采用基于Netty框架的Redisson方式
     * @return
     */
    @RequestMapping(name = "/test4")
    public String test4(){
        RLock rLock = redisson.getLock("lock");
        try{
//            rLock.lock();//锁的超时时间默认为30秒，默认每10秒自旋一次延迟锁的有效时间，该锁是悲观锁，一个线程阻塞，会造成其他线程阻塞
            try {
                rLock.tryLock(20,TimeUnit.SECONDS);//设置锁的超时时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer stock = Integer.parseInt(String.valueOf(stringRedisTemplate.opsForValue().get("stock")));
            if(stock > 0){
                try {
                    //在这里模拟程序段超时，时间超过了锁的有效期
                    if(stock == 29){
                        Thread.sleep(2000);
                    }else if(stock == 28){
                        Thread.sleep(15000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stringRedisTemplate.opsForValue().set("stock",(stock-1)+"");
                System.out.println("扣减成功，当前库存："+(stock-1));
            }else {
                System.out.println("扣减失败，库存不足。");
            }
        }finally {
            if(rLock.isLocked()){
                rLock.unlock();
            }
        }
        return null;
    }


    public Boolean  setNx(String key,String value){
        /*stringRedisTemplate.opsForValue().set("stock",(stock-1)+"");*/
        return stringRedisTemplate.execute((RedisConnection conn) ->{
            try {
                return conn.setNX(stringRedisTemplate.getStringSerializer().serialize(key),
                        stringRedisTemplate.getStringSerializer().serialize(value.toString()));
            } finally {
                conn.close();
            }
        });
    }

    @Bean
    public Redisson redisson(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
        return (Redisson) Redisson.create(config);
    }

    @Bean
    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return stringRedisTemplate;
    }
}
