/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.User;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;

/**
 * @author gnepa.rene.barou
 *
 */
public interface UserDao {

	User findById(Long id) throws SmDaoException;

	User findByEmail(String email) throws SmDaoException;

	List<User> findByName(String name) throws SmDaoException;

	List<User> findAllOrderedByName() throws SmDaoException;

	void register(User user) throws SmDaoException;

	void delete(User user) throws SmDaoException;

	void update(User user) throws SmDaoException;

}
