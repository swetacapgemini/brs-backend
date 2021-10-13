package com.brs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brs.entity.Bus;
import com.brs.entity.Reservation;
import com.brs.entity.Route;
import com.brs.entity.User;
import com.brs.exceptions.BusNotFoundException;
import com.brs.exceptions.ReservationNotFoundException;
import com.brs.exceptions.RouteNotFoundException;
import com.brs.repository.IRouteRepository;

/**
 * Description:This is Route Service Class that provides the services to add a
 * Route, remove a Route, update a Route and view a Route
 **/

@Service
@Transactional
public class RouteService implements IRouteService {

	@Autowired
	private IRouteRepository routeRepo;

	/**
	 * Description :To add Route to the database Input Params :Route object to be
	 * added to the database Return Value :Route Object
	 **/

	@Override

	public Route addRoute(Route route) throws RouteNotFoundException {
		Optional<Route> addRouteTemp = routeRepo.findById(route.getRouteId());
		if (!addRouteTemp.isPresent()) {
			Route savedRoute = new Route();
			savedRoute = routeRepo.save(route);
			return savedRoute;
		} else {
			throw new RouteNotFoundException("Route already exists");
		}
	}

	/**
	 * Description :To update Route in the database Input Params :Route object to be
	 * added to the database Return Value :Route Object Exception
	 * :RouteNotFoundException-raised when Route Id not found
	 **/

	@Override
	public Route updateRoute(long routeId,Route route) throws RouteNotFoundException {

		Optional<Route> retrievedRoute = null;

		retrievedRoute = routeRepo.findById(routeId);
		if (retrievedRoute.isPresent()) {
			retrievedRoute.get().setRouteId(route.getRouteId());
			retrievedRoute.get().setRouteFrom(route.getRouteFrom());
			retrievedRoute.get().setRouteTo(route.getRouteTo());
			retrievedRoute.get().setDistance(route.getDistance());

			return routeRepo.save(retrievedRoute.get());
		} else
			throw new RouteNotFoundException("Route with given id is not found");

	}

	/**
	 * Description :To view Route in the database Input Params :Route id whose Route
	 * object should be viewed in the database Return Value :Route Object Exception
	 * :RouteNotFoundException-raised when Route Id not found
	 * 
	 * @throws RouteNotFoundException
	 **/

	@Override
	public Route viewRoute(long id) throws RouteNotFoundException {
		Optional<Route> retVal = null;

		retVal = routeRepo.findById(id);
		if (retVal.isPresent()) {

			return retVal.get();

		} else
			throw new RouteNotFoundException("Route with given id not found");

	}

	/**
	 * Description :To delete Route from the database Input Params :Route object to
	 * be deleted from the database Return Value :Route Object Exception
	 * :RouteNotFoundException-raised when Route Id not found
	 * 
	 * @throws ReservationNotFoundException
	 **/

	@Override
	public Route deleteRoute(long id) throws RouteNotFoundException {

		Optional<Route> delroute = null;

		delroute = routeRepo.findById(id);
		if (delroute.isPresent()) {

			delroute = routeRepo.findById(id);
			routeRepo.deleteById(id);

			return delroute.get();
		} else
			throw new RouteNotFoundException("Route with given id not found");

	}

	/**
	 * Description :To view all the Route in the database Return Value :list of
	 * Route Objects
	 **/

	@Override
	public List<Route> viewAllRoute() {

		List<Route> retVal = null;
		retVal = routeRepo.findAll();
		return retVal;
	}

}