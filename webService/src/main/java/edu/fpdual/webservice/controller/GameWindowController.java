package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.mysql.manager.imp.QueryRecoverManagerImp;
import edu.fpdual.webservice.controller.service.GameWindowService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path("/game")
public class GameWindowController {

    private GameWindowService gameWindowService = new GameWindowService(new QueryRecoverManagerImp());

    @GET
    @Path("/get/{query}/{usercode}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ArrayList<String>> loginUser(@PathParam("query") String query,@PathParam("usercode")int user_code) {
        return gameWindowService.queryRecover(query,user_code);
    }

    @GET
    @Path("/getusercode/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public int getUsercode(@PathParam("username") String username) {
        return gameWindowService.usercodeRecover(username);
    }
}

