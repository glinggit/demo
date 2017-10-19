package com.syy.demo.utils.QR;

public class App {

	public static void main(String[] args) throws Exception {

		// 生成带logo 的二维码
		String text = "http://my.csdn.net/ljheee";
		QRCodeUtil.encode(text, "F:/WPS/11.JPG", "F:/WPS", true);

		// 生成不带logo 的二维码
		String textt = "http://www.baidu.com";
		QRCodeUtil.encode(textt, "", "F:/WPS", true);

//		// 指定二维码图片，解析返回数据
//		System.out.println(QRCodeUtil.decode("D:/WPS/75040887.jpg"));

	}
}
