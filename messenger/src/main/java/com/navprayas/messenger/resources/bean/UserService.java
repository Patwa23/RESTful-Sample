package com.navprayas.messenger.resources.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.navprayas.messenger.database.DatabaseClass;
import com.navprayas.messenger.database.HibernateDb;
import com.navprayas.messenger.exception.DataNotFoundException;
import com.navprayas.messenger.model.Message;
import com.navprayas.messenger.model.Profile;
import com.navprayas.messenger.model.User;

public class UserService {
	
	//private Map<Long,User> users=DatabaseClass.getUsers();
	private HibernateDb hDB=new HibernateDb();
	
	public UserService(){
		Profile profile=new Profile("TestProfile","Test","Patwa");
		User newUser=new User("TestUser");		
		newUser.setProfile(profile);
		hDB.addProfile(profile);
		addUser(newUser);
	}
	
	public List<User> getAllUser(){
		return hDB.getAllUser();
	}
			
	public User getUser(long uId){
		User user=hDB.getUser(uId);
		if(user==null){
			throw new DataNotFoundException("User not registered with Id :"+uId);
		}
		return user;
	}
	
	public User addUser(User user){	
		return hDB.addUser(user);
	}
	
	public User updateUser(User user){		
		return hDB.updateUser(user);
	}
	
	public User removeUser(long uId){				
		return hDB.removeUser(uId);
	}

}
