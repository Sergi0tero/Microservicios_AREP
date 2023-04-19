package entities;


public class Tweet {

    private String id;
    private String content;
    private User user;

    public Tweet(){

    }

    public Tweet(String id, String content, User user) {
        this.id = id;
        this.content = content;
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String date) {
        this.id = id;
    }
}