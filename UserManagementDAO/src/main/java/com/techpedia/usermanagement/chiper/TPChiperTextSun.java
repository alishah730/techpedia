package com.techpedia.usermanagement.chiper;



import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.techpedia.usermanagement.chiper.TPChiperTextSun;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

	

	public class TPChiperTextSun
	{
       
	    private static byte key[] = {
	        17, 72, 105, 115, 73, 122, 65, 81, 101, 99, 
	        123, 101, 116, 66, 98, 105
	    };

		private static final Logger LOGGER = LoggerFactory.getLogger(TPChiperTextSun.class.getName());
		
	    public TPChiperTextSun()
	    {
	    }

	    public static void main(String a[])
	        throws Exception
	    {
	        String msg = encrypt("Venugopal");
	        LOGGER.info((new StringBuilder("Encrypt Code is :")).append(msg).toString());
	        LOGGER.info((new StringBuilder("Decryption Code is :")).append(decrypt(msg)).toString());
	    }

	    public static String encrypt(String str)
	        throws Exception
	    {
	        byte enc[];
	        try{
	        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        cipher.init(1, secretKey);
	        byte utf8[] = str.getBytes("UTF8");
	        enc = cipher.doFinal(utf8);
	        enc = BASE64EncoderStream.encode(enc);
	        return new String(enc);
	        }catch( Exception ex){
		        LOGGER.error("Error while encrypting in method (baseEncrypt) : ", ex);
		        throw ex;
	    	}
	    }

	    public static String decrypt(String str)
	        throws Exception
	    {
	        byte utf8[];
	        try{
	        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        cipher.init(2, secretKey);
	        byte dec[] = BASE64DecoderStream.decode(str.getBytes());
	        utf8 = cipher.doFinal(dec);
	        return new String(utf8, "UTF8");
	        }catch(Exception e)
	        {
	        	LOGGER.error("Error while decrypting in method (baseEncrypt) : ", e);
	        	throw e;
	        }
	    }

	
	}