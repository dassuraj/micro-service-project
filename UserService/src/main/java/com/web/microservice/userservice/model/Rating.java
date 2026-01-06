package com.web.microservice.userservice.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
    private String ratingId;
    private Long userId;
    private String hotelId;
    private int rating;
    private String feedback;

    private Hotel hotel;

}
