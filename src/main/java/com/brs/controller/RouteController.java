package com.brs.controller;

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

import com.brs.entity.Route;
import com.brs.exceptions.ReservationNotFoundException;
import com.brs.exceptions.RouteNotFoundException;
import com.brs.service.IRouteService;

/**
 * Description:This is RouteController Layers
 **/
@CrossOrigin("*")
@RestController
@RequestMapping(path = "/route")
public class RouteController {
	Logger log = Logger.getLogger("RouteController");
	@Autowired
	private IRouteService iRouteService;

	/**
	 * Description :To add route details into the database Return Value :route
	 * object of the route been fetched
	 * @throws RouteNotFoundException 
	 **/
	@PostMapping("/addroute/_add")
	public ResponseEntity<Route> addRoute(@Valid @RequestBody Route route) throws RouteNotFoundException {
		log.info("addroute method");
		Route addRoute = iRouteService.addRoute(route);
		return new ResponseEntity<Route>(addRoute, HttpStatus.OK);
	}

	/**
	 * Description :To update route details into the database Return Value :route
	 * object of the route been fetched
	 * @throws RouteNotFoundException 
	 **/
	@PutMapping("/addroute/{id}")
	public ResponseEntity<Route> updateRoute(@Valid @PathVariable("id") long routeId, @RequestBody Route route) throws RouteNotFoundException {
		log.info("updateroute method");
		return new ResponseEntity<Route>(iRouteService.updateRoute(routeId,route), HttpStatus.OK);
	}

	/**
	 * Description :To delete route details from the database Return Value :route
	 * object of the route been fetched
	 * @throws RouteNotFoundException 
	 * @throws ReservationNotFoundException 
	 **/
	@DeleteMapping("/deleteroute/{id}")
	public ResponseEntity<Route> deleteRoute(@PathVariable("id") long routeId) throws RouteNotFoundException, ReservationNotFoundException {
		log.info("deleteRoute method");
		return new ResponseEntity<>(iRouteService.deleteRoute(routeId), HttpStatus.OK);

	}

	/**
	 * Description :To view route details by id in the database Return Value :route
	 * object of the route been fetched
	 * @throws RouteNotFoundException 
	 **/
	@GetMapping("/viewroute/{id}")
	public ResponseEntity<Route> getRouteById(@PathVariable("id") long routeId) throws RouteNotFoundException {
		log.info("viewroute method");
		return new ResponseEntity<>(iRouteService.viewRoute(routeId), HttpStatus.OK);
	}

	/**
	 * Description :To view all route details in the database Return Value :route
	 * object of the route been fetched
	 * @throws RouteNotFoundException 
	 **/
	@GetMapping("/viewallroute")
	public ResponseEntity<List<Route>> getAllRoute() throws RouteNotFoundException {
		log.info("viewAllroute method");
		return new ResponseEntity<List<Route>>(iRouteService.viewAllRoute(), HttpStatus.OK);
	}
}