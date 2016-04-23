package com.navprayas.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.navprayas.messenger.model.Message;
import com.navprayas.messenger.model.Profile;
import com.navprayas.messenger.model.User;

public class DatabaseClass {
	
	private static Map<Long,Message> messages=new HashMap<>();
	private static Map<String,Profile> profiles=new HashMap<>();
	private static Map<Long,User> users=new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String,Profile> getProfiles(){
		return profiles;
	}
	
	public static Map<Long, User> getUsers() {
		return users;
	}
	

}
