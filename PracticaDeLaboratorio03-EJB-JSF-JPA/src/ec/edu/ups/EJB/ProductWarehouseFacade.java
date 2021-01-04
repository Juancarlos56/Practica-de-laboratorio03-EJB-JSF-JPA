package ec.edu.ups.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ProductWarehouseFacade
 */
@Stateless
public class ProductWarehouseFacade extends AbstractFacade<ProductFacade>{

	@PersistenceContext(unitName = "PracticaDeLaboratorio03-EJB-JSF-JPA")
    private EntityManager em;
	
    public ProductWarehouseFacade() {
    	super(ProductFacade.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

    
}
