package com.day20190521.test1;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class TestBuffer {

	//NIO
	public static void main(String[] args) {
		System.out.println("=============堆内存缓冲区基本信息===========");
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);
		System.out.println("缓冲区数据内容：");
		System.out.println(Arrays.toString(byteBuffer.array()));
		System.out.println("缓冲区大小："+byteBuffer.capacity());
		System.out.println("缓冲区操作的极限位置下标（超出部分不能读写）："+byteBuffer.limit());
		System.out.println("下一个要被读或写的元素的索引："+byteBuffer.position());
		System.out.println("缓冲区剩余空间大小："+byteBuffer.remaining());
		System.out.println("向缓冲区加入两个字符：");
		byteBuffer.putChar('a');
		byteBuffer.putChar('b');
		System.out.println(Arrays.toString(byteBuffer.array()));
		System.out.println("下一个要被读或写的元素的索引："+byteBuffer.position());
		System.out.println("缓冲区剩余空间大小："+byteBuffer.remaining());
		System.out.println("\n\n\n\n");
		System.out.println("===========下面创建堆内存缓冲区==========");
		System.out.println("heap堆内存容量监测：");
		Long size1 = 0l;
		Long size2 = 0l;
		System.out.println("堆内存大小："+(size1=Runtime.getRuntime().freeMemory()));
		System.out.println("使用allocate的方式创建缓冲区...");
		ByteBuffer byteBuffer1 = ByteBuffer.allocate(124689656);
		System.out.println("堆内存大小："+(size2=Runtime.getRuntime().freeMemory()));
		System.out.println("创建前减去创建后的JVM堆内存空间："+(size1-size2));
		System.out.println("结论：创建heap缓冲区使用掉了堆内存空间");
		System.out.println("\n\n\n\n");
		System.out.println("===========下面创建非堆内存缓冲区(直接操作系统内存的方式)==========");
		System.out.println("堆内存大小："+(size1=Runtime.getRuntime().freeMemory()));
		System.out.println("使用allocateDirect的方式创建缓冲区...");
		ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(124689656);
		System.out.println("堆内存大小："+(size1=Runtime.getRuntime().freeMemory()));
		System.out.println("创建前减去创建后的JVM堆内存空间："+(size1-size2));
		System.out.println("结论：创建非堆内存缓冲区未使用到JVM内存空间");
	}
}
