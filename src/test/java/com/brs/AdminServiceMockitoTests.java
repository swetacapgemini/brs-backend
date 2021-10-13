package com.brs;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.brs.entity.Admin;
import com.brs.repository.IAdminRepository;
import com.brs.service.IAdminService;


@SpringBootTest
class AdminTest {
	
	@Mock
	private IAdminRepository repo;
	@InjectMocks
	private IAdminService service;
	
	@Test
	public void loginAdimTest() {
		Admin a = new Admin(8088,"Admin123","Admin@123");
		Admin a2 = service.signIn("admin123", "Admin@123");
		Assertions.assertEquals(a.getAdminPassword(),a2.getAdminPassword());
		
	}
	
	@Test
	public void updateAdminTest() {
		Admin a = new Admin(8088,"Admin123","Admin@12");
		when(repo.findById(a.getAdminId())).thenReturn(Optional.of(a));
		when(repo.save(a)).thenReturn(a);
		Assertions.assertEquals(a,service.updateAdmin(a.getAdminId(), a));
	}

	

}