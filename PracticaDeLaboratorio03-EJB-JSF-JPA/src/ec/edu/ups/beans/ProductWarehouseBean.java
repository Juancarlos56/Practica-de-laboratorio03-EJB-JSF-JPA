package ec.edu.ups.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.EJB.ProductWarehouseFacade;
import ec.edu.ups.entities.Product;
import ec.edu.ups.entities.ProductWarehouse;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class ProductWarehouseBean implements Serializable{

    
	private static final long serialVersionUID = -8602164835159577774L;
	public static List<ProductWarehouse> productosbodega;
	private ProductWarehouse productoBodega;
	private int id;
	private int cantidad;
	private ProductWarehouse pw;

	@EJB
	private ProductWarehouseFacade ejbProductoBodega;
	
	
    public ProductWarehouseBean() {
        // TODO Auto-generated constructor stub
    }

    
    public void incrementarStockProducto(int cod_pro) {
    	setId(cod_pro);
    	pw =  ejbProductoBodega.buscarProductoBodega(this.getId());
    	//System.out.println("Aqui: "+pw.getCod_pro()+" "+pw.getProductStock()+" "+cod_pro);
    	if (getCantidad()>0) {
        	pw.setProductStock(pw.getProductStock()+getCantidad());
        	addMessage("Se ha actualizado el stock!!");
		}
    	 
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
   
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductWarehouseFacade getEjbProductoBodega() {
		return ejbProductoBodega;
	}


	public void setEjbProductoBodega(ProductWarehouseFacade ejbProductoBodega) {
		this.ejbProductoBodega = ejbProductoBodega;
	}
    
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ProductWarehouse getPw() {
		return pw;
	}

	public void setPw(ProductWarehouse pw) {
		this.pw = pw;
	}
    
    
}
