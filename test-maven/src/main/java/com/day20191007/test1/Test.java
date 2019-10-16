package com.day20191007.test1;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashSet;

/**
 * 生成二维码
 */
public class Test {

    public static void main(String[] args) {
        generateQRCodeImage("{\"SCM_OM_ID\":\"5E6C9252C3B843A7989EBDAD1C06AEA6\",\"MM_CATE_ID\":\"B4B24775B3824D9B88FF8F9F123F48A0\"}",5000,5000,"D://abc.png");
    }

    private static void generateQRCodeImage(String text, int width, int height, String filePath){
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

            Path path = FileSystems.getDefault().getPath(filePath);

            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
