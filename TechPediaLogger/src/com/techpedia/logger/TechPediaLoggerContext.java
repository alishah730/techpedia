package com.techpedia.logger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.XMLConfigurationFactory;
import org.apache.logging.log4j.message.MessageFactory;

public class TechPediaLoggerContext
{

	private static LoggerContext ctx;
	public static String LoggerConfigFileName = "log-file-roll.xml"; //TPReadEnv.getEnvValue(  TPEnvProp.LoggerConfigFileName);
	static 
	{
		buildContext();
	}

	private static void buildContext()
	{
		String loggerConfFile = null;
		try
		{
			java.io.InputStream is = TechPediaLoggerContext.class.getResourceAsStream(LoggerConfigFileName);
			org.apache.logging.log4j.core.config.ConfigurationFactory.ConfigurationSource source = new org.apache.logging.log4j.core.config.ConfigurationFactory.ConfigurationSource(is);
			org.apache.logging.log4j.core.config.Configuration config = XMLConfigurationFactory.getInstance().getConfiguration(source);
			ctx = (LoggerContext)LogManager.getContext(true);
			ctx.stop();
			ctx.start(config);
		}
		catch(Exception er)
		{
			System.out.println((new StringBuilder("Unable to build logger context from config file :")).append(loggerConfFile).toString());
			er.printStackTrace();
		}
	}

	public static LoggerContext getContext()
	{
		startContext();
		return ctx;
	}

	public static MessageFactory getMessageFactory(String fqcn){
		return getLogger(fqcn).getMessageFactory();
	}

	/*private static void stopContext()
	    {
	        if(ctx.isStarted())
	            ctx.stop();
	    }*/

	private static void startContext()
	{
		if(ctx == null || !ctx.isStarted())
			buildContext();
	}

	private static Logger getLogger(String fqcn)
	{
		return ctx.getLogger(fqcn);
	}



}
