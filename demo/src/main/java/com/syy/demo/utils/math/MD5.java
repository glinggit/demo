package com.syy.demo.utils.math;



import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

import org.apache.commons.codec.digest.DigestUtils;

import com.syy.demo.utils.exception.DemoException;

/** 
* 功能：MD5签名处理核心文件，不需要修改
* 版本：3.3
* 修改日期：2012-08-17
* 
* */

public class MD5 {

    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static String sign(String text,String input_charset) {
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }
    
    public static void main(String[] args) {
    	String text = "p2p";
    	String key = "e825a0a60757d5b34f0c6fd3add66618";
    	String sign = "cb06bdc181374175c7e81f0cb698687a";
    	
//		LogUtil.LOG.debug("签名前："+text+key);
//		LogUtil.LOG.debug("签名后："+sign(text+key, "utf-8"));
//		LogUtil.LOG.debug("比较1"+sign(text+key, "utf-8").equals("cb06bdc181374175c7e81f0cb698687a"));
//		LogUtil.LOG.debug("比较2："+verify(text,sign,key,"utf-8"));
    }    
    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param sign 签名结果
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static boolean verify(String text, String sign, String key, String input_charset) {
    	text = text + key;
    	//LogUtil.APP.info("数据签名前【明文】："+text);
    	String mysign = DigestUtils.md5Hex(getContentBytes(text, input_charset));
    	//LogUtil.APP.info("数据签名后【密文】："+mysign);
    	//LogUtil.APP.info("接收数据【密文】："+sign);
    	if(mysign.equals(sign)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException 
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (Exception e) {
            throw new  DemoException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

}