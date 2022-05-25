package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.mysql.manager.imp.QueryRecoverManagerImp;
import edu.fpdual.webservice.service.GameWindowService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

/**
 * @author Ismael Orellana Bello / Pablo Salvador Del Río Vergara
 * @version 1.0
 * Class that controlls the serviceWeb
 */
@Path("/game")
public class GameWindowController {

    private GameWindowService gameWindowService = new GameWindowService(new QueryRecoverManagerImp());

    /**
     * Method that receive the connection and redirected into GameWindowService.class
     *
     * @param query     String
     * @param user_code int
     * @return ArrayList with String
     */
    @GET
    @Path("/get/{query}/{usercode}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ArrayList<String>> queryRecover(@PathParam("query") String query, @PathParam("usercode") int user_code) {
        return gameWindowService.queryRecover(query, user_code);
    }

    /**
     * Method that receive the connection and redirected into GameWindowService.class
     *
     * @param username String
     * @return the user_code
     */
    @GET
    @Path("/getusercode/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public int getUsercode(@PathParam("username") String username) {
        return gameWindowService.usercodeRecover(username);
    }
}

