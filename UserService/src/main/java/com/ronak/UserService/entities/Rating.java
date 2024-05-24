package com.ronak.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmOneToManyCollectionElementType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}
