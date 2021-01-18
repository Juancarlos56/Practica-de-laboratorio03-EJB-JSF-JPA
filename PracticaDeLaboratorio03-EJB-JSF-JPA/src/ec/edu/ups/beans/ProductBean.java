package ec.edu.ups.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import javax.persistence.Column;

import ec.edu.ups.EJB.ProductFacade;
import ec.edu.ups.EJB.ProductWarehouseFacade;
import ec.edu.ups.entities.Product;
import ec.edu.ups.entities.ProductWarehouse;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class ProductBean implements Serializable{

    
	private static final long serialVersionUID = -2085468197085313985L;
  
	private String buscarPorNombre;
	private List<ProductWarehouse> productosBodegas;
	private List<Product> productos;
	private List<ProductWarehouse> productosBodegaBuscada;
	private int cod_pro;
	private int stocktotal;
	
	@EJB
	private ProductFacade ejbProducto; 
	@EJB
	private ProductWarehouseFacade ejbProductoBodega;
	
	
    public ProductBean() {
    	
    }
    
    public void buscarPorNombreProductodBodega() {
    	productosBodegaBuscada = new  ArrayList<ProductWarehouse>();
    	
    	productos = ejbProductoBodega.buscarPorNombre(getBuscarPorNombre());
    	productosBodegas = ejbProductoBodega.findAll();
    	
    	for (ProductWarehouse bodegaPro : productosBodegas) {
    		
    		for (Product product : productos) {
    			if (bodegaPro.getProduct_ware_pro().getCod_pro() == product.getCod_pro()) {
    				productosBodegaBuscada.add(bodegaPro);
    			}
			}
    		
			
		}
    	
    	productosBodegas = productosBodegaBuscada;
    	
		System.out.println("Lenght de ProductosBodegas: "+ productosBodegas.size());
    	//if(productosBodegas==null) {
			//productos=ejbProducto.findAll();
		//}
	}

    public void buscarTodosLosProductos() {
  
	}


	public String getBuscarPorNombre() {
		return buscarPorNombre;
	}

	public void setBuscarPorNombre(String buscarPorNombre) {
		this.buscarPorNombre = buscarPorNombre;
	}

	

	public List<ProductWarehouse> getProductosBodegas() {
		return productosBodegas;
	}

	public void setProductosBodegas(List<ProductWarehouse> productosBodegas) {
		this.productosBodegas = productosBodegas;
	}

	public List<Product> getProductos() {
		return productos;
	}

	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}

	public ProductFacade getEjbProducto() {
		return ejbProducto;
	}

	public void setEjbProducto(ProductFacade ejbProducto) {
		this.ejbProducto = ejbProducto;
	}

	public ProductWarehouseFacade getEjbProductoBodega() {
		return ejbProductoBodega;
	}

	public void setEjbProductoBodega(ProductWarehouseFacade ejbProductoBodega) {
		this.ejbProductoBodega = ejbProductoBodega;
	}
  
    
   
    

}
