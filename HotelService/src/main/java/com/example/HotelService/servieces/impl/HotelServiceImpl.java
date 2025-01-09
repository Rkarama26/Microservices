package com.example.HotelService.servieces.impl;

import com.example.HotelService.entities.Hotel;
import com.example.HotelService.exception.ResourceNotFoundException;
import com.example.HotelService.repositories.HotelRepository;
import com.example.HotelService.servieces.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String randomId = UUID.randomUUID().toString();
        hotel.setId(randomId);
      return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel Not Found With Id " +id));
    }
}
