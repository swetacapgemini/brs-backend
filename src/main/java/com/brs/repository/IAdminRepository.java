package com.brs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brs.entity.Admin;



@Repository
public interface IAdminRepository extends JpaRepository<Admin,Integer>{

}