package com.navprayas.messenger.database;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.navprayas.messenger.exception.DataNotFoundException;
import com.navprayas.messenger.model.Profile;
import com.navprayas.messenger.model.User;

public class HibernateDb {
	
	   private static SessionFactory sessionFactory=createConfiguration();
	   	   
	   /* Method to CREATE an configuration in the database */
	   public static SessionFactory createConfiguration(){
	      try{
	         return sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
	      }catch (Throwable ex) { 
	         throw new ExceptionInInitializerError(ex); 
	      }
	   }
	
//-----------------------------------------------USER START----------------------------------------------------	
	/* Method to CREATE an user in the database */
	   public User addUser(User user){
	      Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.save(user); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return user;
	   }
	   
	   /* Method to  GET a user */
	   public User getUser(long uId){
		   if(uId<=0){
				throw new DataNotFoundException("User not registered with Id :"+uId);
			}
	      Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      User user=null;
	      try{
	         tx = session.beginTransaction();
	         user=(User)session.get(User.class, uId);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	    return user;
	   }
	   
	   /* Method to  READ all the users */
	   public List<User> getAllUser( ){
	      Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      List<User> users=null;
	      try{
	         tx = session.beginTransaction();
	         users = session.createQuery("FROM User").list(); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	    return users;
	   }
	   
	   /* Method to UPDATE an user */
	   public User updateUser(User user){
		  if(user.getUserId()<=0){
			  return null;
		  }
	      Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
			 session.update(user); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	    return user;
	   }
	  
	   /* Method to DELETE an user from the records */
	   public User removeUser(long uId){
		  if(uId<=0){
			return null;
		  }
	      Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      User user =null;
	      try{
	         tx = session.beginTransaction();
	         user=(User)session.get(User.class, uId);
	         session.delete(user); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	     return user;
	   }
	 //-----------------------------------------------USER END----------------------------------------------------	
	   
	 //-----------------------------------------------PROFILE START----------------------------------------------------	   
	   /* Method to  READ all the Profile */
		public List<Profile> getAllProfiles() {
		      Session session = sessionFactory.openSession();
		      Transaction tx = null;
		      List<Profile> profiles=null;
		      try{
		         tx = session.beginTransaction();
		         profiles=session.createQuery("FROM Profile").list(); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		     return profiles;
		   }
		
		/* Method to FIND an Profile in the database  by name*/
		public Profile getProfile(String profileName) {			
			List<Profile> profiles =getAllProfiles();
		    Profile profile = null;
		    for (Iterator iterator = profiles.iterator();iterator.hasNext();){
		       profile = (Profile) iterator.next();
		       if(profile.getProfileName()==profileName){
		    	   break;
		       }
		    }	         	      		
			return profile;
			//return profiles.get(profileName);
		}
		
		 /* Method to CREATE an Profile in the database */
		public Profile addProfile(Profile profile) {
			Session session = sessionFactory.openSession();
		    Transaction tx = null;
			try{
		         tx = session.beginTransaction();
		         session.save(profile);		         
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }		
			return profile;
		}

		public Profile updateProfile(Profile profile) {
			if (profile.getProfileName().isEmpty()) {
	        	return null;
	        }
			Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    try{
		        tx = session.beginTransaction(); 		        
		        session.update(profile); 
		        tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
			return profile;	   
		}
		
		/* Method to DELETE an Profile from the records */
		public Profile removeProfile(String profileName) {
			if(StringUtils.isBlank(profileName)){
				return null;
			  }
		      Session session = sessionFactory.openSession();
		      Transaction tx = null;
		      Profile profile = null;
		      try{
		         tx = session.beginTransaction();
		         profile=getProfile(profileName);
		         session.delete(profile); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		    return profile;
		}
		//-----------------------------------------------PROFILE END----------------------------------------------------	
}
