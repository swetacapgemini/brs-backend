package com.brs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brs.exceptions.UserNotFoundException;
import com.brs.entity.User;
import com.brs.repository.IUserRepository;

@Service
@Transactional
/**
 * Description:This is User Service Class that provides the services to add a
 * User, remove a User, update a User and view a User
 **/
public class UserService implements IUserService {
	@Autowired
	private IUserRepository userrepo;

	/**
	 * Description :To add User to the database Input Params :User object to be
	 * added to the database Return Value :User Object
	 **/
	@Override
	public User addUser(User user) throws UserNotFoundException {
		Optional<User> addUserTemp = userrepo.findById(user.getUserLoginId());
		if (!addUserTemp.isPresent()) {
			User savedUser = new User();
			savedUser = userrepo.save(user);
			return savedUser;
		} else {
			throw new UserNotFoundException("User already exists");
		}
	}

	/**
	 * Description :To update User in the database Input Params :User object to be
	 * added to the database Return Value :User Object Exception
	 * :UserNotFoundException-raised when User Id not found
	 * @throws UserNotFoundException 
	 **/

	@Override
	public User updateUser(User user) throws UserNotFoundException {
		Optional<User> updateUser = null;

		updateUser = userrepo.findById(user.getUserLoginId());
		if (updateUser.isPresent()) {
			updateUser.get().setUserLoginId(user.getUserLoginId());
			updateUser.get().setUserName(user.getUserName());
			updateUser.get().setPassword(user.getPassword());
			updateUser.get().setFirstName(user.getFirstName());
			updateUser.get().setLastName(user.getLastName());
			updateUser.get().setContact(user.getContact());
			updateUser.get().setEmail(user.getEmail());

			return userrepo.save(updateUser.get());
		} else
			throw new UserNotFoundException("User with given id is not found");

	}

	/**
	 * Description :To delete User from the database Input Params :User object to be
	 * deleted from the database Return Value :User Object Exception
	 * :UserNotFoundException-raised when User Id not found
	 * 
	 * @throws UserNotFoundException
	 **/
	@Override
	public User deleteUser(int userId) throws UserNotFoundException {
		Optional<User> delUser = null;

		delUser = userrepo.findById((long) userId);
		if (delUser.isPresent()) {

			delUser = userrepo.findById((long) userId);
			userrepo.deleteById((long) userId);

			return delUser.get();
		} else
			throw new UserNotFoundException("User with given id not found");
	}

	/**
	 * Description :To view User in the database Input Params :User id whose User
	 * object should be viewed in the database Return Value :User Object Exception
	 * :UserNotFoundException-raised when User Id not found
	 **/

	@Override
	public User viewUser(Long userId) throws UserNotFoundException {
		Optional<User> User = null;

		User = userrepo.findById(userId);
		if (User.isPresent()) {

			return User.get();
		} else
			throw new UserNotFoundException("User with given id not found");

	}

	/**
	 * Description :To view all the User in the database Return Value :list of User
	 * Objects
	 **/

	@Override
	public List<User> viewAllUser() {

		return userrepo.findAll();
	}

	@Override
	public String logout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(Long userLoginId) {
		// TODO Auto-generated method stub
		return null;
	}

}
