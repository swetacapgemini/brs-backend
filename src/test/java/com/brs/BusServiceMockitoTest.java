package com.brs;

import static org.mockito.Mockito.when;

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
import com.brs.exceptions.BusNotFoundException;
import com.brs.repository.IBusRepository;
import com.brs.service.BusService;

class BusServiceMockitoTest {

	@Mock
	IBusRepository busrepo;
	@InjectMocks
	BusService busservice;
	List<Bus> BusList;
	Bus bus1, bus2, bus3;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		BusList = new ArrayList<>();
		LocalTime arrivaltime1 = LocalTime.parse("08:00:00");
		LocalTime arrivaltime2 = LocalTime.parse("09:30:00");
		LocalTime arrivaltime3 = LocalTime.parse("10:40:00");
		LocalTime depttime1 = LocalTime.parse("04:00:00");
		LocalTime depttime2 = LocalTime.parse("05:30:00");
		LocalTime depttime3 = LocalTime.parse("06:40:00");
		bus1 = new Bus(1, "amarnath", "bala", "sleeper", "chennai", "coimbatore", arrivaltime1, depttime1, 30, 10);
		bus2 = new Bus(2, "Raju", "mahesh", "ac", "chennai", "thirunelveli", arrivaltime2, depttime2, 35, 5);
		bus2 = new Bus(3, "vinnu", "vikram", "sleeperac", "chennai", "banglore", arrivaltime3, depttime3, 35, 15);
		BusList.add(bus1);
		BusList.add(bus2);
		BusList.add(bus3);

	}

	@Test
	void addBusTest() throws BusNotFoundException {
		when(busrepo.save(bus1)).thenReturn(bus1);
		Assertions.assertEquals(bus1, busservice.addBus(bus1));
	}

	@Test
	void viewAllBusTest() throws BusNotFoundException {
		when(busrepo.findAll()).thenReturn(BusList);
		Assertions.assertEquals(3, busservice.viewAllBus().size());
	}

	@Test
	void updateBusTest() throws BusNotFoundException {
		when(busrepo.findById(bus1.getBusId())).thenReturn(Optional.of(bus1));
		when(busrepo.save(bus1)).thenReturn(bus1);
		Assertions.assertEquals(bus1, busservice.updateBus(bus1));

	}

	@Test
	void viewBusByIdTest() throws BusNotFoundException {
		when(busrepo.findById(bus1.getBusId())).thenReturn(Optional.of(bus1));
		Assertions.assertEquals(bus1, busservice.getBus(bus1.getBusId()));
	}

	@Test
	void deleteBusTest() throws BusNotFoundException {
		when(busrepo.findById(bus1.getBusId())).thenReturn(Optional.of(bus1));
		Assertions.assertEquals(bus1, busservice.deleteBus(bus1.getBusId()));
	}
}