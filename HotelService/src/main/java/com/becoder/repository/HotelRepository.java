package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.entites.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
