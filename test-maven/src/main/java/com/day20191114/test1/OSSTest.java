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

    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    private static String accessKeyId = "LTAI4FoESZfaLESArD8nvmKx";
    private static String accessKeySecret = "Ccbpi16Yli5DX67LBrzt31djo5fzH4";

    public static void main(String[] args) {
       upload();
    }

    public static void upload (){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        String content = "Hello OSS";
        // <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        File file = new File("D://我的图片/1366X768/1.jpg");
        String key = "images/"+new SimpleDateFormat("yyyy/MM/dd/HH/mm/").format(new Date())+"1.jpg";
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest("my-app-images", key, new FileInputStream(file));

            Map<String,String> headers = new LinkedHashMap<String,String>();
            headers.put("Content-Type","image/jpeg");
            headers.put("Content-Disposition","attachment=image/jpeg");//设置图片下载方式，从2018年8月13日起，不设置默认值为Content-Disposition:'attachment=filename;'，访问时会下载

            putObjectRequest.setHeaders(headers);

            ossClient.putObject(putObjectRequest);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public static void download(){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        String bucketName = "my-app-images";
        String objectName = "images/2019/11/14/14/34/1.jpg";

        OSSObject ossObject = ossClient.getObject(bucketName, objectName);

        InputStream fis = ossObject.getObjectContent();

    }
}
