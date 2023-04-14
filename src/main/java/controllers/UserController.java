package controllers;

import services.UserServices;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UserController {
    @Inject
    UserServices userServices;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "User post";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user")
    public String postUser(){
        return "post";
    }

}
