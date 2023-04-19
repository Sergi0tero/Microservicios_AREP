package controllers;

import entities.Tweet;
import entities.User;
import services.UserServices;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/users")
public class UserController {
    @Inject
    UserServices userServices;

    @GET
    public List<User> list() {
        return userServices.list();
    }

    @POST
    public Response add(User user){
        userServices.add(user);
        return Response.status(Response.Status.CREATED).build();
    }

}
