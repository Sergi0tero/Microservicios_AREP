package controllers;

import entities.Tweet;
import services.StreamServices;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/stream")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StreamController {

    @Inject
    StreamServices streamServices;

    @GET
    public List<Tweet> list() {
        return streamServices.list();
    }

    @POST
    public Response add(Tweet tweet){
        streamServices.add(tweet);
        return Response.status(Response.Status.CREATED).build();
    }
}
