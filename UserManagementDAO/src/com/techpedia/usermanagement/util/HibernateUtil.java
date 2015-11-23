package com.techpedia.usermanagement.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author nishikant.singh
 *
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory(); //will be initialized with class, so only once

	private static SessionFactory buildSessionFactory(){
		 SessionFactory sessionFactory;
		 ServiceRegistry serviceRegistry;
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration();
	        configuration.configure("hibernate-cfg.xml");
	        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	        return sessionFactory;
		}catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.out.println("Initial SessionFactory creation failed." + ex); // you may use logger
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory(){
		if(null != sessionFactory){
			return sessionFactory;
		}
		return buildSessionFactory();
	}
	/*
                public static SessionFactory getSessionFactory()
                                    throws HibernateException
                {
                                Configuration configuration = new Configuration();
                    String hibernate_conf_file = "hibernate.cfg.xml";
                    configuration.configure(hibernate_conf_file);
                    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
                    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                    return sessionFactory;
                }*/

}