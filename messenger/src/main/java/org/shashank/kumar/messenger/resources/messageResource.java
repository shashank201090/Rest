package org.shashank.kumar.messenger.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.shashank.kumar.messenger.model.Message;
import org.shashank.kumar.messenger.service.messageService;

@Path("/messages")
public class messageResource {

	messageService mS = new messageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages() {

		return mS.getAllMessages();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessagesByYear(@QueryParam("year") int year) {

		return mS.getAllMessagesByYear(year);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getMessages(@PathParam("id") long id,@CookieParam("name") String name) {
		
		System.out.println(name);
		return mS.getMessage(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object addMessage(Message message) {

		return mS.addMessage(message);
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object updateMessage(Message message,@PathParam("id") long id) {
		
		message.setId(id);
		return mS.updateMessage(message);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object deleteMessage(@PathParam("id") long id) {

		return mS.deleteMessage(id);
	}

}
