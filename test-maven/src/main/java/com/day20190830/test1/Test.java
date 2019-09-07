package com.day20190830.test1;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        byte [] bytes = {127,13,11,34,5,65,33,33,66,33,22,44,11,1,1,1,3,1,1,34,5,42,54,1};
        System.out.println(Arrays.toString(bytes));
        String result = encode(bytes);
        System.out.println(result);
        String hash = bytesToHexString(bytes);
        System.out.println(hash);
        System.out.println(Arrays.toString(bytes));
    }
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
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}
