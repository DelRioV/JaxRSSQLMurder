package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.mysql.manager.imp.ModelInfoManagerImp;
import edu.fpdual.webservice.service.TutorialService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

/**
 * @author Ismael Orellana Bello / Pablo Salvador Del Río Vergara
 * @version 1.0
 * Class that controlls the serviceWeb
 */
@Path("/tutorial")
public class TutorialController {

    private TutorialService tutorialService = new TutorialService(new ModelInfoManagerImp());

    /**
     * Give back the information
     *
     * @return ArrayList with texts that will use the program
     */
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<String> loginUser() {
        return tutorialService.returnModelMessage();
    }

}
