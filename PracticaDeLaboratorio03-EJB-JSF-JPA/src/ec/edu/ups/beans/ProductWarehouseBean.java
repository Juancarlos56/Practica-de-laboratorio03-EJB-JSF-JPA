package ec.edu.ups.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.EJB.ProductWarehouseFacade;
import ec.edu.ups.entities.ProductWarehouse;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class ProductWarehouseBean implements Serializable{

    
	private static final long serialVersionUID = -8602164835159577774L;
	public static List<ProductWarehouse> productosbodega;
	private ProductWarehouse productoBodega;
	private String buscarPorNombre;
	@EJB
	private ProductWarehouseFacade ejbProductoBodega;
	
	
    public ProductWarehouseBean() {
        // TODO Auto-generated constructor stub
    }

    
    
    public void buscarPorNombre() {
    	productosbodega = ejbProductoBodega.buscarStockDeProductoPorNombre(this.getBuscarPorNombre());
	}


	public String getBuscarPorNombre() {
		return buscarPorNombre;
	}


	public void setBuscarPorNombre(String buscarPorNombre) {
		this.buscarPorNombre = buscarPorNombre;
	}


	public ProductWarehouseFacade getEjbProductoBodega() {
		return ejbProductoBodega;
	}


	public void setEjbProductoBodega(ProductWarehouseFacade ejbProductoBodega) {
		this.ejbProductoBodega = ejbProductoBodega;
	}
    
    
    
}
