package com.brs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brs.entity.Bus;
import com.brs.entity.Reservation;
import com.brs.entity.User;
import com.brs.exceptions.BusNotFoundException;
import com.brs.exceptions.FeedBackNotFoundException;
import com.brs.exceptions.ReservationNotFoundException;
import com.brs.repository.IReservationRepository;

/**
 * Description:This is Reservation Service Class that provides the services to
 * add a Reservation, remove a Reservation, update a Reservation and view a
 * Reservation by id and view all reservations.
 **/

@Service
@Transactional
public class ReservationService implements IReservationService {

	@Autowired
	private IReservationRepository reservationRepo;

	@Override
	/**
	 * Description :To add Reservation to the database Input Params : Reservation
	 * object to be added to the database Return Value : Reservation Object
	 **/
	public Reservation addReservation(Reservation reservation) throws ReservationNotFoundException {
		Optional<Reservation> addResTemp = reservationRepo.findById(reservation.getReservationId());
		if (!addResTemp.isPresent()) {
			Reservation savedRes = new Reservation();
			savedRes = reservationRepo.save(reservation);
			return savedRes;
		} else {
			throw new ReservationNotFoundException("Reservation already exists");
		}
	}

	/**
	 * Description :To update Reservation in the database Input Params : Reservation
	 * object to be added to the database Return Value : Reservation Object
	 * Exception : Reservation NotFoundException-raised when Reservation Id not
	 * found
	 **/

	@Override
	public Reservation updateReservation(Reservation reservation) throws ReservationNotFoundException {

		Optional<Reservation> retrievedReservation = null;

		retrievedReservation = reservationRepo.findById(reservation.getReservationId());
		if (retrievedReservation.isPresent()) {
			retrievedReservation.get().setReservationId(reservation.getReservationId());
			retrievedReservation.get().setReservationStatus(reservation.getReservationStatus());
			retrievedReservation.get().setReservationDate(reservation.getReservationDate());
			retrievedReservation.get().setReservationTime(reservation.getReservationTime());
			retrievedReservation.get().setSource(reservation.getSource());
			retrievedReservation.get().setDestination(reservation.getDestination());
			retrievedReservation.get().setReservationType(reservation.getReservationType());

			return reservationRepo.save(retrievedReservation.get());
		} else
			throw new ReservationNotFoundException("Reservation with given id is not found");

	}

	/**
	 * Description :To view Reservation in the database Input Params : Reservation
	 * id whose Reservation object should be viewed in the database Return Value :
	 * Reservation Object Exception : Reservation NotFoundException-raised when
	 * Reservation Id not found
	 **/

	@Override
	public Reservation viewReservation(long id) throws ReservationNotFoundException {

		Optional<Reservation> retVal = null;

		retVal = reservationRepo.findById(id);
		if (retVal.isPresent()) {
			return retVal.get();

		} else
			throw new ReservationNotFoundException("reservation with given id not found");
	}

	/**
	 * Description :To delete Reservation from the database Input Params :
	 * Reservation object to be deleted from the database Return Value : Reservation
	 * Object Exception : Reservation NotFoundException-raised when Reservation Id
	 * not found
	 **/

	@Override
	public Reservation deleteReservation(Long id) throws ReservationNotFoundException {

		Optional<Reservation> deleteRes = null;

		deleteRes = reservationRepo.findById(id);
		if (deleteRes.isPresent()) {

			Optional<Reservation> reservation = reservationRepo.findById(id);
			reservationRepo.deleteById(id);
			return reservation.get();
		} else
			throw new ReservationNotFoundException("Reservation with given id not found");

	}

	/**
	 * Description :To view all the Reservation in the database Return Value :list
	 * of Reservation Objects
	 **/

	@Override
	public List<Reservation> viewAllReservation() throws ReservationNotFoundException {
		List<Reservation> retVal = null;
		retVal = reservationRepo.findAll();
		return retVal;
	}

}
