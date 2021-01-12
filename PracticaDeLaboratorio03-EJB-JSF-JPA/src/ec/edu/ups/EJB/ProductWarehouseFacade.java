package ec.edu.ups.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entities.ProductWarehouse;

/**
 * Session Bean implementation class ProductWarehouseFacade
 */
@Stateless
public class ProductWarehouseFacade extends AbstractFacade<ProductWarehouse>{

	@PersistenceContext(unitName = "PracticaDeLaboratorio03-EJB-JSF-JPA")
    private EntityManager em;
	
    public ProductWarehouseFacade() {
    	super(ProductWarehouse.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

    
}
