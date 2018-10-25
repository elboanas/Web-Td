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

@Path("/User")

public class HelloWorldRessource {
	@Path("/add")
	@POST
	@Produces("text/plain")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getHelloWorld(@FormParam("firstname") String f, @FormParam("lastname") String l) {
		String result = MongoUser.addUserToMongo(new User(f, l));

		return "Hello World from " + f + " " + l + " " + result;
	}

	@Path("/update")
	@GET
	@Produces("text/html")
	public String updateuser(@QueryParam("firstname") String f, @QueryParam("lastname") String l,
			@QueryParam("old") String n) {
		String result = MongoUser.updateUserToMongo(new User(f, l), n);

		return "Hello World from " + f + " " + l + " " + result;
	}

	@Path("/show")
	@GET
	@Produces("text/html")
	public String getHelloWorld() {

		StringBuilder str = new StringBuilder();
		str.append("<html>");
		str.append("<head>");
		str.append("<style>"
				+ "#table-json {\n" + "    font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n"
				+ "    border-collapse: collapse;\n" + "    width: 100%;\n" + "}\n" + "\n"
				+ "#table-json td, #table-json th {\n" + "    border: 1px solid #ddd;\n" + "    padding: 8px;\n" + "}\n"
				+ "\n" + "#table-json tr:nth-child(even){background-color: #f2f2f2;}\n" + "\n"
				+ "#table-json tr:hover {background-color: #ddd;}\n" + "\n" + "#table-json th {\n"
				+ "    padding-top: 12px;\n" + "    padding-bottom: 12px;\n" + "    text-align: left;\n"
				+ "    background-color: #4CAF50;\n" + "    color: white;\n" + "}"
						+ "</style>");
		str.append("</head>");
		str.append("<body>");
		str.append("<table id=\"table-json\">");
		str.append("<tr>");
		str.append("<td>FIRSTNAME</td>");
		str.append("<td>LASTNAME</td>");
		str.append("</tr>");
		for (int i = 0; i < MongoUser.showUsers().size(); i++) {
			str.append("<tr>");
			str.append("<td>" + MongoUser.showUsers().get(i).getFirstName() + "</td>");
			str.append("<td>" + MongoUser.showUsers().get(i).getLastName() + "</td>");
			str.append("</tr>");
		}
		str.append("</table>");
		return "<h3>" + str + "</h3>" + "<form action=\"/HelloWorld/hello/update\" target=\"_blank\" method=\"GET\">\n"
				+ "  old name:<br>\n" + "  <input type=\"text\" name=\"old\" value=\"\">\n" + "  <br>\n"
				+ "  new firstName:<br>\n" + "  <input type=\"text\" name=\"firstname\" value=\"\">\n" + "  <br>\n"
				+ "  new Lastname:<br>\n" + "  <input type=\"text\" name=\"lastname\" value=\"\">\n" + "  <br><br>\n"
				+ "  <input type=\"submit\" value=\"update\">\n" + "</form>" + "</body> " + "</html>";
	}
}
