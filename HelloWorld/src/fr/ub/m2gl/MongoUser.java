package fr.ub.m2gl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoUser {

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
	
	public static  String updateUserToMongo(User us, String newFirst) {
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient();
		    MongoDatabase db = mongoClient.getDatabase("userDb");
		    MongoCollection<Document> collection = db.getCollection("userCollection");

		    ObjectMapper mapper = new ObjectMapper();
		    String jsonString = mapper.writeValueAsString(us);
		    Document doc2 = Document.parse(jsonString);
		    Document doc1 = new Document("firstName",newFirst); ///name to modifiy
		    collection.updateOne(doc1, new Document("$set", doc2));
		    return "Utilisateur " + us.getFirstName() + " " + us.getLastName() + " updated successfully.";
		} catch (Exception e) {
		    e.printStackTrace();
		} finally{
		    mongoClient.close();
		}
		return "failed";
	}
	
	public static  List<User> showUsers() {
		List<User> userList = new ArrayList<User>();
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient();
		    MongoDatabase db = mongoClient.getDatabase("userDb");
		    MongoCollection<Document> collection = db.getCollection("userCollection");
		    
		    
		    FindIterable<Document> fi = collection.find();//.projection(Projections.exclude("_id"));
		    MongoCursor<Document> cursor = fi.iterator();
		    while(cursor.hasNext()) {
		    	Document o =  cursor.next();
		    	
		    	userList.add( new User( (String) o.get("firstName"), (String) o.get("lastName")));
		    	//userList.add( (String) o.get("lastName"));
		    	
		    }
		    cursor.close();
		} catch (Exception e) {
		    e.printStackTrace();
		} finally{
		    mongoClient.close();
		}
		return  userList;
	}
}
