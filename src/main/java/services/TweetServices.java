package services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TweetServices {


    public String greeting() {
        return "tweet services ";
    }

}
