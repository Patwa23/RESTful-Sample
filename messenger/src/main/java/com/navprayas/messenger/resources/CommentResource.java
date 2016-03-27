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
import javax.ws.rs.core.MediaType;

import com.navprayas.messenger.model.Comment;
import com.navprayas.messenger.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private CommentService cmntService=new CommentService();

	@GET
	public List<Comment> getAllComments(@PathParam("messageId")long msgId){
		return cmntService.getAllComments(msgId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId")long msgId,Comment comment){
		return cmntService.addComment(msgId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId")long msgId, @PathParam("commentId")long commentId,Comment comment){
		comment.setId(commentId);
		return cmntService.updateComment(msgId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public Comment delete(@PathParam("messageId")long msgId, @PathParam("commentId")long commentId,Comment comment){
		return cmntService.removeComment(msgId, commentId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComments(@PathParam("messageId")long msgId,@PathParam("commentId")long commentId){
		return cmntService.getComment(msgId, commentId);
	}
}
	
	
