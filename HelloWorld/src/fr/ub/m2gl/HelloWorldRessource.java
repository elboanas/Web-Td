package fr.ub.m2gl;

import fr.ub.m2gl.*;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;

import com.mongodb.client.MongoCursor;
import com.sun.org.apache.xerces.internal.util.URI;

@Path("/User")

public class HelloWorldRessource {
	
	@Path("/add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String getHelloWorld(@QueryParam("firstname") String f, @QueryParam("lastname") String l) {
		String result = MongoUser.addUserToMongo(new User(f, l));

		return result;
	}
	
	@Path("/delete/{firstname}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteUser(@PathParam("firstname") String f) {
		String result = MongoUser.deleteUserFromMongo(f);

		return result;
	}

	@Path("/update")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String updateuser(@QueryParam("firstname") String f, @QueryParam("lastname") String l,
			@QueryParam("old") String n) {
		String result = MongoUser.updateUserToMongo(new User(f, l), n);

		return result;
	}

	@Path("/show")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getHelloWorld() {
 
		return MongoUser.showUsers();
	}
	
	@Path("/{firstname}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String showUser(@PathParam("firstname") String f) {

		return MongoUser.showUser(f);
	}
	
	
	
	
	
	
	
	
	
	
}
