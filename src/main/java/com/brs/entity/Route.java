package com.brs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Route {
	/*
	 * Entity Name : Route Used Annotation
	 * : @Entity, @Id, @NotNull,@NotBlank,@OneToMany,@Coulmn,@Pattern validation :
	 * Bean validation is done Description : Entity class for Route
	 */
	@Id
	@Column(name = "routeId", nullable = false, unique = true, length = 20)
	@NotNull(message = "id cannot be null")
	private long routeId;
	@Column(name = "routefrom", nullable = false, length = 20)
	@NotBlank(message = "routefrom cannot be blank")
	@Pattern(regexp = "^[A-Za-z]{3,10}$", message = "route must only be alphabets from 3 to 10 characters")
	private String routeFrom;
	@Column(name = "routeto", nullable = false, length = 20)
	@NotBlank(message = "routeto cannot be blank")
	@Pattern(regexp = "^[a-zA-Z]{3,10}$", message = "route must only be alphabets from 3 to 10 characters")
	private String routeTo;
	@Column(name = "distance", nullable = false, length = 20)
	@NotNull(message = "distance cannot be null")
	private int distance;

	public long getRouteId() {
		return routeId;
	}

	public void setRouteId(long l) {
		this.routeId = l;
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

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (routeId ^ (routeId >>> 32));
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
		Route other = (Route) obj;
		if (routeId != other.routeId)
			return false;
		return true;
	}

	public Route(@NotNull(message = "id cannot be null") long routeId,
			@NotBlank(message = "routefrom cannot be blank") @Pattern(regexp = "^[A-Za-z]{3,10}$", message = "route must only be alphabets from 3 to 10 characters") String routeFrom,
			@NotBlank(message = "routeto cannot be blank") @Pattern(regexp = "^[A-Za-z]{3,10}$", message = "route must only be alphabets from 3 to 10 characters") String routeTo,
			@NotNull(message = "distance cannot be null") @Pattern(regexp = " ^([1-9][0-9]{0,2}|1000)$", message = "distance must only be between 1 and 1000") int distance) {
		super();
		this.routeId = routeId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.distance = distance;
	}

	public Route() {
		super();
	}

}