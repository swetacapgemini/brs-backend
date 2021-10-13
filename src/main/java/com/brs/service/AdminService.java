package com.brs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brs.entity.Admin;
import com.brs.entity.Reservation;
import com.brs.exceptions.AdminNotFoundException;
import com.brs.exceptions.InvalidCredentials;
import com.brs.repository.IAdminRepository;
import com.brs.repository.IBusRepository;
import com.brs.repository.IReservationRepository;
import com.brs.repository.IRouteRepository;



@Service
public class AdminService implements IAdminService{
	@Autowired
	private IAdminRepository adminrepo;
	
	@Autowired
	private IReservationRepository reservationrepo;
	
	@Autowired
	private IRouteRepository routerepo;

	@Autowired
	private IBusRepository busrepo;
	
	private Admin a = new Admin();
	
	@Override
	public String signOut() {
		a = null;
		return "Logged out";
	}

	@Override
	public Admin signIn(String username, String password) {
		boolean flag = false;
		try {
		if(a.getAdminUsername().equals(username) && a.getAdminPassword().equals(password)) {
			adminrepo.save(a);
			flag = true;
		} else {
			flag = false;
			throw new InvalidCredentials("Invalid Credentials");
		}
		}
		
		catch(InvalidCredentials i) {
			i.printStackTrace();
		}
		if(flag)
			return a;
		return null;
	
	}
	
	
	
	
	@Override
	public Admin updateAdmin(Integer id, Admin admin) {

		Admin temp=new Admin();
		try {
			temp = adminrepo.findById(id).orElseThrow(()-> new AdminNotFoundException("No admin found with this id: "+admin.getAdminId()));
			temp.setAdminId(admin.getAdminId());
			temp.setAdminUsername(admin.getAdminUsername());
			temp.setAdminPassword(admin.getAdminPassword());
		} catch (AdminNotFoundException e) {
			e.printStackTrace();
		}
		return adminrepo.save(temp);
		
	}

	
	@Override
	public List<Reservation> getAllReservation() {
		return reservationrepo.findAll();
	}

	@Override
	public List<Reservation> getReservationByUser(Long userloginid) {
		List<Reservation> list = reservationrepo.findAll();
		List<Reservation> a = new ArrayList<>();
		for(Reservation r : list) {
			if(r.getUser().getUserLoginId().equals(userloginid))
				a.add(r);
			
		}
		return a;
	}

	@Override
	public Admin updateAdmin(int parseInt, Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}
	

}