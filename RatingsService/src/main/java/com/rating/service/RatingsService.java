package com.rating.service;

import java.util.List;

import com.rating.entites.Ratings;

public interface RatingsService {

	Ratings saveRatings(Ratings rating);

	List<Ratings> getAllRatings();

	List<Ratings> getRatingByHotelId(String hotelId);

	List<Ratings> getRatingByUserlId(String userlId);

}
