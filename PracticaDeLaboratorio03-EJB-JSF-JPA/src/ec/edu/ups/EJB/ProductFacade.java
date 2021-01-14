package ec.edu.ups.EJB;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entities.Product;
import ec.edu.ups.entities.ProductWarehouse;

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
	
    @SuppressWarnings("unchecked")
	public List<Product> buscarPorNombre (String nombre) {
    	List<Product> prod = new ArrayList<Product>();
		String consulta = "SELECT  p FROM Product p WHERE p.productName LIKE :nombre AND p.productState LIKE 'ACTIVO'";
		try {
			em.clear();
			prod = (List<Product>)em.createQuery(consulta).setParameter("nombre", nombre).getResultList();		
			em.refresh(prod);
			System.out.println("PRODUCTOS: "+prod.size());
		} catch (Exception e) {
			System.out.println(">>>WARNING (productosEmpresa EmpresaDAO): " + e.getMessage());
		}
		
		return prod;
    }
    
   
    
}
