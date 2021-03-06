package com.redis.utils;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/***
 * MD5工具类
 */
public class MD5Utils {

	/**
	 * 	加密
	*/
	public static String encode(String text) {
		if(StringUtils.isBlank(text)){
			return null;
		}
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] result = md.digest(text.getBytes()); // 对文本进行加密
            StringBuilder sb = new StringBuilder();
            for (byte b : result) {
                int i = b & 0xff ; // 取字节的后八位有效值
                String s = Integer.toHexString(i);
                if (s.length() < 2) {
                    s = "0" + s;
                }
                sb.append(s);
            }
            // 加密的结果
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // 找不到该算法,一般不会进入这里
           throw new RuntimeException(e);
        }
	}

    /**
     * 	加密字节码
     */
    public static String encode(byte [] bytes) {
        if(bytes == null || bytes.length == 0){
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] result = md.digest(bytes); // 对字节码进行加密
            StringBuilder sb = new StringBuilder();
            for (byte b : result) {
                int i = b & 0xff ; // 取字节的后八位有效值
                String s = Integer.toHexString(i);
                if (s.length() < 2) {
                    s = "0" + s;
                }
                sb.append(s);
            }
            // 加密的结果
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // 找不到该算法,一般不会进入这里
            throw new RuntimeException(e);
        }
    }
    /**
     * 获取字节码的hash值
     */
    public static String bytesToHexString(byte[] bytes){
        if(bytes == null || bytes.length == 0){
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] result = md.digest(bytes); // 对字节码进行加密
            StringBuilder sb = new StringBuilder();
            for (byte b : result) {
                int i = b & 0xff ; // 取字节的后八位有效值
                String s = Integer.toHexString(i);
                if (s.length() < 2) {
                    s = "0" + s;
                }
                sb.append(s);
            }
            // 加密的结果
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // 找不到该算法,一般不会进入这里
            throw new RuntimeException(e);
        }
    }
}
