package com.example.HotelService.servieces;

import com.example.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {


    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel get(String id);
}
