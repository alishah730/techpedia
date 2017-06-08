package com.techpedia.chiper;


	import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




	// Referenced classes of package com.venu.cipher:
//	            CipherEncryptException, CipherTextInfo, CipherDencryptException

	public class TPChiperTextAppache
	{

		  private static final Logger LOGGER = LoggerFactory.getLogger(TPChiperTextAppache.class.getName());
		    private static byte key[] = {
		        116, 104, 105, 115, 73, 115, 65, 83, 101, 99, 114, 101, 116, 75, 101, 121
		    };

	
	    public static String encrypt(String strToEncrypt)
	        throws ChiperEncryptException
	    {
	        StringBuffer encryptedString=new StringBuffer();
	        try{
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
	        cipher.init(1, secretKey);
	        //encryptedString = Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes()));
	  
	        	//byte b[]= Base64.encodeBase64(cipher.doFinal(strToEncrypt.getBytes()));
        	   char ch[]= Hex.encodeHex(cipher.doFinal(strToEncrypt.getBytes()));
        	   for(int i=0;i<ch.length;i++){
          		   encryptedString.append(ch[i]);
        	   }
               return encryptedString.toString();
	        }catch(Exception e){ 
	         LOGGER.error(e.toString());
	         throw new ChiperEncryptException("Unable to Encrypt message!");
	        }	    }

	    public static String decrypt(String strToDecrypt)
	        throws ChiperDencryptException
	    {
	        String decryptedString;
	        try{
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
	        cipher.init(2, secretKey);
	        //decryptedString = new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));
	        decryptedString = new String(cipher.doFinal(Hex.decodeHex(strToDecrypt.toCharArray() )));
	        return decryptedString;
	        }catch(Exception e){
	                LOGGER.error(e.toString());
	                throw new ChiperDencryptException("Unable to Decrypt message!");
	        }
	    }

	    public static void main(String args[])
	        throws Exception
	    {
	        String msg = "Venugopal Drushetty";
	        LOGGER.info("Actual Message :" + msg);
	        String encryptedStr = encrypt(msg);
	        LOGGER.info((new StringBuilder("Encrypted : ")).append(encryptedStr).toString());
	        String decryptedStr = decrypt(encryptedStr.trim());
	        LOGGER.info((new StringBuilder("String To Decrypt : ")).append(encryptedStr).toString());
	        LOGGER.info((new StringBuilder("Decrypted : ")).append(decryptedStr).toString());
		    }

	    

	}
