package fr.dauphine.secondMarket.sm_webapp.service;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.User;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmTechException;

public interface UserService {

	void create(User newUser) throws SmDaoException, SmTechException;

	void delete(int id) throws SmDaoException;

	void update(User userToUpdate) throws SmDaoException;

	List<User> findAll() throws SmDaoException;
	
	List<User> findByName(String name) throws SmDaoException;

	User findById(int id) throws SmDaoException;

	User findByMail(String email) throws SmDaoException;

	

}