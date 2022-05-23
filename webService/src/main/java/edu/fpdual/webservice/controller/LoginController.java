package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.api.dto.User;
import edu.fpdual.webservice.mysql.manager.imp.LoginSuccesfulManagerImp;
import edu.fpdual.webservice.service.LoginService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/login")

public class LoginController {

    private LoginService loginService = new LoginService(new LoginSuccesfulManagerImp());

    @GET
    @Path("/get/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean loginUser(@PathParam("username") String username,@PathParam("password") String password) {
        if (loginService.logOn(username,password)) {
            return new Boolean(true);
        } else {
            return new Boolean(false);
        }
    }
}
