package com.brs.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brs.entity.Reservation;
import com.brs.exceptions.ReservationNotFoundException;

@Service
@Transactional
public interface IReservationService {
	public Reservation addReservation(Reservation reservation) throws ReservationNotFoundException;

	public Reservation updateReservation(Reservation reservation) throws ReservationNotFoundException;

	public Reservation viewReservation(long id) throws ReservationNotFoundException;

	public Reservation deleteReservation(Long id) throws ReservationNotFoundException;

	public List<Reservation> viewAllReservation() throws ReservationNotFoundException;
}
