package com.day20190521.test1;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class TestBuffer {

	//NIO
	public static void main(String[] args) {
		System.out.println("=============���ڴ滺����������Ϣ===========");
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);
		System.out.println("�������������ݣ�");
		System.out.println(Arrays.toString(byteBuffer.array()));
		System.out.println("��������С��"+byteBuffer.capacity());
		System.out.println("�����������ļ���λ���±꣨�������ֲ��ܶ�д����"+byteBuffer.limit());
		System.out.println("��һ��Ҫ������д��Ԫ�ص�������"+byteBuffer.position());
		System.out.println("������ʣ��ռ��С��"+byteBuffer.remaining());
		System.out.println("�򻺳������������ַ���");
		byteBuffer.putChar('a');
		byteBuffer.putChar('b');
		System.out.println(Arrays.toString(byteBuffer.array()));
		System.out.println("��һ��Ҫ������д��Ԫ�ص�������"+byteBuffer.position());
		System.out.println("������ʣ��ռ��С��"+byteBuffer.remaining());
		System.out.println("\n\n\n\n");
		System.out.println("===========���洴�����ڴ滺����==========");
		System.out.println("heap���ڴ�������⣺");
		Long size1 = 0l;
		Long size2 = 0l;
		System.out.println("���ڴ��С��"+(size1=Runtime.getRuntime().freeMemory()));
		System.out.println("ʹ��allocate�ķ�ʽ����������...");
		ByteBuffer byteBuffer1 = ByteBuffer.allocate(124689656);
		System.out.println("���ڴ��С��"+(size2=Runtime.getRuntime().freeMemory()));
		System.out.println("����ǰ��ȥ�������JVM���ڴ�ռ䣺"+(size1-size2));
		System.out.println("���ۣ�����heap������ʹ�õ��˶��ڴ�ռ�");
		System.out.println("\n\n\n\n");
		System.out.println("===========���洴���Ƕ��ڴ滺����(ֱ�Ӳ���ϵͳ�ڴ�ķ�ʽ)==========");
		System.out.println("���ڴ��С��"+(size1=Runtime.getRuntime().freeMemory()));
		System.out.println("ʹ��allocateDirect�ķ�ʽ����������...");
		ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(124689656);
		System.out.println("���ڴ��С��"+(size1=Runtime.getRuntime().freeMemory()));
		System.out.println("����ǰ��ȥ�������JVM���ڴ�ռ䣺"+(size1-size2));
		System.out.println("���ۣ������Ƕ��ڴ滺����δʹ�õ�JVM�ڴ�ռ�");
	}
}
