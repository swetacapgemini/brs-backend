package com.brs.entity;

import java.time.LocalTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Bus {
	/*
	 * Entity Name : Bus Used Annotation
	 * : @Entity, @Id, @OnetoOne, @ManytoOne, @JoinCoulmn,@Pattern validation : Bean
	 * validation is done Description : Entity class for Bus
	 */
	@Id
	@NotNull(message = "Id cannot be null")
	@Column(name = "busId", nullable = false, unique = true, length = 20)
	private int busId;
	@Column(name = "busName", nullable = false, length = 20)
	@NotBlank(message = "busname cannot be blank")
	@Pattern(regexp = "^[A-Za-z]{3,10}$", message = "busname must only be alphabets from 3 to 10 characters")
	private String busName;
	@Column(name = "driverName", nullable = false, length = 20)
	@NotBlank(message = "drivername cannot be blank")
	@Pattern(regexp = "^[A-Za-z]{3,10}$", message = "drivername must only be alphabets from 3 to 10 characters")
	private String driverName;
	@Column(name = "bustype", nullable = false, length = 20)
	@NotBlank(message = "bustype cannot be blank")
	@Pattern(regexp = "^[A-Za-z]{3,20}$", message = "bustype must only be alphabets from 3 to 10 characters")
	private String busType;
	@Column(name = "routefrom", nullable = false, length = 20)
	@NotBlank(message = "route cannot be blank")
	@Pattern(regexp = "^[A-Za-z]{3,10}$", message = "route must only be alphabets from 3 to 10 characters")
	private String routeFrom;
	@Column(name = "routeto", nullable = false, length = 20)
	@NotBlank(message = "route cannot be blank")
	@Pattern(regexp = "^[A-Za-z]{3,10}$", message = "route must only be alphabets from 3 to 10 characters")
	private String routeTo;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private int seats;
	private int avaiableSeats;
	@ManyToOne(targetEntity = Route.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "routeId", referencedColumnName = "routeid")
	private Route route;

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getRouteFrom() {
		return routeFrom;
	}

	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getAvaiableSeats() {
		return avaiableSeats;
	}

	public void setAvaiableSeats(int avaiableSeats) {
		this.avaiableSeats = avaiableSeats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + busId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		if (busId != other.busId)
			return false;
		return true;
	}

	public Bus(int busId, String busName, String driverName, String busType, String routeFrom, String routeTo,
			LocalTime arrivalTime, LocalTime departureTime, int seats, int avaiableSeats) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.driverName = driverName;
		this.busType = busType;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.seats = seats;
		this.avaiableSeats = avaiableSeats;
	}

	public Bus() {
		super();
	}

}