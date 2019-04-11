package org.shashank.kumar.messenger.resources;

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

import org.shashank.kumar.messenger.model.Message;
import org.shashank.kumar.messenger.model.Profile;
import org.shashank.kumar.messenger.service.profileService;

@Path("/profiles")
public class profileResource {

	public profileResource() {
		// TODO Auto-generated constructor stub
	}

	profileService pS = new profileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAllProfiles() {

		return pS.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getProfile(@PathParam("profileName") String profileName) {

		return pS.getProfile(profileName);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object addProfile(Profile Profile) {

		return pS.addProfile(Profile);
	}
	
	@PUT
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object updateProfile(Profile Profile,@PathParam("profileName") String profileName) {
		
		Profile.setProfileName(profileName);;
		return pS.updateProfile(Profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object deleteProfile(@PathParam("profileName") String profileName) {

		return pS.deleteProfile(profileName);
	}

}
