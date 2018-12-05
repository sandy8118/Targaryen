package com.scp.java.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class hibernateUtilMethods{

	private static SessionFactory sessionfactory=buildSessionFactory();
	private static SessionFactory buildSessionFactory(){
		try{
    		  Configuration configuration = new Configuration().configure();
		 	   SessionFactory sessionFactory = configuration.buildSessionFactory();			
		       return sessionFactory;
		}
		catch(Exception ex){
			System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
        return sessionfactory;
    }
	
}
