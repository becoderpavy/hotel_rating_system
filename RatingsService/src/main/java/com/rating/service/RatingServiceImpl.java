
package com.rating.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entites.Ratings;
import com.rating.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingsService {

	@Autowired
	private RatingRepository ratingRepo;

	@Override
	public Ratings saveRatings(Ratings rating) {
		rating.setRatingId(UUID.randomUUID().toString());
		return ratingRepo.save(rating);
	}

	@Override
	public List<Ratings> getAllRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Ratings> getRatingByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

	@Override
	public List<Ratings> getRatingByUserlId(String userlId) {
		return ratingRepo.findByUserId(userlId);
	}

}

/*
 * public class RatingServiceImpl {
 * 
 * }
 */