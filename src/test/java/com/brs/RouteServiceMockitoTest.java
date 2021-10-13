package com.brs;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.brs.entity.Route;
import com.brs.exceptions.ReservationNotFoundException;
import com.brs.exceptions.RouteNotFoundException;
import com.brs.repository.IRouteRepository;
import com.brs.service.RouteService;

class RouteServiceMockitoTest {

	@Mock
	IRouteRepository routerepo;
	@InjectMocks
	RouteService routeservice;
	List<Route> RouteList;
	Route ro1, ro3;
	Route ro2;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		RouteList = new ArrayList<>();
		ro1 = new Route(1, "amarnath", "delhi", 10);
		ro2 = new Route(2, "agra", "punjab", 5);
		ro3 = new Route(3, "chennai", "trichy", 15);
		RouteList.add(ro1);
		RouteList.add(ro2);
		RouteList.add(ro3);

	}

	@Test
	void addRouteTest() throws RouteNotFoundException {
		when(routerepo.save(ro1)).thenReturn(ro1);
		Assertions.assertEquals(ro1, routeservice.addRoute(ro1));
	}

	@Test
	void viewAllRouteTest() throws RouteNotFoundException {
		when(routerepo.findAll()).thenReturn(RouteList);
		Assertions.assertEquals(RouteList, routeservice.viewAllRoute());
	}

	@Test
	void updateRouteTest() throws RouteNotFoundException {
		when(routerepo.findById(ro1.getRouteId())).thenReturn(Optional.of(ro1));
		when(routerepo.save(ro1)).thenReturn(ro1);
		Assertions.assertEquals(ro1, routeservice.updateRoute(0, ro1));

	}

	@Test
	void viewRouteByIdTest() throws RouteNotFoundException {
		when(routerepo.findById(ro1.getRouteId())).thenReturn(Optional.of(ro1));
		Assertions.assertEquals(ro1, routeservice.viewRoute(ro1.getRouteId()));
	}

	@Test
	void deleteRouteTest() throws RouteNotFoundException, ReservationNotFoundException {
		when(routerepo.findById(ro1.getRouteId())).thenReturn(Optional.of(ro1));
		Assertions.assertEquals(ro1, routeservice.deleteRoute(ro1.getRouteId()));
	}
}