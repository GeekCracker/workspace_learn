package com.day20181022;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.POIXMLPropertiesTextExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class DocText {

    public static void main(String[] args) throws Exception, IOException {
        String BASE_PATH = "D:\\home\\software\\resourses\\files\\��Ա����";
		File file = new File(BASE_PATH + "\\6\\0\\�������.docx");
		/*String str = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            XWPFDocument xdoc = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            String doc1 = extractor.getText();
            System.out.println(doc1);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
		/*XWPFDocument docxDocument = new XWPFDocument(new FileInputStream(file));
        // ����
        XHTMLOptions options = XHTMLOptions.create();
		options.setExtractor(new FileImageExtractor(imgFolder));
		//html��ͼƬ��·�� ���·�� 
		options.URIResolver(new BasicURIResolver("image"));
		options.setIgnoreStylesIfUnused(false); 
		options.setFragment(true); 
		 
		// 3) �� XWPFDocumentת����XHTML
		//����html�ļ��ϼ��ļ���
		File folder = new File(BASE_PATH+File.separator+"aa.html");
		if(!folder.exists()){ 
		  folder.mkdirs(); 
		}
		OutputStream out = new FileOutputStream(htmlFile); 
		XHTMLConverter.getInstance().convert(document, out, options);*/
    }
   
}