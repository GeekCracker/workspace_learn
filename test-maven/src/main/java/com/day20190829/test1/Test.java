package com.day20190829.test1;

import java.io.*;

public class Test {
    public static void main(String[] args) {

    }
    public static void write(File file, String content){
        if(!file.exists())
            throw new RuntimeException("文件不存在");
        if(!file.isDirectory())
            throw new RuntimeException("该目录为文件夹，不能执行该操作");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
            bw.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
