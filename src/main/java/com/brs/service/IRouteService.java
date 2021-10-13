package com.brs.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brs.entity.Route;
import com.brs.exceptions.ReservationNotFoundException;
import com.brs.exceptions.RouteNotFoundException;

@Service
@Transactional
public interface IRouteService {
	public Route addRoute(Route route) throws RouteNotFoundException;

	public Route updateRoute( long routeId, Route route) throws RouteNotFoundException;

	public Route viewRoute(long routeid) throws RouteNotFoundException;

	public Route deleteRoute(long routeId) throws RouteNotFoundException, ReservationNotFoundException;

	public List<Route> viewAllRoute() throws RouteNotFoundException;

}