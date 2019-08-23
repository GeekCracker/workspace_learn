package com.day20190801.test1;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test {
    public static void main(String[] args) {

        int count = 0;

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    URL url = new URL("http://111.231.111.161:8080/treesoft");
                    URLConnection connection = url.openConnection();
                    InputStream is = connection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            count ++;
        }
        System.out.println(count);
    }
}
