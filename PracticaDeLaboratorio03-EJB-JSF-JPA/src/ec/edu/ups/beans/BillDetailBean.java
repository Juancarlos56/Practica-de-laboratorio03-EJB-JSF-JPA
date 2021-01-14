package ec.edu.ups.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import ec.edu.ups.EJB.BillDetailFacade;
import ec.edu.ups.EJB.ProductWarehouseFacade;
import ec.edu.ups.entities.BillDetail;
import ec.edu.ups.entities.Product;
import ec.edu.ups.entities.ProductWarehouse;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class BillDetailBean implements Serializable{

    
	private static final long serialVersionUID = 694570111503029184L;
	
	
	@EJB
	private BillDetailFacade ejbdetalles; 

	@EJB
	private ProductWarehouseFacade ejbProductoBodega;
	
	private int cantidadCompra;
	public static List<BillDetail> detallesFac = new ArrayList<BillDetail>();
	private BillDetail facturaDetalle;
    private double subtotal;
    private int amount;
	private double unitPrice;
	private boolean state;
	private ProductWarehouse productoBodega;
	
	public BillDetailBean() {
        // TODO Auto-generated constructor stub
    }
	
	
	public void addDetallesFactura(Product producto) {
		
		productoBodega = ejbProductoBodega.buscarProductoBodega(producto.getCod_pro());
		boolean stock = controlStock(getCantidadCompra(), productoBodega.getProductStock());
		
		if (stock) {
			facturaDetalle = new BillDetail();
			facturaDetalle.setAmount(getAmount());
			facturaDetalle.setState("Agregado");
			facturaDetalle.setUnitPrice(getUnitPrice());
			facturaDetalle.setSubtotal(facturaDetalle.calcularSubtotal());
			
			detallesFac.add(facturaDetalle);
			disminicionStock(getCantidadCompra(), productoBodega);
			addMessage("Producto Agregado!!");
		}else {
			addMessage("No existe stock de este producto!!");
		}
		
		
	}
	
	public boolean controlStock(int cantidadCompra, int cantidadProducto) {
		int stock = cantidadCompra - cantidadProducto; 
		if (stock < 0 ) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public void disminicionStock(int cantidadCompra, ProductWarehouse producto) {
		
		int stock = cantidadCompra - producto.getProductStock(); 
		producto.setProductStock(stock);
		
	}
	
	
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    

	public ProductWarehouseFacade getEjbProductoBodega() {
		return ejbProductoBodega;
	}


	public void setEjbProductoBodega(ProductWarehouseFacade ejbProductoBodega) {
		this.ejbProductoBodega = ejbProductoBodega;
	}


	public ProductWarehouse getProductoBodega() {
		return productoBodega;
	}


	public void setProductoBodega(ProductWarehouse productoBodega) {
		this.productoBodega = productoBodega;
	}


	public int getCantidadCompra() {
		return cantidadCompra;
	}


	public void setCantidadCompra(int cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}




	public BillDetailFacade getEjbdetalles() {
		return ejbdetalles;
	}


	public void setEjbdetalles(BillDetailFacade ejbdetalles) {
		this.ejbdetalles = ejbdetalles;
	}


	public BillDetail getFacturaDetalle() {
		return facturaDetalle;
	}

	public void setFacturaDetalle(BillDetail facturaDetalle) {
		this.facturaDetalle = facturaDetalle;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	
	
}
