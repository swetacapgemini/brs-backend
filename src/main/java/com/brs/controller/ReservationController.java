package com.brs.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Logger;

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
import org.springframework.web.bind.annotation.RestController;

import com.brs.entity.Reservation;
import com.brs.entity.User;
import com.brs.exceptions.ReservationNotFoundException;
import com.brs.service.IBusService;
import com.brs.service.IReservationService;

/**
 * Description:This is ReservationController Layer
 **/
@RestController
@CrossOrigin("*")
@RequestMapping("rest/api/reservation")

public class ReservationController {
	Logger log = Logger.getLogger("ReservationController");
	@Autowired
	IReservationService reservationService;

	@Autowired
	IBusService busService;

	/**
	 * Description :To update feedback details into the database Return Value
	 * :feedback object of the feedback been fetched
	 * @throws ReservationNotFoundException 
	 **/

	@GetMapping("/viewreservation/{id}")
	public ResponseEntity<Reservation> viewReservation(@PathVariable("id") int id) throws ReservationNotFoundException {
		log.info("viewreservation method");
		return new ResponseEntity<>(reservationService.viewReservation(id), HttpStatus.OK);
	}

	/**
	 * Description :To add reservation details into the database Return Value
	 * :reservation object of the reservation been fetched
	 * @throws ReservationNotFoundException 
	 **/

	@GetMapping("/addReservation/{source}/{destination}/{user}")
	public ResponseEntity<Reservation> addReservation(@PathVariable("source") String source,@PathVariable("destination") String destination,@PathVariable("user") String user) throws ReservationNotFoundException {
		log.info("addreservation method");
		long l=(long)Math.random()*10000;
		Reservation reservation =new Reservation();
		reservation.setReservationId(l);
		reservation.setDestination(destination);
		reservation.setSource(source);
		reservation.setReservationDate(LocalDate.now());
		reservation.setReservationStatus("accepted");
		reservation.setReservationTime(LocalTime.now());
		reservation.setReservationType("cornerseat");
		User u=new User();
		u.setEmail(user);
		Reservation newVal = reservationService.addReservation(reservation);
		return new ResponseEntity<>(newVal, HttpStatus.OK);
	}

	/**
	 * Description :To update reservation details into the database Return Value
	 * :reservation object of the reservation been fetched
	 * @throws ReservationNotFoundException 
	 **/
	@PutMapping("/updateReservation")
	public ResponseEntity<Reservation> updateReservation(@Valid @RequestBody Reservation reservation) throws ReservationNotFoundException {
		log.info("updatereservation method");
		Reservation newVal = reservationService.updateReservation(reservation);
		return new ResponseEntity<>(newVal, HttpStatus.OK);
	}

	/**
	 * Description :To view all reservation details in the database Return Value
	 * :list of reservation objects of the reservation been fetched
	 * @throws ReservationNotFoundException 
	 **/
	@GetMapping("/viewallreservation")
	public ResponseEntity<List<Reservation>> viewAllReservation() throws ReservationNotFoundException {
		log.info("viewallreservation method");
		List<Reservation> lstReservation = reservationService.viewAllReservation();
		return new ResponseEntity<List<Reservation>>(lstReservation, HttpStatus.OK);
	}

	/**
	 * Description :To delete reservation details by id in the database Return Value
	 * :reservation object of the reservation deleted been fetched
	 * @throws ReservationNotFoundException 
	 **/

	@DeleteMapping("/deletereservation/{id}")
	public ResponseEntity<Reservation> deleteReservation(@PathVariable("id") Long id) throws ReservationNotFoundException {
		log.info("deletereservation method");
		Reservation deleted = reservationService.deleteReservation(id);
		return new ResponseEntity<Reservation>(deleted, HttpStatus.OK);

	}

}