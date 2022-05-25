package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.api.dto.User;
import edu.fpdual.webservice.mysql.manager.imp.RegisterManagerImp;
import edu.fpdual.webservice.service.RegisterService;
import jakarta.ws.rs.*;

import jakarta.ws.rs.core.MediaType;

/**
 * @author Ismael Orellana Bello / Pablo Salvador Del Río Vergara
 * @version 1.0
 * Class that controlls the serviceWeb
 */
@Path("/register")
public class RegisterController {
    RegisterService registerService = new RegisterService(new RegisterManagerImp());

    /**
     * Calls RegisterService.class
     *
     * @param user User
     * @return<ol> <li>true boolean - if it's correct</li>
     * <li>false boolean - if it isn't correct</li>
     * </ol>
     */
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
