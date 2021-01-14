package ec.edu.ups.beans;

import java.io.Serializable;
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
    private String productName;
    private Double productPrice;
    private String productUrl;
    private String proDescription;
    private String productState;
	private String buscarPorNombre;
	public static List<Product> productos;
	
	
	@EJB
	private ProductFacade ejbProducto; 
	
	
	
    public ProductBean() {
       
    }
    
    public void buscarPorNombre() {
		

    	productos=ejbProducto.buscarPorNombre(this.getBuscarPorNombre());
    	if(productos==null) {
			productos=ejbProducto.findAll();
		}
	}
  

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getProDescription() {
		return proDescription;
	}

	public void setProDescription(String proDescription) {
		this.proDescription = proDescription;
	}

	public String getProductState() {
		return productState;
	}

	public void setProductState(String productState) {
		this.productState = productState;
	}

	public String getBuscarPorNombre() {
		return buscarPorNombre;
	}

	public void setBuscarPorNombre(String buscarPorNombre) {
		this.buscarPorNombre = buscarPorNombre;
	}

	public ProductFacade getEjbProducto() {
		return ejbProducto;
	}

	public void setEjbProducto(ProductFacade ejbProducto) {
		this.ejbProducto = ejbProducto;
	}

	public List<Product> getProductos() {
		return productos;
	}

	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}
    
    
    

}
