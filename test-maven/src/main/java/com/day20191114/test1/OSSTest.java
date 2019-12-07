package com.day20191114.test1;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectRequest;
import sun.awt.image.ImageWatched;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class OSSTest {

    // Endpoint�Ժ���Ϊ��������Region�밴ʵ�������д��
    private static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    // ���������˺�AccessKeyӵ������API�ķ���Ȩ�ޣ����պܸߡ�ǿ�ҽ�����������ʹ��RAM�˺Ž���API���ʻ��ճ���ά�����¼ https://ram.console.aliyun.com ����RAM�˺š�
    private static String accessKeyId = "LTAI4FoESZfaLESArD8nvmKx";
    private static String accessKeySecret = "Ccbpi16Yli5DX67LBrzt31djo5fzH4";

    public static void main(String[] args) {
       upload();
    }

    public static void upload (){
        // ����OSSClientʵ����
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        String content = "Hello OSS";
        // <yourObjectName>��ʾ�ϴ��ļ���OSSʱ��Ҫָ�������ļ���׺���ڵ�����·��������abc/efg/123.jpg��
        File file = new File("D://�ҵ�ͼƬ/1366X768/1.jpg");
        String key = "images/"+new SimpleDateFormat("yyyy/MM/dd/HH/mm/").format(new Date())+"1.jpg";
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest("my-app-images", key, new FileInputStream(file));

            Map<String,String> headers = new LinkedHashMap<String,String>();
            headers.put("Content-Type","image/jpeg");
            headers.put("Content-Disposition","attachment=image/jpeg");//����ͼƬ���ط�ʽ����2018��8��13���𣬲�����Ĭ��ֵΪContent-Disposition:'attachment=filename;'������ʱ������

            putObjectRequest.setHeaders(headers);

            ossClient.putObject(putObjectRequest);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // �ر�OSSClient��
        ossClient.shutdown();
    }

    public static void download(){
        // ����OSSClientʵ����
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        String bucketName = "my-app-images";
        String objectName = "images/2019/11/14/14/34/1.jpg";

        OSSObject ossObject = ossClient.getObject(bucketName, objectName);

        InputStream fis = ossObject.getObjectContent();

    }
}
