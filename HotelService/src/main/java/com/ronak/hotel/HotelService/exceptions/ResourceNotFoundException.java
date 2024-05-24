package com.ronak.hotel.HotelService.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String string) {

        super(string);
    }

    public ResourceNotFoundException(){
        super("Resource not found!!!!");
    }
}
