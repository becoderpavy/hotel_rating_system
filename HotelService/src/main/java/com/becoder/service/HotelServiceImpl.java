package com.becoder.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.becoder.entites.Hotel;
import com.becoder.exception.ResourceNotFoundException;
import com.becoder.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		hotel.setId(UUID.randomUUID().toString());
		return hotelRepo.save(hotel);
	}

	@Override
	public Hotel getHotel(String id) {
		return hotelRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel id not found with id" + id));
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepo.findAll();
	}

}
