/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo.impl;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.secondMarket.sm_webapp.repo.StatutDao;

/**
 * @author gnepa.rene.barou
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/META-INF/spring/infrastructure.xml",
"classpath:/META-INF/spring/applicationContext.xml"}) 
@Transactional
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
public class StatutDaoImplTest {
	private final Logger logger = Logger.getLogger(getClass().getName());
	@Autowired
	StatutDao daoStatut;
	
	@BeforeClass	public static void beforeClasse(){}
	@Before()	public void avantChaqueTest(){
		if(daoStatut==null) logger.severe("Y a vraiment un probleme avec spring");//verifie que l'auto injection de spring est ok
		logger.info(">>>Before test...(this is in transaction scope)");	
	}
	@After() public void apresChaqueTest(){	logger.info(">>>After test...(this is in transaction scope)");	}
	@BeforeTransaction() 
	public void avantTransaction(){	logger.info(">>>Avant chaque transaction");}
	@AfterTransaction public void apresTransac(){ logger.info(">>>Apres chaque transaction");}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link fr.dauphine.secondMarket.sm_webapp.repo.impl.StatutDaoImpl#findById(java.lang.Long)}.
	 */
	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.dauphine.secondMarket.sm_webapp.repo.impl.StatutDaoImpl#findByCode(java.lang.String)}.
	 */
	@Test
	public void testFindByCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.dauphine.secondMarket.sm_webapp.repo.impl.StatutDaoImpl#findAllOrderedByCode()}.
	 */
	@Test
	public void testFindAllOrderedByCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.dauphine.secondMarket.sm_webapp.repo.impl.StatutDaoImpl#register(fr.dauphine.secondMarket.sm_webapp.domain.Statut)}.
	 */
	@Test
	public void testRegister() {
		fail("Not yet implemented");
	}

}
