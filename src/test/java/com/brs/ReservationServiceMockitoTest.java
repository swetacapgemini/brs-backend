package com.brs;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.brs.entity.Bus;
import com.brs.entity.Reservation;
import com.brs.entity.User;
import com.brs.exceptions.ReservationNotFoundException;
import com.brs.repository.IBusRepository;
import com.brs.repository.IReservationRepository;
import com.brs.repository.IUserRepository;
import com.brs.service.ReservationService;

class ReservationServiceMockitoTest {

	@Mock
	IReservationRepository reservationrepo;
	@InjectMocks
	ReservationService reservationservice;
	List<Reservation> reservationList;
	Reservation r1, r2, r3;
	@Mock
	IUserRepository userrepo;
	@Mock
	IBusRepository busrepo;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setBeforeClass() throws Exception {
		MockitoAnnotations.initMocks(this);

		reservationList = new ArrayList<>();

		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		Bus bus1 = new Bus(1, "busname", "drivername", "bustype", "routefrom", "routeto", time, time, 3, 2);
		User user1 = new User(1, "raj", "password", "fname", "lstname"," 979104571", "abc@gmail.com");
		User user2 = new User(2, "kamala", "absn", "firname", "lastname", "979104561", "abd@gmail.com");
		User user3 = new User(3, "kannan", "kann", "fistname", "ltname", "979108561", "aba@gmail.com");
		r1 = new Reservation(1, "accepted", "cornerseat", date, time, "chennai", "delhi", bus1, user1);
		r2 = new Reservation(1, "cancelled", "middleseat", date, time, "chennai", "delhi", bus1, user2);
		r3 = new Reservation(1, "accepted", "cornerseat", date, time, "chennai", "Mumbai", bus1, user3);
		reservationList.add(r1);
		reservationList.add(r2);
		reservationList.add(r3);

	}

	@Test
	void addReservationTest() throws ReservationNotFoundException {
		when(reservationrepo.save(r1)).thenReturn(r1);
		Assertions.assertEquals(r1, reservationservice.addReservation(r1));
	}

	@Test
	void viewAllReservationTest() throws ReservationNotFoundException {
		when(reservationrepo.findAll()).thenReturn(reservationList);
		Assertions.assertEquals(reservationList, reservationservice.viewAllReservation());
	}

	@Test
	void updateReservationTest() throws ReservationNotFoundException {
		when(reservationrepo.findById(r1.getReservationId())).thenReturn(Optional.of(r1));
		when(reservationrepo.save(r1)).thenReturn(r1);
		Assertions.assertEquals(r1, reservationservice.updateReservation(r1));

	}

	@Test
	void viewReservationByIdTest() throws ReservationNotFoundException {
		when(reservationrepo.findById((long) r1.getReservationId())).thenReturn(Optional.of(r1));
		Assertions.assertEquals(r1, reservationservice.viewReservation(r1.getReservationId()));
	}

	@Test
	void deleteBusTest() throws ReservationNotFoundException {
		when(reservationrepo.findById((long) r1.getReservationId())).thenReturn(Optional.of(r1));
		Assertions.assertEquals(r1, reservationservice.deleteReservation((long) r1.getReservationId()));
	}
}
