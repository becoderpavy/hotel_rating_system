package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.entites.User;

public interface UserRepository extends JpaRepository<User, String> {

}
