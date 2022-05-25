package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.mysql.manager.imp.LoginSuccesfulManagerImp;
import edu.fpdual.webservice.service.LoginService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

/**
 * @author Ismael Orellana Bello / Pablo Salvador Del Río Vergara
 * @version 1.0
 * Class that controlls the serviceWeb
 */
@Path("/login")

public class LoginController {

    private LoginService loginService = new LoginService(new LoginSuccesfulManagerImp());

    /**
     * Method that permit the log in
     *
     * @param username String
     * @param password String
     * @return <ol>
     * <li>true boolean - if it's correct</li>
     * <li>false boolean - if it isn't correct</li>
     * </ol>
     */
    @GET
    @Path("/get/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean loginUser(@PathParam("username") String username, @PathParam("password") String password) {
        if (loginService.logIn(username, password)) {
            return new Boolean(true);
        } else {
            return new Boolean(false);
        }
    }
}
