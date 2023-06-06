package com.rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.entites.Ratings;
import com.rating.service.RatingsService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingsService ratingsService;

	@PostMapping
	public ResponseEntity<?> createRating(@RequestBody Ratings Rating) {
		return new ResponseEntity<>(ratingsService.saveRatings(Rating), HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/{userId}")
	public ResponseEntity<?> getRatingByUser(@PathVariable String userId) {
		return new ResponseEntity<>(ratingsService.getRatingByUserlId(userId), HttpStatus.OK);
	}

	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<?> getAllRatingByHotel(@PathVariable String hotelId) {
		return new ResponseEntity<>(ratingsService.getRatingByHotelId(hotelId), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllRating() {
		return new ResponseEntity<>(ratingsService.getAllRatings(), HttpStatus.OK);
	}

}
