package ec.edu.ups.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entities.Country;

/**
 * Session Bean implementation class CountryFacade
 */
@Stateless
public class CountryFacade extends AbstractFacade<Country>{

    @PersistenceContext(unitName = "PracticaDeLaboratorio03-EJB-JSF-JPA")
	private EntityManager em;
    
	public CountryFacade() {
		super(Country.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	

}
