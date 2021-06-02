package com.mcit.webapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateSessionUtil {
	
	private static SessionFactory factory;
	
	public static SessionFactory buildSessionFactory() {
		// load configuration
		StandardServiceRegistry  sServiceRegistry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml").build();
		
		Metadata meta = new MetadataSources(sServiceRegistry).getMetadataBuilder().build();
		
		factory = meta.getSessionFactoryBuilder().build();
		
		return factory;
	}
	
}
