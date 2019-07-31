package com.day20181228.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {

	public static void main(String[] args) {
		String srcPack="C:\\Users\\1\\AppData\\Roaming\\kingsoft\\office6\\templates\\download";
		String descPack="I:\\�칫ģ���ļ�\\���¹���";
		copyFile(srcPack,descPack);
	}
	public static void copyFile(String srcPackage,String descPackage){
		if(srcPackage!=null && descPackage != null && !"".equals(srcPackage) && !"".equals(descPackage)){
			File srcPack = new File(srcPackage);
			try {
				if(srcPack.exists() && srcPack.isDirectory()){
					File [] fileList = srcPack.listFiles();
					for(File file : fileList){
						if(file.isDirectory()){
							File [] files = file.listFiles();
							for(File fi : files){
								System.out.println("��ȡ��>>"+fi.getName());
								if(fi.isFile()){
									FileInputStream fis = new FileInputStream(fi);
									FileOutputStream fos = new FileOutputStream(descPackage + File.separator+fi.getName());
									
									byte [] bt = new byte[1024*1024];
									int len = 0;
									//��ȡһ��������
									System.out.print("���ڿ���");
									while((len = fis.read(bt)) != -1){
										fos.write(bt);
										System.out.print(">");
									}
									fis.close();
									fos.close();
									System.out.println("    ����ɾ������");
									fi.delete();
								}
							}
							file.delete();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
