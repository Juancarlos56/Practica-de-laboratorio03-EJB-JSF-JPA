package ec.edu.ups.EJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entities.Product;

/**
 * Session Bean implementation class ProductFacade
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product>{

	@PersistenceContext(unitName = "PracticaDeLaboratorio03-EJB-JSF-JPA")
	private EntityManager em;
	
    public ProductFacade() {
        super(Product.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

    
}
