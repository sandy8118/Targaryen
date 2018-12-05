package com.scp.java.HbOperations;
import org.hibernate.SQLQuery;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Criteria;
import java.util.*;
public class Test{
	public static void main(String[] args) {
		Employee e1=new Employee(101,"Sandy","pune",75000);
		Employee e2=new Employee(102,"Kishor","Mumbai",75000);
		Employee e3=new Employee(103,"Amit","pune",75000);
	    Session session12 = com.scp.java.HibernateUtil.hibernateUtilMethods.getSessionFactory().openSession();
        Transaction tr=session12.beginTransaction();
        session12.save(e1);
        session12.save(e2);
        session12.save(e3);
        Employee e=session12.load(Employee.class,102);//load the employee class type object has id-primary key :102
        System.out.println(e);
        e1.setEmployee_address("Delhi");//need not to save in DB
      /* Remember that you should not call save() method on a persistent entity 
       * (entity associated with any hibernate session).
       *  Any changes done to persistent entity is automatically saved.
      */
        session12.flush();
        tr.commit();
        Session session22 = com.scp.java.HibernateUtil.hibernateUtilMethods.getSessionFactory().openSession();
        Transaction tr2=session22.beginTransaction();
        e2.setEmployee_Name("Sai");
        session22.saveOrUpdate(e2);
       /*if we use save in another session for existing object it will give error 
         thats why  we have to change in the same session or use saveOrUpdate*/
        session22.flush();
        tr2.commit();
       
        /*Session session3=com.scp.java.HibernateUtil.hibernateUtilMethods.getSessionFactory().openSession();
        Query qr=session3.createQuery("from Employee");
        List<Employee> emp_list=qr.list();
        Iterator itr=emp_list.iterator();
        while(itr.hasNext()){
        	System.out.println(itr.next());
        }*/
       
      /* SQLQuery qr=session3.createSQLQuery("select * from Employee_T");
       List<Employee> emp_list=qr.list();
       Iterator itr=emp_list.iterator();
       while(itr.hasNext()){
       	System.out.println(itr.next());
       }
      */ 
       Session session3=com.scp.java.HibernateUtil.hibernateUtilMethods.getSessionFactory().openSession();
       Query query=session3.getNamedQuery(Employee.getEmpById);
            query.setInteger("id",103); 
            Employee emp= (Employee)query.uniqueResult();
            System.out.println(emp);

	   Criteria cr=session3.createCriteria(Employee.class);
	   List<Employee> empList=cr.list();
	   System.out.println(empList);
	
	 }
}
/* Note:-
  1.Once an object is in a persistent state, Hibernate manages updates 
    to the database itself as you change the fields and properties of the object.

  2. saveOrUpdate() can be used with persistent as well as non-persistent 
    entities both.Persistent entities will get updated, and transient
    entities will be inserted into database.
    

  3-i)Newly created POJO object will be in the transient state. 
      Transient object doesn’t represent any row of the database 
      i.e. not associated with any session object. It’s plain simple java object.
  
    iiPersistent object represent one row of the database and always associated with some unique hibernate session.
      Changes to persistent objects are tracked by hibernate and are saved into 
      database when commit call happen.
  iii)Detached objects are those who were once persistent in past, 
      and now they are no longer persistent. To persist changes done in detached
      objects, you must reattach them to hibernate session.
   iv)Removed objects are persistent objects that have been passed
       to the session’s remove() method and soon will be deleted 
       as soon as changes held in the session will be committed to database.
  4.persistance object-from the same Hibernate session returns the same Java instance of a class,
    -more than one Hibernate session, Hibernate will provide distinct instances from each session
     i.e reference are diffrent.   
 
 
 *Hibernate Query
 One reason to use native SQL is that your database supports some special 
 features through its dialect of SQL that are not supported in HQL. 
 Another reason is that you may want to call stored procedures from your Hibernate application.
 *
 */