package com.navprayas.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.navprayas.messenger.model.Message;
import com.navprayas.messenger.model.Profile;

public class DatabaseClass {
	
	private static Map<Long,Message> messages=new HashMap<>();
	private static Map<String,Profile> profiles=new HashMap<>();
	/**
	 * @return the messages
	 */
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String,Profile> getProfiles(){
		return profiles;
	}
	

}
