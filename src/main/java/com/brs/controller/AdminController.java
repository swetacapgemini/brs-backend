 package com.brs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brs.entity.Admin;
import com.brs.entity.Bus;
import com.brs.entity.Reservation;
import com.brs.entity.Route;
import com.brs.exceptions.AdminNotFoundException;
import com.brs.exceptions.BusNotFoundException;
import com.brs.exceptions.ReservationNotFoundException;
import com.brs.exceptions.RouteNotFoundException;
import com.brs.service.IAdminService;
import com.brs.service.IBusService;
import com.brs.service.IReservationService;
import com.brs.service.IRouteService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:3000")
public class AdminController {
	
	@Autowired
	private IAdminService adminservice;
	
	@Autowired
	private IReservationService reservationservice;
	
	@Autowired
	private IRouteService routeservice;

	@Autowired
	private IBusService busService;
	
	//Admin Login
	@PostMapping("/login")
	public ResponseEntity<Admin> signIn(@RequestBody Admin admin){
		Admin temp = adminservice.signIn(admin.getAdminUsername(),admin.getAdminPassword());
		return new ResponseEntity<Admin>(temp,HttpStatus.OK);
	}
	
	//Admin logout
	@GetMapping("/logout")
	public ResponseEntity<String> signOut(){
		String temp = adminservice.signOut();
		return new ResponseEntity<String>(temp,HttpStatus.OK);
	}
		
	
		
}