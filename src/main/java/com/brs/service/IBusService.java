package com.brs.service;

import java.util.List;

import com.brs.entity.Bus;
import com.brs.exceptions.BusNotFoundException;

public interface IBusService {
	public Bus addBus(Bus bus) throws BusNotFoundException;
	public Bus updateBus(Bus bus) throws BusNotFoundException;
	public Bus deleteBus(int busId) throws BusNotFoundException;
    public Bus getBus(int busId) throws BusNotFoundException;
    public List<Bus> viewAllBus();
	public Bus updateBus( int busid, Bus bus);
}