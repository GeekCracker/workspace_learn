package com.day20191118.test1;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String dir1 = "D://test/day20191118/aaa";
        String dir2 = "D://test/day20191118/bbb";

        readFileNamesToFileFromDir(dir1,"a1.txt");
        readFileNamesToFileFromDir(dir2,"a2.txt");

        //获取a1.txt文件中a2.txt没有的
        List<String> list = getNull(dir1+"/"+"a1.txt",dir2+"/"+"a2.txt");
        list.forEach(s -> System.out.println(s));

    }

    public static void readFileNamesToFileFromDir(String dir,String fileName){

        try {
            File file = new File(dir);
            if(file.exists() && file.isDirectory()){
                File [] files = file.listFiles();

                File dest = new File(dir + "/" +fileName);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(dest))));
                for(File fs : files){
                    bw.write(fs.getName().split("\\.")[0]);
                    bw.newLine();
                }
                bw.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<String> getNull(String path1,String path2){
        List<String> list = new LinkedList<String>();
        try {
            File file1 = new File(path1);
            File file2 = new File(path2);

            List<String> list1 = new LinkedList<String>();
            List<String> list2 = new LinkedList<String>();

            BufferedReader br1 = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(file1))));
            String str1 = null;
            while((str1 = br1.readLine())!= null){
                list1.add(str1);
            }
            BufferedReader br2 = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(file2))));
            String str2 = null;
            while((str2 = br2.readLine())!= null){
                list2.add(str2);
            }
            for(String s : list1){
                if(!list2.contains(s)){
                    list.add(s);
                }
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }



        return null;
    }

}
