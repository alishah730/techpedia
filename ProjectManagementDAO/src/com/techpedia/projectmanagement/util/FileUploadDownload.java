package com.techpedia.projectmanagement.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class FileUploadDownload{

	public static String saveFile(InputStream uploadedInputStream, String serverLocation, String projId, String regstrId, String docName) throws Exception{
		
		String returnVal = "";
		String dirName = serverLocation+"/"+projId+"/"+regstrId;
		String fileName = dirName+"/"+docName;		
		try {									
			Files.createDirectories(Paths.get(dirName));			
			OutputStream outpuStream = new FileOutputStream(new File(fileName));
			int read = 0;
			byte[] bytes = new byte[1024];
			outpuStream = new FileOutputStream(new File(fileName));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				outpuStream.write(bytes, 0, read);
			}
			outpuStream.flush();
			outpuStream.close();
			outpuStream = null;
			System.gc();
			
			returnVal = getFileSizeInMB(fileName);						
		} catch (IOException e) {
			throw new Exception("Error while uploading document :"+ e.getMessage());
		}
		return returnVal;		
	}
	
public static String saveFile(InputStream xlsFileInputStream, String serverLocation, String docName) throws Exception{
		
	String returnVal = "";
		String dirName = serverLocation;
		String fileName = dirName+docName;
		try {									
			Files.createDirectories(Paths.get(dirName));			
			OutputStream outpuStream = new FileOutputStream(new File(fileName));
			int read = 0;
			byte[] bytes = new byte[1024];
			outpuStream = new FileOutputStream(new File(fileName));
			while ((read = xlsFileInputStream.read(bytes)) != -1) {
				outpuStream.write(bytes, 0, read);
			}
			outpuStream.flush();
			outpuStream.close();
			outpuStream = null;
			System.gc();
			returnVal = fileName;						
		} catch (IOException e) {
			throw new Exception("Error while uploading document :"+ e.getMessage());
		}
		return returnVal;
	}

	public static String deleteFile(String fileName) {
		File file = new File(fileName);		 
		String result = "N";
		if(file.delete()){
			result = "Y";
		}
		return result;
	}
	
	public static String getFileSizeInMB(String fileName) {
		DecimalFormat formatter = new DecimalFormat("00.00000"); 
		double ret = getFileSizeInBytes(fileName);
	    ret = ret/1048576;	    
	    return formatter.format(ret);
	}

	public static long getFileSizeInBytes(String fileName) {
		long ret = 0;
		File f = new File(fileName);
		if (f.isFile()) {
			return f.length();
		} else if (f.isDirectory()) {
			File[] contents = f.listFiles();
			for (int i = 0; i < contents.length; i++) {
				if (contents[i].isFile()) {
					ret += contents[i].length();
				} else if (contents[i].isDirectory())
					ret += getFileSizeInBytes(contents[i].getPath());
			}
		}
		return ret;
	}


}
