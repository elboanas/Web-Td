package fr.ub.m2gl;

import fr.ub.m2gl.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello3")

public class HelloWorldRessource {
	@Path("/add")
	@GET
	@Produces("text/plain")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getHelloWorld(@QueryParam("firstname") String f, @QueryParam("lastname") String l) {
		String result = User.addUserToMongo(new User(f, l));

		return "Hello World from " + f + " " + l + " " + result;
	}

	@Path("/update")
	@GET
	@Produces("text/html")
	public String updateuser(@QueryParam("firstname") String f, @QueryParam("lastname") String l, @QueryParam("old") String n) {
		String result = User.updateUserToMongo(new User(f, l), n);

		return "Hello World from " + f + " " + l + " " + result;
	}
}