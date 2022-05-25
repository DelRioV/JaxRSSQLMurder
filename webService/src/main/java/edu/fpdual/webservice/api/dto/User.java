package edu.fpdual.webservice.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
 * Class to keep user information
 */
@Getter
@Setter
public class User {

    private String username;
    private String password;
    private int user_code;
    private String email;
}
