package com.navprayas.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.navprayas.messenger.database.DatabaseClass;
import com.navprayas.messenger.model.Message;

public class MessageService {
	
	
	private Map<Long,Message> messages=DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L,new Message(1,"Prakash","Test Author-1"));
		messages.put(2L,new Message(2,"Patwa","Test Author-2"));
		
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message msg){
		msg.setId(messages.size()+1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg){
		if(msg.getId()<=0){
			return null;
		}
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message removeMessage(long id){				
		return messages.remove(id);
	}

}
