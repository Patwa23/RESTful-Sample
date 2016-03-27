package com.navprayas.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.navprayas.messenger.database.DatabaseClass;
import com.navprayas.messenger.exception.DataNotFoundException;
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
	
	
	//Return a list of message filter by year
	public List<Message> getAllMessagesForYear(int year){
		ArrayList<Message> messageForYear=new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		for(Message msg:messages.values()){
			cal.setTime(msg.getCreated());
			if (cal.get(Calendar.YEAR)==year){
				messageForYear.add(msg);
			}
		}	
	    return messageForYear;
	}
	
	
	//Return a list of message pagination having start point and size
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list=new ArrayList<Message>(messages.values());
		if(start+size>list.size())
			return new ArrayList<Message>();
	    return list.subList(start, start+size);
	}
		
	public Message getMessage(long id){
		Message msg=messages.get(id);
		if(msg==null){
			throw new DataNotFoundException("Message not found for Id :"+id);
		}
		return msg;
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
