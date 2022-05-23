package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.mysql.manager.imp.LoginSuccesfulManagerImp;
import edu.fpdual.webservice.mysql.manager.imp.ModelInfoManagerImp;
import edu.fpdual.webservice.service.LoginService;
import edu.fpdual.webservice.service.TutorialService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path("/tutorial")
public class TutorialController {

    private TutorialService tutorialService = new TutorialService(new ModelInfoManagerImp());

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<String> loginUser() {
        return tutorialService.returnModelMessage();
    }

}
