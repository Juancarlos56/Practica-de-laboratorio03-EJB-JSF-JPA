package ec.edu.ups.EJB;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entities.Product;
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

	@SuppressWarnings("unchecked")
	public List<ProductWarehouse> buscarStockDeProductoPorNombre(String nombre) {
    	List<ProductWarehouse> prod = new ArrayList<ProductWarehouse>();
		String consulta = "SELECT  pw FROM productwarehouse pw, product p WHERE p.productName LIKE :nombre AND p.productState LIKE 'ACTIVO'";
		try {
			em.clear();
			prod = (List<ProductWarehouse>)em.createQuery(consulta).setParameter("nombre", nombre).getResultList();		
			//em.refresh(prod);
			System.out.println("PRODUCTOS: "+prod.size());
		} catch (Exception e) {
			System.out.println(">>>WARNING1111 (productosEmpresa EmpresaDAO): " + e.getMessage());
		}
		
		return prod;
    }
	
	@SuppressWarnings("unchecked")
	public ProductWarehouse buscarProductoBodega(int id) {
    	ProductWarehouse prod = new ProductWarehouse();
		String consulta = "SELECT  pw FROM ProductWarehouse pw, Product p WHERE p.cod_pro = :id";
		try {
			em.clear();
			prod = (ProductWarehouse) em.createQuery(consulta).setParameter("id", id).getSingleResult();
			//em.refresh(prod);
		} catch (Exception e) {
			System.out.println(">>>WARNING2222 (buscarProductoBodega ): " + e.getMessage());
		}
		
		return prod;
    }
	
	 @SuppressWarnings("unchecked")
		public List<ProductWarehouse> buscarPorNombreBodegas(String nombre) {
	    	List<ProductWarehouse> prod = new ArrayList<ProductWarehouse>();
	    	String consulta = "SELECT  pr FROM ProductWarehouse pw, Product pr WHERE pr.productName = :nombre AND pr.productState LIKE 'ACTIVO'";
			try {
				em.clear();
				prod = (List<ProductWarehouse>)em.createQuery(consulta).setParameter("nombre", nombre).getResultList();	
				//em.refresh(prod);
			} catch (Exception e) {
				System.out.println(">>>WARNING2222 (buscarProductoBodega ): " + e.getMessage());
			}
			
			return prod;
	 }
	 
	 @SuppressWarnings("unchecked")
		public List<Product> buscarPorNombre(String nombre) {
	    	List<Product> prod = new ArrayList<Product>();
	    	String consulta = "SELECT  pr FROM Product pr WHERE pr.productName = :nombre AND pr.productState LIKE 'ACTIVO'";
			try {
				em.clear();
				prod = (List<Product>)em.createQuery(consulta).setParameter("nombre", nombre).getResultList();	
				//em.refresh(prod);
			} catch (Exception e) {
				System.out.println(">>>WARNING2222 (buscarPorNombre ): " + e.getMessage());
			}
			
			return prod;
	 }

	 

}
