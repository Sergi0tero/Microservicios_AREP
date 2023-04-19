package services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import entities.Tweet;
import org.bson.Document;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class StreamServices {

    @Inject
    MongoClient mc;

    public List<Tweet> list(){

        int i = 0;
        List<Tweet> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().sort(descending("_id")).iterator();

        try {
            while (cursor.hasNext() && i < 10) {
                Document document = cursor.next();
                Tweet tweet = new Tweet();
                tweet.setId(document.getString("id"));
                tweet.setContent(document.getString("content"));
                list.add(tweet);
                i++;
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void add(Tweet tweet){
        Document document = new Document()
                .append("id", tweet.getId())
                .append("content", tweet.getContent());
        getCollection().insertOne(document);
    }

    private MongoCollection<Document> getCollection(){
        return mc.getDatabase("tweets").getCollection("tweet");
    }

}
