package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.api.dto.User;
import edu.fpdual.webservice.mysql.manager.imp.RegisterManagerImp;
import edu.fpdual.webservice.controller.service.RegisterService;
import jakarta.ws.rs.*;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/register")
public class RegisterController {
    RegisterService registerService = new RegisterService(new RegisterManagerImp());

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }

    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean createUser(User user) {
        if (registerService.createUser(user)) {
            return new Boolean(true);
        } else {
            return new Boolean(false);
        }
    }
}
