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

import com.navprayas.messenger.model.Profile;
import com.navprayas.messenger.model.User;
import com.navprayas.messenger.resources.bean.UserService;
import com.navprayas.messenger.service.ProfileService;

@Path("/users")
@Consumes(value={MediaType.APPLICATION_JSON,MediaType.TEXT_XML})  //Content-Type ->@Consumes
@Produces(value={MediaType.APPLICATION_JSON,MediaType.TEXT_XML}) //Accepts -> @Produces
public class UserResource {

	
	private UserService userService=new UserService();
	
	//Select all User
		@GET
		public List<User> getUsers(){
			return userService.getAllUser();
		}
		
		//Create or Add User
		@POST	
		public User addUser(User user){
			return userService.addUser(user);
		}
		
		//Update by userId
		@PUT
		@Path("/{userId}")
		public User updateProfile(@PathParam("userId")int uId,User user){
	
			return userService.updateUser(user);
		}
		
		//Delete by userId
		@DELETE
		@Path("/{userId}")
		public User removeUser(@PathParam("userId")int uId){
			return userService.removeUser(uId);
		}
		
		//Select User by userId
		@GET
		@Path("/{userId}")
		public User getProfile(@PathParam("userId")int uId){
			return userService.getUser(uId);		
		}

}
