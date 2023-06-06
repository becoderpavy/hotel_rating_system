package com.becoder.service;

import java.util.List;

import com.becoder.entites.Hotel;

public interface HotelService {

	Hotel saveHotel(Hotel home);

	Hotel getHotel(String id);

	List<Hotel> getAllHotel();

}
