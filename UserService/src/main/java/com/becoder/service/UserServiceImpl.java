package com.becoder.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.becoder.entites.Hotel;
import com.becoder.entites.Rating;
import com.becoder.external.services.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.becoder.entites.User;
import com.becoder.exception.ResourceNotFoundException;
import com.becoder.repository.UserRepository;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with user id" + userId));

       // Rating[] list = restTemplate.getForObject("http://localhost:8083/ratings/" + user.getUserId(), Rating[].class);

        Rating[] list = restTemplate.getForObject("http://RATING-SERVICE/ratings/" + user.getUserId(), Rating[].class);

        logger.info("{}", list);


        List<Rating> ratingList = Arrays.stream(list).toList().stream().map((rating) -> {
            //http://localhost:8082/hotel/67876715-fa48-4788-b2a6-d2f8e48f244a

           // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/hotel/" + rating.getHotelId(), Hotel.class);

          //  ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(), Hotel.class);

          //  Hotel hotel = forEntity.getBody();
            Hotel hotel=hotelService.getHotel(rating.getHotelId());

            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {
        // TODO Auto-generated method stub

    }

}
