package edu.fpdual.webservice.exception;

/**
 * @author Pablo Salvador Del Río Vergara / Ismael Orellana Bello
 * @version 1.0
 * Class that is use as an exception for LoginService.java
 */
public class ExceptionPersonal extends Throwable {

    public ExceptionPersonal(String username) {
        System.out.println("Error, misinformation\n" + username + " is not registered or your password is wrong");
    }
}
