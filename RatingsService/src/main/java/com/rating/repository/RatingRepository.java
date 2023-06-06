package com.rating.repository;

import java.util.List;

import com.rating.entites.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Ratings, String> {

	List<Ratings> findByUserId(String userId);

	List<Ratings> findByHotelId(String hotelId);
}
