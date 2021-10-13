package com.brs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brs.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	

	

}