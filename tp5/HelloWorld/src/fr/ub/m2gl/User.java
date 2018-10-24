package fr.ub.m2gl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

import java.util.ArrayList;
import java.util.List;

import org.bson.BasicBSONObject;
import org.bson.Document;

public class User {
	private String firstName;
	private String lastName;
	
	public User(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public static  String addUserToMongo(User us) {
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient();
		    MongoDatabase db = mongoClient.getDatabase("userDb");
		    MongoCollection<Document> collection = db.getCollection("userCollection");

		    ObjectMapper mapper = new ObjectMapper();
		    String jsonString = mapper.writeValueAsString(us);
		    Document doc = Document.parse(jsonString);
		    collection.insertOne(doc);
		    return "Utilisateur " + us.getFirstName() + " " + us.getLastName() + " added successfully.";
		} catch (Exception e) {
		    e.printStackTrace();
		} finally{
		    mongoClient.close();
		}
		return "failed";
	}
	
	public static  List<String> showUsers() {
		List<String> userList = new ArrayList<String>();
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient();
		    MongoDatabase db = mongoClient.getDatabase("userDb");
		    MongoCollection<Document> collection = db.getCollection("userCollection");
		    
		    
		    FindIterable<Document> fi = collection.find();//.projection(Projections.exclude("_id"));
		    MongoCursor<Document> cursor = fi.iterator();
		    while(cursor.hasNext()) {
		    	Document o =  cursor.next();
		    	userList.add( (String) o.get("firstName"));
		    	userList.add( (String) o.get("lastName"));
		    	
		    }
		    cursor.close();
		} catch (Exception e) {
		    e.printStackTrace();
		} finally{
		    mongoClient.close();
		}
		return  userList;
	}


	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
