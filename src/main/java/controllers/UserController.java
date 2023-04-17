package controllers;

import services.UserServices;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/users")
public class UserController {
    @Inject
    UserServices userServices;

    @GET
    @Path("permit-all")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context SecurityContext ctx) {
        return userServices.getResponseString(ctx);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/user")
    public String postUser(){
        return "post";
    }

}
