package com.ronak.hotel.HotelService.services;


import com.ronak.hotel.HotelService.entities.Hotel;
import org.w3c.dom.html.HTMLObjectElement;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel get(String id);
}
