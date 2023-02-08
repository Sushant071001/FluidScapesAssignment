package com.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
