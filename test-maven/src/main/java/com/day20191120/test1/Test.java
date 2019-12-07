package com.day20191120.test1;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test extends User{

    private String testName;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public static void main(String[] args) {

//        System.out.println(Test.class.getSuperclass().getSuperclass().getSuperclass().getSimpleName());
        Field [] fields = getEntityFields(Test.class,new LinkedList<>() );
        for(Field field :fields){
            System.out.println(field.getName());
        }
    }

    private static Field[] getEntityFields(Class clazz, List<Field> list){
        if(list == null){
            list = new LinkedList<Field>();
        }
        Field [] fields = clazz.getDeclaredFields();
        list.addAll(Arrays.asList(fields));

        Class cls = clazz.getSuperclass();//获取父类class
        if(cls != null && !"OBJECT".equals(cls.getSimpleName().toUpperCase())){
            return getEntityFields(cls,list);
        }else {
            return list.toArray(new Field[]{});
        }
    }
}
class User extends Person{
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
class Person{

    private String personName;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}

