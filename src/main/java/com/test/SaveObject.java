package com.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Employee;
import com.utility.Utility;


public class SaveObject {
	public static int save(Employee emp){
		//get the session object
		Session  ses = Utility.getSession();
		Transaction tx= null;
		Integer count=0;
		try(ses){
			//Bring the transaction
			tx=ses.beginTransaction();
			
			//save the object
			count =(Integer)ses.save(emp);
			
			
			//commit the transaction	
			tx.commit();
			
		}catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			
		}
		
		return count;
	}


}
