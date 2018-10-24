package fr.ub.m2gl;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/hello2")
public class UserRessource  {
	MyObjectMapperProvider myObj = new MyObjectMapperProvider();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void addUser() throws FileNotFoundException, JsonProcessingException  {
    	File file1 = new File("carnet.json");
    	LinkedList<User> userList = new LinkedList<User>();
    	userList.add(new User("anas", "belmekki"));
    	userList.add(new User("zaml", "lmlouky"));
    	try {
			myObj.defaultObjectMapper.writeValue(file1, new User("hh","bb"));
		} catch (IOException e) {
			e.printStackTrace();
		};
    }
}
