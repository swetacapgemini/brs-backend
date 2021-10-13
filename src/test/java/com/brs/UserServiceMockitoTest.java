package com.brs;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.brs.entity.User;

import com.brs.exceptions.UserNotFoundException;

import com.brs.repository.IUserRepository;

import com.brs.service.UserService;

class UserServiceMockitoTest {
	@Mock
	IUserRepository userrepo;
	@InjectMocks
	UserService userservice;
	List<User> userList;
	User u2, u3, u4;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setBeforeClass() throws Exception {
		MockitoAnnotations.initMocks(this);
		userList = new ArrayList<>();
		u4 = new User(1, "swetark", "swe", "sweta", "k", "9421232141", "swe@gmail.com");
		u2 = new User(1, "subha", "swe", "sweta", "k", "9421232141", "swe@gmail.com");
		u3 = new User(1, "sandhya", "swe", "sweta", "k", "9421232141", "swe@gmail.com");
		userList.add(u4);
		userList.add(u2);
		userList.add(u3);
	}

	@Test
	void addUserTest() throws UserNotFoundException {
		when(userrepo.save(u2)).thenReturn(u2);
		Assertions.assertEquals(u2, userservice.addUser(u2));
	}

	@Test
	void viewAllUserTest(){
		when(userrepo.findAll()).thenReturn(userList);
		Assertions.assertEquals(userList, userservice.viewAllUser());
	}

	@Test
	void updateUserTest() throws UserNotFoundException {
		when(userrepo.findById(u2.getUserLoginId())).thenReturn(Optional.of(u2));
		when(userrepo.save(u2)).thenReturn(u2);
		Assertions.assertEquals(u2, userservice.updateUser(u2));

	}

	@Test
	void viewUserByIdTest() throws UserNotFoundException {
		when(userrepo.findById((long) u2.getUserLoginId())).thenReturn(Optional.of(u2));
		Assertions.assertEquals(u2, userservice.viewUser(u2.getUserLoginId()));
	}

	@Test
	void deleteUserTest() throws UserNotFoundException {
		when(userrepo.findById((long) u2.getUserLoginId())).thenReturn(Optional.of(u2));
		Assertions.assertEquals(u2, userservice.deleteUser(u2.getUserLoginId()));
	}
}