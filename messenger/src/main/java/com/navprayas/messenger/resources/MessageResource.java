package com.navprayas.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.navprayas.messenger.model.Message;
import com.navprayas.messenger.resources.bean.MessageFilterBean;
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
	public List<Message> getMessages(@BeanParam MessageFilterBean msgFilterBean){
		if(msgFilterBean.getYear()>0){
			return msgService.getAllMessagesForYear(msgFilterBean.getYear());
		}
		if(msgFilterBean.getStart()>=0 && msgFilterBean.getSize()>=0){
			return msgService.getAllMessagesPaginated(msgFilterBean.getStart(), msgFilterBean.getSize());
		}
		return msgService.getAllMessages();
	}
		
		
	//Create or Add Message
	@POST	
	public Response addMessage(Message msg ,@Context UriInfo uriInfo) throws URISyntaxException{
	 Message newMessage=msgService.addMessage(msg);
	/* return Response.status(Status.CREATED)
	 		 .entity(newMessage)
	 		 .build();*/
	 
	/* return Response.created(new URI("/messenger/webapi/messages/"+newMessage.getId()))
	 		 .entity(newMessage)
	 		 .build();*/
	 String msgId=String.valueOf(newMessage.getId());
	 URI uri=uriInfo.getAbsolutePathBuilder().path(msgId).build();
	 return Response.created(uri)
			 	    .entity(newMessage)
			 	    .build();
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
	

	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
}
