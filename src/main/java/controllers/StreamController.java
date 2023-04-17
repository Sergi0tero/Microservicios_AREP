package controllers;

import services.StreamServices;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/stream")
public class StreamController {

    @Inject
    StreamServices streamServices;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return streamServices.greeting();
    }
}
