package com.brs.service;

import java.util.List;

import com.brs.entity.User;
import com.brs.exceptions.UserNotFoundException;

public interface IUserService {

	User addUser(User user) throws UserNotFoundException;

	User updateUser(User user) throws UserNotFoundException;

	

	User viewUser(Long userId) throws UserNotFoundException;

	List<User> viewAllUser();

	

	String logout();

	

	

	User login(String userName, String password);

	/**
	 * Description :To delete User from the database Input Params :User object to be
	 * deleted from the database Return Value :User Object Exception
	 * :UserNotFoundException-raised when User Id not found
	 **/
	User deleteUser(Long userLoginId);

	/**
	 * Description :To delete User from the database Input Params :User object to be
	 * deleted from the database Return Value :User Object Exception
	 * :UserNotFoundException-raised when User Id not found
	 * 
	 * @throws UserNotFoundException
	 **/
	User deleteUser(int userId) throws UserNotFoundException;

	/**
	 * Description :To delete User from the database Input Params :User object to be
	 * deleted from the database Return Value :User Object Exception
	 * :UserNotFoundException-raised when User Id not found
	 **/
	


}