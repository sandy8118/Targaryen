package com.scp.java.HbOperations;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestHIibernateMapping {

	public static void main(String[] args) {
	
		Customer c1=new Customer(104,"Yoegsh","pune",null);
		Customer c2=new Customer(106,"Sandy","pune",null);	
		Customer c3=new Customer(104,"Umesh","Rahata",null);
		Customer c4=new Customer(106,"Ram","Shrirampur",null);	
		Customer c5=new Customer(104,"Ramesh","Bhugaon",null);
		Customer c6=new Customer(106,"Paddy","Shirdi",null);	
		
  	/*    Vendor v1=new Vendor(1,"Sandy","HomeAappliances",c1);
		Vendor v2=new Vendor(3,"Pradip","Electronics",c2);
		Vendor v3=new Vendor(4,"Mahesh","Spareparts",c1);
		Vendor v4=new Vendor(5,"Sachin","Electronics",c2);
		Vendor v5=new Vendor(7,"Abhjit","Ayurvedic_Products",c2);
	*/	
		
		List<Vendor> vendor_list1 = new ArrayList<Vendor>(); 
		List<Vendor> vendor_list2 = new ArrayList<Vendor>();
		
	/*	vendor_list1.add(v1);
		vendor_list2.add(v2);
		vendor_list1.add(v3);
		vendor_list2.add(v4);
		vendor_list2.add(v5);
	*/	c1.setVendors(vendor_list1);
		c2.setVendors(vendor_list2);		
		Session session1 = com.scp.java.HibernateUtil.hibernateUtilMethods.getSessionFactory().openSession();
	       Transaction tr=session1.beginTransaction();
	       session1.save(c1);
	       session1.save(c2);
	       session1.flush();
	       tr.commit();
	       
		
			
		
		/*Customer c1=new Customer(101,"Yoegsh","pune",null);
		Customer c2=new Customer(102,"Sandy","pune",null);
	
		
  	    Vendor v1=new Vendor(1,"Sandy","HomeAappliances",c1);
		Vendor v2=new Vendor(3,"Pradip","Electronics",c2);
		Vendor v3=new Vendor(4,"Mahesh","Spareparts",c1);
		Vendor v4=new Vendor(5,"Sachin","Electronics",c2);
		Vendor v5=new Vendor(7,"Abhjit","Ayurvedic_Products",c2);
		
		List<Vendor> vendor_list1 = new ArrayList<Vendor>(); 
		List<Vendor> vendor_list2 = new ArrayList<Vendor>(); 
		vendor_list1.add(v1);
		vendor_list2.add(v2);
		vendor_list1.add(v3);
		vendor_list2.add(v4);
		vendor_list2.add(v5);
		
		c1.setVendors(vendor_list1);
		c2.setVendors(vendor_list2);
		
		Session session1 = com.scp.java.HibernateUtil.hibernateUtilMethods.getSessionFactory().openSession();
	       Transaction tr=session1.beginTransaction();
	       session1.save(c1);
	       session1.save(c2);
	    // sessionOne.save(e3);
	       session1.flush();
	       tr.commit();
	       
		
		
		Vendor v1=new Vendor(1,"Sandy","Home-appliances");
		Vendor v2=new Vendor(3,"Pradip","Electronics");
		Vendor v3=new Vendor(4,"Mahesh","Spareparts");
		Vendor v4=new Vendor(5,"Sachin","Electronics");
		Vendor v5=new Vendor(7,"Abhjit","Ayurvedic_Products");
		
		List<Vendor> vendor_list1 = new ArrayList<Vendor>(); 
		List<Vendor> vendor_list2 = new ArrayList<Vendor>(); 
		vendor_list1.add(v1);
		vendor_list2.add(v2);
		vendor_list1.add(v3);
		vendor_list2.add(v4);
		vendor_list2.add(v5);
		
		Customer c1=new Customer(101,"Yoegsh","pune",vendor_list1);
		Customer c2=new Customer(102,"Yoegsh","pune",vendor_list2);
		Session session1 = com.scp.java.HibernateUtil.hibernateUtilMethods.getSessionFactory().openSession();
	       Transaction tr=session1.beginTransaction();
	       session1.save(c1);
	       session1.save(c2);
	    // sessionOne.save(e3);
	       session1.flush();
	       tr.commit();
		
	
*/
	}
}
