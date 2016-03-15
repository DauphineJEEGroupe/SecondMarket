package fr.dauphine.secondMarket.sm_webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dauphine.secondMarket.sm_webapp.domain.User;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmTechException;
import fr.dauphine.secondMarket.sm_webapp.repo.UserDao;
import fr.dauphine.secondMarket.sm_webapp.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	public UserServiceImpl() {
	}

	@Override
	public void create(User newUser) throws SmDaoException, SmTechException {
		if(null==findByMail(newUser.getEmail())){
			newUser.setActif(true);
			userDao.register(newUser);
		}else{
			throw new SmTechException("L'adresse mail: "+newUser.getEmail()+" existe deja");
		}
		
	}

	@Override
	public void delete(int id) throws SmDaoException {
			User user=userDao.findById(id);
			if(null!=user) userDao.delete(user);
		
	}

	@Override
	public void update(User userToUpdate) throws SmDaoException {
		User user=userDao.findByEmail(userToUpdate.getEmail());
		if(null==user || user.getId()==userToUpdate.getId()){
			userDao.update(userToUpdate);
		}
		
	}

	@Override
	public List<User> findAll() throws SmDaoException {
		return userDao.findAllOrderedByName();
	}


	@Override
	public List<User> findByName(String name) throws SmDaoException {
		return userDao.findByName(name);
	}
	
	@Override
	public User findById(int id) throws SmDaoException {
		return userDao.findById(id);
	}

	@Override
	public User findByMail(String email) throws SmDaoException {
		return userDao.findByEmail(email);
	}

	@Override
	public List<User> findByType(String type) throws SmDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
