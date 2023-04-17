package services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StreamServices {

    public String greeting() {
        return "stream services ";
    }

}
