package fr.ub.m2gl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/form")
public class UserHtml {

		public String form() {
			
			return "<html>"
	        		+ "<body>"
	        		+ "<form action=\"/HelloWorld/hello3\" target=\"_blank\" method=\"GET\">\n" + 
	        		"  First name:<br>\n" + 
	        		"  <input type=\"text\" name=\"firstname\" value=\"\">\n" + 
	        		"  <br>\n" + 
	        		"  Last name:<br>\n" + 
	        		"  <input type=\"text\" name=\"lastname\" value=\"\">\n" + 
	        		"  <br><br>\n" + 
	        		"  <input type=\"submit\" value=\"Submit\">\n" + 
	        		"  <input type=\"submit\" value=\"update\">\n" + 
	        		"</form>"
	        		+ "</body>"
	        		+ "</html>";
			
		}

	    @GET
	    @Produces("text/html")
	    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	    public String getHelloWorld() {
	        return form();
	    }
	}
