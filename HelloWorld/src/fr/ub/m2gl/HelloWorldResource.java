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

    	StringBuilder str = new StringBuilder();
    	str.append("<table>");
    	for(int i=0; i<User.showUsers().size(); i++) {
    		str.append("<tr>");
        	str.append(User.showUsers().get(i).toString() + "<br>");
        	str.append("</tr>");
    	}
    	str.append("</table>");
        return  "<h3>"+
        str
        +"</h3>"
        		+ "<form action=\"/HelloWorld/hello3/update\" target=\"_blank\" method=\"GET\">\n" + 
        		"  old name:<br>\n" + 
        		"  <input type=\"text\" name=\"old\" value=\"\">\n" + 
        		"  <br>\n" + 
        		"  new firstName:<br>\n" + 
        		"  <input type=\"text\" name=\"firstname\" value=\"\">\n" + 
        		"  <br>\n" + 
        		"  new Lastname:<br>\n" + 
        		"  <input type=\"text\" name=\"lastname\" value=\"\">\n" + 
        		"  <br><br>\n" + 
        		"  <input type=\"submit\" value=\"update\">\n" + 
        		"</form>";
    }
}

