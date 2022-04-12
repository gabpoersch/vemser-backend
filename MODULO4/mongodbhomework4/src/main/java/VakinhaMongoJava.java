import com.mongodb.client.*;

import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Arrays;

public class VakinhaMongoJava {
        public static void main(String[] args) {

            String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
            MongoClient mongoClient = MongoClients.create(uri);

            MongoDatabase mongoDatabase = mongoClient.getDatabase("vem_ser");

            MongoCollection<Document> users = mongoDatabase.getCollection("users");
            MongoCollection<Document> requests = mongoDatabase.getCollection("requests");


            //INSERTS
            //USERS

            Document newUser = new Document("id_user", 1)
                    .append("name", "admin")
                    .append("email", "admin")
                    .append("password", "$2a$12$sTeLTyUMe0kdZVV8/u8.2.XvCwNJjW9RvQLwpY2EGNDxF93Y/BXq2")
                    .append("type", "false")
                    .append("document", "73775006036");

            Document newUser2 = new Document("id_user", 2)
                    .append("name", "liane")
                    .append("email", "liane@gmail.com")
                    .append("password", "$2a$12$/LF56HvufCT8nWshxZxe1.e47PwrXUTD57YncMTOMsEc1QbInekUu")
                    .append("type", "false")
                    .append("document", "23156682047");

            System.out.println("\nINSERT USERS");
            users.insertMany(Arrays.asList(newUser,newUser2));


            //VAKINHAS
            Document newRequest = new Document("id_request", 1)
                    .append("id_user", 1)
                    .append("title", "Vakinha1")
                    .append("request_description", "Ajude os necessitados1")
                    .append("goal", 10000)
                    .append("reached_value", 10000)
                    .append("status_request", false);

            Document newRequest2 = new Document("id_request", 2)
                    .append("id_user", 2)
                    .append("title", "Vakinha2")
                    .append("request_description", "Ajude os necessitados2")
                    .append("goal", 20000)
                    .append("reached_value", 20000)
                    .append("status_request", false);

            Document newRequest3 = new Document("id_request", 3)
                    .append("id_user", 2)
                    .append("title", "Vakinha3")
                    .append("request_description", "Ajude os necessitados3")
                    .append("goal", 30000)
                    .append("reached_value", 30000)
                    .append("status_request", false);

            System.out.println("\nINSERT VAKINHA");
            requests.insertOne(newRequest);
            System.out.println("\nINSERT VAKINHA2");
            requests.insertOne(newRequest2);
            System.out.println("\nINSERT VAKINHA3");
            requests.insertOne(newRequest3);


            //FINDS

            System.out.println("\nFIND ADMIN");
            Document admin = users.find(new Document("name" , "admin")).first();
            System.out.println(admin.toJson());

            System.out.println("\nFIND VAKINHA < 20000");
            Document vakinhaLte20k = requests.find(new Document("goal" , new Document("$lt",20000))).first();
            System.out.println(vakinhaLte20k.toJson());


            //UPDATES

            System.out.println("\nUPDATE LIANE");
            users.updateOne(Filters.eq("name","liane"), new Document("$set", new Document("name", "lianenova")));

            System.out.println("\nUPDATE VAKINHA PRA 9999");
            requests.updateOne(Filters.eq("goal",10000), new Document("$set", new Document("reached_value", 9999)));

            //DELETES
            System.out.println("\nDELETES");
            requests.deleteMany(new Document());
            users.deleteOne(Filters.eq("name", "lianenova"));
        }
}

