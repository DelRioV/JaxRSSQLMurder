package edu.fpdual.webservice.api.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    private int id;
    private String title;
    private String body;

}
