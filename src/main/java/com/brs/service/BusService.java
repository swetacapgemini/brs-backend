package com.brs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.brs.exceptions.BusNotFoundException;
import com.brs.exceptions.ReservationNotFoundException;
import com.brs.entity.Bus;
import com.brs.entity.FeedBack;
import com.brs.entity.Reservation;
import com.brs.repository.IBusRepository;

@Service
@Transactional
/**
 * Description:This is Bus Service Class that provides the services to add a
 * bus, remove a bus, update a bus and view a bus
 **/
public class BusService implements IBusService {
	@Autowired
	private IBusRepository busrepo;

	/**
	 * Description :To add Bus to the database Input Params :Bus object to be added
	 * to the database Return Value :Bus Object
	 **/
	@Override
	public Bus addBus(Bus bus) throws BusNotFoundException {
		Optional<Bus> addBusTemp = busrepo.findById(bus.getBusId());
		if (!addBusTemp.isPresent()) {
			Bus savedBus = new Bus();
			savedBus = busrepo.save(bus);
			return savedBus;
		} else {
			throw new BusNotFoundException("Bus already exists");
		}
	}

	/**
	 * Description :To update Bus in the database Input Params :Bus object to be
	 * added to the database Return Value :Bus Object Exception
	 * :BusNotFoundException-raised when bus Id not found
	 * 
	 * @throws BusNotFoundException
	 **/
	@Override
	public Bus updateBus(Bus bus) throws BusNotFoundException {
		Optional<Bus> updateBus = null;
		updateBus = busrepo.findById(bus.getBusId());
		if (updateBus.isPresent()) {
			updateBus.get().setBusId(bus.getBusId());
			updateBus.get().setBusName(bus.getBusName());
			updateBus.get().setDriverName(bus.getDriverName());
			updateBus.get().setBusType(bus.getBusType());
			updateBus.get().setRouteFrom(bus.getRouteFrom());
			updateBus.get().setRouteTo(bus.getRouteTo());
			updateBus.get().setArrivalTime(bus.getArrivalTime());
			updateBus.get().setDepartureTime(bus.getDepartureTime());
			updateBus.get().setSeats(bus.getSeats());
			updateBus.get().setAvaiableSeats(bus.getAvaiableSeats());
			return busrepo.save(updateBus.get());
		} else
			throw new BusNotFoundException("Bus with given id is not found");
	}

	/**
	 * Description :To delete Bus from the database Input Params :Bus object to be
	 * deleted from the database Return Value :Bus Object Exception
	 * :BusNotFoundException-raised when bus Id not found
	 **/
	@Override
	public Bus deleteBus(int busId) throws BusNotFoundException {
		Optional<Bus> deleteBus = null;
		deleteBus = busrepo.findById(busId);
		if (deleteBus.isPresent()) {
			Optional<Bus> bus = busrepo.findById(busId);
            busrepo.deleteById(busId);
			return bus.get();
		} else
			throw new BusNotFoundException("Bus with given id not found");
	}

	/**
	 * Description :To view Bus in the database Input Params :Bus id whose bus
	 * object should be viewed in the database Return Value :Bus Object Exception
	 * :BusNotFoundException-raised when bus Id not found
	 **/
	@Override
	public Bus getBus(int busId) throws BusNotFoundException {
		Optional<Bus> retVal = null;

		retVal = busrepo.findById(busId);
		if (retVal.isPresent()) {			
			return retVal.get();
		}

		else
			throw new BusNotFoundException("Bus with given id not found");
	}

	/**
	 * Description :To view all the Bus in the database Return Value :list of Bus
	 * Objects
	 **/
	@Override
	public List<Bus> viewAllBus() {

		return busrepo.findAll();
	}

	@Override
	public Bus updateBus(int busid, Bus bus) {
		// TODO Auto-generated method stub
		return null;
	}
}