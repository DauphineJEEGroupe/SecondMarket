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
	public User findById(Long id);

	public User findByName(String name);

	public List<User> findAllOrderedByName();

	public void register(User user);

	/**
	 * 
	 * @param login
	 * @return
	 */
	User findByLogin(String login);

	/**
	 * 
	 * @param email
	 * @return
	 */
	User findByEmail(String email);
}
