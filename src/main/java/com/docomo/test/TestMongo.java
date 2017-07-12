package com.docomo.test;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class TestMongo {
	
	public static void main(String[] args) {
		
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database=mongoClient.getDatabase("testMongo");
		//database.createCollection("personas");
		
		MongoCollection<Document> collection=database.getCollection("personas");
		
		//Se indica el tipo de database (String) para solucionar desambiguacion en MongoIterable
		mongoClient.listDatabaseNames().forEach((String item) ->System.out.println(item));

		//Document document= Document.parse("{\"_id\" : 2,\"Nombre\" : \"Fernando\",\"Edad\" : 37}");
		
		/*
		Document document = new Document();
		document.put("_id",new Integer(1));
		document.put("Nombre", "Fernando");
		document.put("Edad", new Integer(37));
		*/
		
		collection.find(Filters.eq("Edad", 37)).forEach((Document documento)->System.out.println(documento.toJson()));

		
		
	}

}
