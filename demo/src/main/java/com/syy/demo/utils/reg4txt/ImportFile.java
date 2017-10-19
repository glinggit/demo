package com.syy.demo.utils.reg4txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ImportFile {
	/**
	 * 读取文件，将文件中的电话号码读取出来，保存在Set中。
	 * 
	 * @param filePath
	 *            文件的绝对路径
	 * @return 文件中包含的电话号码
	 */
	public static Set<String> getPhoneNumFromFile(String filePath) {
		Set<String> phoneSet = new HashSet<String>();

		try {
			String encoding = "UTF-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;

				while ((lineTxt = bufferedReader.readLine()) != null) {
					// 读取文件中的一行，将其中的电话号码添加到phoneSet中
					CheckIfIsWantStr.getWantStrFromStrIntoSet(lineTxt, phoneSet);
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}

		return phoneSet;
	}
	
	public static void main(String[] args) {
		String filePath = "F:\\test/three.txt";  
	     
	    Set<String> phoneSet = getPhoneNumFromFile(filePath);
	    try {
		    File file = new File("F:\\test/result.txt");     //文件路径（路径+文件名）  
	        if (!file.exists()) {   //文件不存在则创建文件，先创建目录  
	            File dir = new File(file.getParent());  
	            dir.mkdirs();  
				file.createNewFile();
	        }  
	        
	        FileOutputStream outStream = new FileOutputStream(file);    //文件输出流用于将数据写入文件  
	        
		    for(String str : phoneSet){
		    	outStream.write((str+"\n").getBytes());
		    }
		    outStream.close(); 
	    } catch (IOException e) {
			e.printStackTrace();
		}  
	}
}
