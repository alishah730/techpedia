package com.techpedia.usermanagement.chiper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techpedia.usermanagement.chiper.ChiperDencryptException;
import com.techpedia.usermanagement.chiper.ChiperEncryptException;
import com.techpedia.usermanagement.chiper.ChiperUtils;
import com.techpedia.usermanagement.chiper.TPChiperTextAppache;
import com.techpedia.usermanagement.chiper.TPChiperTextSun;

public class ChiperUtils
{

	  private static final Logger LOGGER = LoggerFactory.getLogger(ChiperUtils.class.getName());

    public static String encrypt2(String strToEncrypt)
        throws ChiperEncryptException
    {
        String encryptedString;
        try{
           String msg = TPChiperTextAppache.encrypt(strToEncrypt.trim());
           encryptedString = TPChiperTextSun.encrypt(msg);
           return encryptedString;
        }catch(Exception e){
        	LOGGER.error((new StringBuilder("Error while encrypting in method (encrypt2):")).append(e).toString());
        	throw new ChiperEncryptException("Unable to Encrypt message!");
        }
    }

    public static String decrypt2(String strToDecrypt)
        throws ChiperDencryptException
    {
        String decryptedString;
        try{
        	String msg = TPChiperTextSun.decrypt(strToDecrypt);
        	
        	decryptedString = TPChiperTextAppache.decrypt(msg);
        	return decryptedString;
        }catch(Exception e)
        {
        LOGGER.error((new StringBuilder("Error while decrypting in method (decrypt2):")).append(e).toString());
        throw new ChiperDencryptException("Unable to Decrypt message!");
        }
    }

    public static String encrypt(String strToEncrypt) throws ChiperEncryptException
     {
        String encryptedString = null;
        try{
        	encryptedString = TPChiperTextSun.encrypt(strToEncrypt);
    		return encryptedString;
         }catch(Exception e){
            LOGGER.error((new StringBuilder("Error while encrypting")).append(e).toString());
        	throw new ChiperEncryptException("Unable to Encrypt message!");
        }
    }

    public static String decrypt(String strToDecrypt)
        throws ChiperDencryptException
    {
        String decryptedString;
        try{
         decryptedString = TPChiperTextSun.decrypt(strToDecrypt);
        }catch(Exception e){
                LOGGER.error((new StringBuilder("Error while encrypting")).append(e).toString());
                throw new ChiperDencryptException("Unable to Decrypt message!");
        }
        return decryptedString;
    }

    public static void main(String args[])
        throws Exception
    {
        String msg = "Venugopal Drushetty";
        LOGGER.info("Actual Message :Venugopal Drushetty");
        String encryptedStr = encrypt(msg);
        LOGGER.info((new StringBuilder("Encrypted : ")).append(encryptedStr).toString());
        String decryptedStr = decrypt(encryptedStr.trim());
        LOGGER.info((new StringBuilder("String To Decrypt : ")).append(encryptedStr).toString());
        LOGGER.info((new StringBuilder("Decrypted : ")).append(decryptedStr).toString());
        String encryptedStr1 = encrypt2(msg);
        LOGGER.info((new StringBuilder("Double Encrypted : ")).append(encryptedStr1).toString());
        String decryptedStr1 = decrypt2(encryptedStr1.trim());
        LOGGER.info((new StringBuilder("String To Decrypt : ")).append(encryptedStr1).toString());
        LOGGER.info((new StringBuilder("Double Decrypted : ")).append(decryptedStr1).toString());
    }

  

}
