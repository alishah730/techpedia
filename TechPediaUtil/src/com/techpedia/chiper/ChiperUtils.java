package com.techpedia.chiper;

import com.techpedia.logger.TechPediaLogger;

public class ChiperUtils
{

	  private static TechPediaLogger log = TechPediaLogger.getLogger(ChiperUtils.class.getName());

    public static String encrypt2(String strToEncrypt)
        throws ChiperEncryptException
    {
        String encryptedString;
        try{
           String msg = TPChiperTextAppache.encrypt(strToEncrypt.trim());
           encryptedString = TPChiperTextSun.encrypt(msg);
           return encryptedString;
        }catch(Exception e){
        	log.error((new StringBuilder("Error while encrypting in method (encrypt2):")).append(e).toString());
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
        log.error((new StringBuilder("Error while decrypting in method (decrypt2):")).append(e).toString());
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
            System.out.println((new StringBuilder("Error while encrypting")).append(e).toString());
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
                System.out.println((new StringBuilder("Error while encrypting")).append(e).toString());
                throw new ChiperDencryptException("Unable to Decrypt message!");
        }
        return decryptedString;
    }

    public static void main(String args[])
        throws Exception
    {
        String msg = "Venugopal Drushetty";
        System.out.println("Actual Message :Venugopal Drushetty");
        String encryptedStr = encrypt(msg);
        System.out.println((new StringBuilder("Encrypted : ")).append(encryptedStr).toString());
        String decryptedStr = decrypt(encryptedStr.trim());
        System.out.println((new StringBuilder("String To Decrypt : ")).append(encryptedStr).toString());
        System.out.println((new StringBuilder("Decrypted : ")).append(decryptedStr).toString());
        String encryptedStr1 = encrypt2(msg);
        System.out.println((new StringBuilder("Double Encrypted : ")).append(encryptedStr1).toString());
        String decryptedStr1 = decrypt2(encryptedStr1.trim());
        System.out.println((new StringBuilder("String To Decrypt : ")).append(encryptedStr1).toString());
        System.out.println((new StringBuilder("Double Decrypted : ")).append(decryptedStr1).toString());
    }

  

}
