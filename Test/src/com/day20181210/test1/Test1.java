package com.day20181210.test1;

public class Test1 {

	final static String salutation = "Hello! ";
	   
	   public static void main(String args[]){
	      GreetingService greetService1 = message1 -> System.out.println(salutation + message1);
	      greetService1.sayMessage("Runoob");
	   }
	    
	   interface GreetingService {
	      void sayMessage(String message);
	   }
}
