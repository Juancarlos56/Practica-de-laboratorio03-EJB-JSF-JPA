package ec.edu.ups.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entities.Company;

/**
 * Session Bean implementation class CompanyFacade
 */
@Stateless
public class CompanyFacade extends AbstractFacade<Company>{

	@PersistenceContext(unitName = "PracticaDeLaboratorio03-EJB-JSF-JPA")
	private EntityManager em;
	
	public CompanyFacade() {
		super(Company.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
