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
import com.brs.entity.Bus;
import com.brs.exceptions.BusNotFoundException;
import com.brs.service.IBusService;
@CrossOrigin("*")
@RestController

@RequestMapping(path = "bus")
/**
 * Description:This is BusController Layer
 **/

public class BusController {
	Logger log = Logger.getLogger("BusController");
	@Autowired
	private IBusService busservice;

	/**
	 * Description :To insert Bus details into the database Return Value :Bus object
	 * of the Bus been fetched
	 * @throws BusNotFoundException 
	 **/
	@PostMapping("/addbus/_add")
	public ResponseEntity<Bus> addBus(@Valid @RequestBody Bus bus) throws BusNotFoundException {
		log.info("addbus method");
		return new ResponseEntity<>(busservice.addBus(bus), HttpStatus.OK);
	}

	/**
	 * Description :To update Bus details in the database Return Value :Bus object
	 * of the Bus been fetched
	 * @throws BusNotFoundException 
	 **/
	@PutMapping("/addbus/{id}")
	public ResponseEntity<Bus> updatebus(@Valid @PathVariable("id") int busid, @RequestBody Bus bus) throws BusNotFoundException {
		log.info("updatebus method");
		return new ResponseEntity<Bus>(busservice.updateBus(busid,bus), HttpStatus.OK);
	}

	/**
	 * Description :To delete Bus details from the database Return Value : Bus
	 * object of the deletedBus been fetched
	 **/
	@DeleteMapping("/deletebus/{busid}")
	public ResponseEntity<Bus> deleteBus(@PathVariable("busid") int busId) throws BusNotFoundException {
		log.info("deletebus method");
		return new ResponseEntity<>(busservice.deleteBus(busId), HttpStatus.OK);

	}

	/**
	 * Description :To view Bus details by bus id in the database Return Value :Bus
	 * object of the Bus been fetched
	 **/
	@GetMapping("/viewbus/{busid}")
	public ResponseEntity<Bus> getBusById(@PathVariable("busid") int busId) throws BusNotFoundException {
		log.info("viewbus by id method");
		return new ResponseEntity<>(busservice.getBus(busId), HttpStatus.OK);
	}

	/**
	 * Description :To view all the Bus details in the database Return Value :list
	 * of Bus object of the Bus been fetched
	 **/
	@GetMapping("/viewallbus")
	public ResponseEntity<List<Bus>> getAllBus() {
		log.info("getallbus method");
		return new ResponseEntity<List<Bus>>(busservice.viewAllBus(), HttpStatus.OK);
	}
}