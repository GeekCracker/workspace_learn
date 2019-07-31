package com.day20190724.test1;

public class Test2 {

	public static void main(String[] args) {
		D d = new D();
		Class<D> clazz = (Class<D>) d.getClass();
		Class<Object> superClazz = (Class<Object>) clazz.getSuperclass();
		System.out.println(superClazz.getName());
		Class<Object>[] interfaces = (Class<Object>[]) clazz.getInterfaces();
		for(Class<Object> inter : interfaces){
			System.out.println(inter.getName());
			Class<Object> cls = inter.getSuperclass();
			Class<?>[] inter1 = inter.getInterfaces();
			for(Class<?> in : inter1){
				System.out.println(in.getName());
			}
		}
	}
	
}
interface A{
	String a  = "a";
}
interface B extends A{
	String b  = "b";
}
interface C extends B{
	String c  = "c";
}
class D implements C{
	String d = "d";
}
