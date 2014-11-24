package com.techpedia.logger;
import org.apache.logging.log4j.core.Logger;


public class TechPediaLogger extends Logger{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TechPediaLogger(String fqcn){
		super(TechPediaLoggerContext.getContext(),fqcn, TechPediaLoggerContext.getMessageFactory(fqcn) );
	}
	 
	public static TechPediaLogger getLogger(String fqcn){
		return new TechPediaLogger(fqcn);
	}
}