package com.navprayas.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.navprayas.messenger.model.Message;
import com.navprayas.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService msgService=new MessageService();
	
	//Select all Message
	/*@GET
	public List<Message> getMessages(){
		return msgService.getAllMessages();
	}*/
	
	
	//Select all Message
	@GET
	public List<Message> getMessages(@QueryParam("year")int year,
									 @QueryParam("start")int start,
									 @QueryParam("size")int size){
		if(year>0){
			return msgService.getAllMessagesForYear(year);
		}
		if(start>=0 && size>=0){
			return msgService.getAllMessagesPaginated(start, size);
		}
		return msgService.getAllMessages();
	}
		
		
	//Create or Add Message
	@POST	
	public Message addMessage(Message msg){
		return msgService.addMessage(msg);
	}
	
	//Update by Id
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message msg){
		msg.setId(id);
		return msgService.updateMessage(msg);
	}
	
	//Delete by Id
	@DELETE
	@Path("/{messageId}")
	public Message removeMessage(@PathParam("messageId")long id){
		return msgService.removeMessage(id);
	}
	
	//Select Message by Id
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id){
		return msgService.getMessage(id);		
	}
	

}
