package com.brs.service;

import java.util.List;

import com.brs.entity.Admin;
import com.brs.entity.Reservation;

public interface IAdminService {
	public String signOut();
	public Admin signIn(String username, String password);
	
	public Admin updateAdmin(Integer id, Admin admin);
	List<Reservation> getAllReservation();

   List<Reservation> getReservationByUser(Long userid);
public Admin updateAdmin(int parseInt, Admin admin);

}