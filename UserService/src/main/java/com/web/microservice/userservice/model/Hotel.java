package com.web.microservice.userservice.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    private Long id;

    private String name;

    private String location;

    private String about;

}
