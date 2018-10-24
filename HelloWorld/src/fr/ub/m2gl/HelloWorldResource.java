package fr.ub.m2gl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloWorldResource {
    @GET
    @Produces("text/html")
    public String getHelloWorld() {

        return  "<h3>"+User.showUsers().toString() +"</h3>";
    }
}

