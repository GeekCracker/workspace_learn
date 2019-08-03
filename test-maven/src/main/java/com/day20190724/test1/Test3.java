package com.day20190724.test1;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Test3 {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setId("d001");
		dog.setCreatedTime(new Date());
		dog.setDogName("小花狗");

		System.out.println(dog);
		Field [] fields = getDeclaredFieldsWithSuperClasses(dog.getClass());
		for(Field field : fields){
			field.setAccessible(true);
			String type = field.getGenericType().getTypeName();
			System.out.println(type);
			/*System.out.print(field.getName()+":");
			Object value = getValue(field,dog);
			System.out.println(value);*/
		}

	}
	public static Object getValue(Field field,Object obj){
		try {
			return field.get(obj);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
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
}
class BaseEntity{
	/**主键id*/
	private String id;
	/**创建时间*/
	private Date createdTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}
class Dog extends BaseEntity{
	private String dogName;

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	@Override
	public String toString() {
		return "Dog [dogName=" + dogName + ", getId()=" + getId() + ", getCreatedTime()=" + getCreatedTime()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}



}