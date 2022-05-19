package edu.fpdual.webservice.mysql.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String username;
    private String password;
    private int user_code;
    private String email;
}
