package com.techpedia.util;

		import java.io.*;
	import java.util.Properties;

	public class TechPediaReadEnv
	{

	    public TechPediaReadEnv()
	    {
	    }

	    public static Properties getEnvProperties()
	    {
	        return prop;
	    }

	    public static String getEnvValue(String key)
	    {
	        return prop.getProperty(key);
	    }

	    static Properties prop;

	    static 
	    {
	        prop = new Properties();
	        try
	        {
	            File f = new File("D:/GEGDC/VD270026/Workspace/MyUtil/src/test/util/config.properties");
	            if(f.exists())
	                prop.load(new FileInputStream(f));
	            else
	                System.out.println((new StringBuilder("Unable to locate ")).append(f.getAbsolutePath()).toString());
	        }
	        catch(IOException ex)
	        {
	            ex.printStackTrace();
	        }
	    }
	}
