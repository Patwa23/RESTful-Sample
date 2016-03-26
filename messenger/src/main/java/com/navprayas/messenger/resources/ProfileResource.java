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

import com.navprayas.messenger.model.Message;
import com.navprayas.messenger.model.Profile;
import com.navprayas.messenger.service.ProfileService;
@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService profileService=new ProfileService();
	
	//Select all Profile
		@GET
		public List<Profile> getProfiles(){
			return profileService.getAllProfiles();
		}
		
		//Create or Add Profile
		@POST	
		public Profile addProfile(Profile profile){
			return profileService.addProfile(profile);
		}
		
		//Update by profileName
		@PUT
		@Path("/{profileName}")
		public Profile updateProfile(@PathParam("profileName")String pName,Profile profile){
			profile.setProfileName(pName);
			return profileService.updateProfile(profile);
		}
		
		//Delete by profileName
		@DELETE
		@Path("/{profileName}")
		public Profile removeProfile(@PathParam("profileName")String pName){
			return profileService.removeProfile(pName);
		}
		
		//Select Profile by profileName
		@GET
		@Path("/{profileName}")
		public Profile getProfile(@PathParam("profileName")String pName){
			return profileService.getProfile(pName);		
		}

}
