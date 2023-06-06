package com.rating.entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class Ratings {

	@Id
	private String ratingId;

	private String userId;

	private String hotelId;

	private int rating;

	private String feedback;

	@Transient
	private Hotel hotel;

}
