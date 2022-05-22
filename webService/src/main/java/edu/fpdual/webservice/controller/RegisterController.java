package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.api.dto.User;
import edu.fpdual.webservice.mysql.manager.imp.RegisterManagerImp;
import edu.fpdual.webservice.service.UserService;
import jakarta.ws.rs.*;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/register")
public class RegisterController {
    UserService userService = new UserService(new RegisterManagerImp());

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }

    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        if (userService.createUser(user)) {
            return Response.status(201).entity(user).build();
        } else {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }
}
