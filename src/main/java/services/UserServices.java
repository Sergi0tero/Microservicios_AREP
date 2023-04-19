package services;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import entities.Tweet;
import entities.User;
import org.bson.Document;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Sorts.descending;

@ApplicationScoped
public class UserServices {

    @Inject
    MongoClient mc;

    public List<User> list(){

        List<User> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                User user = new User();
                user.setUserId(document.getString("userID"));
                user.setPwd(document.getString("password"));
                list.add(user);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void add(User user){
        Document document = new Document()
                .append("userId", user.getUserId())
                .append("password", user.getPwd());
        getCollection().insertOne(document);
    }

    private MongoCollection<Document> getCollection(){
        return mc.getDatabase("tweets").getCollection("users");
    }

}
