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
public class Test_�ֲ�ʽ�� {


    @Autowired
    Redisson redisson;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Test_�ֲ�ʽ��.class,args);
    }

    /**
     * �����κ���
     * @return
     */
    @RequestMapping("/test1")
    public String test1(){
        Integer stock = Integer.parseInt(String.valueOf(stringRedisTemplate.opsForValue().get("stock")));
        if(stock > 0){
            stringRedisTemplate.opsForValue().set("stock",(stock-1)+"");
            System.out.println("�ۼ��ɹ�����ǰ��棺"+(stock-1));
        }else {
            System.out.println("�ۼ�ʧ�ܣ���治�㡣");
        }
        return null;
    }

    /**
     * ͨ��Redis��setNx�������м���
     * setNx��ֻ������һ��valueֵ
     * @return
     */
    @RequestMapping("/test2")
    public String test2(){
        Integer stock = Integer.parseInt(String.valueOf(stringRedisTemplate.opsForValue().get("stock")));
        if(stock > 0){
            //stringRedisTemplate.opsForValue().set("stock",(stock-1)+"");
            //ɾ�����
            stringRedisTemplate.delete("stock");
            if (setNx("stock",(stock-1)+"")){
                System.out.println("�ۼ��ɹ�����ǰ��棺"+(stock-1));
            }else {
                System.out.println("�ۼ�ʧ��");
            }
        }else {
            System.out.println("�ۼ�ʧ�ܣ���治�㡣");
        }
        return null;
    }

    /**
     * ͨ��Redis��increment��ʽ����
     * increment�����Զ�һ��key��ֵ���м�һ�����Ĳ����������Ϊ����������Ϊ��Ҳ����Ϊ����Ĭ�ϴ�0��ʼ�����key-value������Ϊ��
     *
     *
     * ȱ�ݣ�����redisִ���ٶȺܿ죬����һЩ�߳�û���õ��������Ѿ�ִ�����ˣ����²�������Ľ��п������ѣ������������û�л�ȡ������û�����ѣ�������̷߳����õ�����
     * @return
     */
    boolean isDelay = true;//�Ƿ��ӳٵı���
    @RequestMapping("/test3")
    public String test3(){
        Thread thread = null;
        try {
            //��ȡ��
            Long lock = stringRedisTemplate.opsForValue().increment("lock",1);//�ֹ���
            stringRedisTemplate.expire("lock",10, TimeUnit.SECONDS);//��������10����Чʱ�䣬�������崻���û����������������������ȡ������

            //��������10�룬������һ�����⣺�������ִ���߼�����10��ʱ����ǰ�̻߳�ûִ���꣬���Ѿ�ʧЧ�ˣ������̻߳��õ�����ִ����Ӧ�ĳ���
            // ���ڶ����̻߳�ûִ���꣬��һ���߳�ִ�����ˣ���һ���߳�ִ�е��ͷ����Ĳ��裬��ʱ����ͷ������ͷŵ�ʵ�����ǵڶ����̵߳���������������Ⱥ�����ͳ����˻��Ҳ��ɿص����

            //�������������γ��������������һ���̣߳����ϼ�����������������ڣ�������������һ������ʱ�䣬��֤����δִ����������ʧЧ
            //�׶ˣ�����Ϊ����������ǰ�̻߳����������߳��õ�������increment�ķ�ʽ���ֹ�����
            if(lock == 1){
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while(isDelay){
                                Thread.sleep(1000);
                                if(stringRedisTemplate.opsForValue().get("lock") != null){
                                    System.out.println("��ʼ�ӳ���");
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
                        //������ģ�����γ�ʱ��ʱ�䳬����������Ч��
                        Thread.sleep(15000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    stringRedisTemplate.opsForValue().set("stock",(stock-1)+"");
                    System.out.println("�ۼ��ɹ�����ǰ��棺"+(stock-1));
                }else {
                    System.out.println("�ۼ�ʧ�ܣ���治�㡣");
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
     * ���û���Netty��ܵ�Redisson��ʽ
     *
     * �������ַ�ʽ�󻹴��ڱ׶ˣ����Redis���õ������Ӽܹ����ǵ���ģʽ������master��д������
     * ���ӻ�û���ü�ͬ������ʱ��master崻��ˣ��ᷢ�������л����л���masterû�е�ǰ�̵߳����������̱߳���Խ��м���������
     * ��ǰ�߳��ͷ���ʱ�����ͷŵ������̵߳���������������Ⱥ����������ҵ�
     *
     * �������������Redis������ģʽ��ֻ��master-slave֮�����ͬ�����ݣ����Խ�������Redis��û�취���������ģ�
     *
     *           ��ʱ��������zookeeper��������֤���ݵ�һ���ԣ�ÿ��zookeeper�ͻ��˶�Ӧһ��master��redis���񣬵�һ��master崻�������master������Ҳ�����µ�
     *
     *
     * @return
     */
    @RequestMapping(name = "/test4")
    public String test4(){
        RLock rLock = redisson.getLock("lock");
        try{
//            rLock.lock();//���ĳ�ʱʱ��Ĭ��Ϊ30�룬Ĭ��ÿ10���ж�һ�µ�ǰ�߳��Ƿ��������������У����ӳ�������Чʱ�䣬
//            �����Ǳ�����������������߳������������̴߳�ʱ�������������ϳ���ȥ��ȡ��
            try {
                rLock.tryLock(20,TimeUnit.SECONDS);//�������ĳ�ʱʱ��
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer stock = Integer.parseInt(String.valueOf(stringRedisTemplate.opsForValue().get("stock")));
            if(stock > 0){
                try {
                    //������ģ�����γ�ʱ��ʱ�䳬����������Ч��
                    if(stock == 29){
                        Thread.sleep(2000);
                    }else if(stock == 28){
                        Thread.sleep(15000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stringRedisTemplate.opsForValue().set("stock",(stock-1)+"");
                System.out.println("�ۼ��ɹ�����ǰ��棺"+(stock-1));
            }else {
                System.out.println("�ۼ�ʧ�ܣ���治�㡣");
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
