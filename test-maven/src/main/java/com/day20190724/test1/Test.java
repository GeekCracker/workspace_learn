package com.day20190724.test1;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		User user = new User();
		Class<User> clazz = (Class<User>) user.getClass();
		Field [] fields = clazz.getDeclaredFields();
		//获取父类的class
		Class<Object> superClazz = (Class<Object>) clazz.getSuperclass();
		Field [] superFields = superClazz.getDeclaredFields();
		
		Class<Object> superClazz1 = superClazz.getSuperclass();
		Field [] superFields1 = superClazz1.getDeclaredFields();
		
		Class<Object> superClazz2 = superClazz1.getSuperclass();
		Field [] superFields2 = superClazz2.getDeclaredFields();
		
//		Class<Object> superClazz3 = superClazz2.getSuperclass();
//		Field [] superFields3 = superClazz3.getDeclaredFields();
		
		Arrays.asList(fields).forEach(item->System.out.println(item.getName()));
		Arrays.asList(superFields).forEach(item->System.out.println(item.getName()));
		Arrays.asList(superFields1).forEach(item->System.out.println(item.getName()));
		Arrays.asList(superFields2).forEach(item->System.out.println(item.getName()));
		System.out.println("clazz:"+clazz.getName());
		System.out.println("superClazz:"+superClazz.getName());
		System.out.println("superClazz1:"+superClazz1.getName());
		System.out.println("superClazz2:"+superClazz2.getName());
//		System.out.println("superClazz3:"+superClazz3.getName());
		
		Field [] result = getDeclaredFieldsWithSuperClasses(clazz);
		System.out.println("==========");
		Arrays.asList(result).forEach(item->System.out.println(item.getName()));
	}
	
	public static Field [] getDeclaredFieldsWithSuperClass(Class clazz){
        if(clazz == null){
            throw new RuntimeException("字节码对象不能为空！！");
        }
        Field [] fields = clazz.getDeclaredFields();

        Class<Object> superClazz = clazz.getSuperclass();
        if(superClazz != null){
            Field [] superFields = superClazz.getDeclaredFields();
            return append(superFields,fields);
        }
        return fields;
    }
	
	public static Field [] getDeclaredFieldsWithSuperClasses(Class clazz){
        if(clazz == null){
            throw new RuntimeException("字节码对象不能为空！！");
        }
        //获取当前字节码属性列表
        Field [] fields = clazz.getDeclaredFields();
        //获取父类字节码对象
        Class<Object> superClazz = clazz.getSuperclass();
        Class<Object>[] interfaces = clazz.getInterfaces();
        if(superClazz != null){
        	fields = append(fields,getDeclaredFieldsWithSuperClasses(superClazz));
        }
        if(interfaces.length > 0){
        	for(Class<Object> inter : interfaces){
        		fields = append(fields,getDeclaredFieldsWithSuperClasses(inter));
        	}
        }
        return repeatAll(fields);
    }
	
	
	public static <T> T[] append(T[]... source){
		for(int i = 1;i<source.length;i++){
			int destLength = source[0].length;
			int srcLength = source[i].length;
			source[0] = Arrays.copyOf(source[0],destLength + srcLength);
			System.arraycopy(source[i], 0, source[0], destLength, srcLength);
		}
		return source[0];
	}
	/**
     * 去掉数组中所有重复数据
     * @param arr 传入一个数组
     * @param <T> 数组元素的类型
     * @return 返回去重后的数组
     */
    public static <T> T[] repeatAll(T [] arr){
    	if(arr == null || arr.length == 0){
    		return arr;
    	}
    	List<T> list = new LinkedList<T>();
    	Class<T> clazz = null;
    	for(T t : arr){
    		if(clazz == null){
    			clazz = (Class<T>) t.getClass();
    		}
    		if(!list.contains(t)){
    			list.add(t);
    		}
    	}
    	return list.toArray((T [])Array.newInstance(clazz,list.size()));
    }
	/*public static Field [] append(Field[]... source){
		System.out.println("执行了吗2");
		if(!(source instanceof Field [][])){
			throw new RuntimeException("必须是二维数组！！");
		}
		List<Field> target = new ArrayList<Field>();
		for(Field [] array : source){
			for(int i = 0;i<array.length;i++){
				target.add(array[i]);
			}
		}
		return target.toArray(new Field[]{});
	}*/
	
}
interface Organism1 extends Organism3{
	 String aa = "张三1";
}
interface Organism2 extends Organism3{
	 String bb = "张三2";
}
interface Organism3{
	 String cc = "张三3";
}
abstract class Animal implements Organism1,Organism2{
	private String heart;
}
class Person extends Animal{
	private String id;
	
	private Date createTime;
	
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
class User extends Person{

	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}