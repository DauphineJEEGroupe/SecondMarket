/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.User;

/**
 * @author gnepa.rene.barou
 *
 */
public interface UserDao {

	User findById(int id);

	User findByEmail(String email);

	List<User> findByName(String name);

	List<User> findAllOrderedByName();

	User register(User user);

	void delete(Integer id);

	User update(User user);

}
