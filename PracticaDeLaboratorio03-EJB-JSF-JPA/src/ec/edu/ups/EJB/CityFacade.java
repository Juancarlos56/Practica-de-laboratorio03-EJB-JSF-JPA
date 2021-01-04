package ec.edu.ups.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entities.City;

/**
 * Session Bean implementation class CityFacade
 */
@Stateless
public class CityFacade extends AbstractFacade<City> {

    @PersistenceContext(unitName = "PracticaDeLaboratorio03-EJB-JSF-JPA")
    private EntityManager em;
    
	
    public CityFacade() {
    	super(City.class);
    }


	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

    
}
