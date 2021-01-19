package ec.edu.ups.controller;

import java.io.Serializable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.EJB.FacturaCabeceraFacade;
import ec.edu.ups.EJB.FacturaDetalleFacade;
import ec.edu.ups.EJB.ProductoFacade;
import ec.edu.ups.entidades.FacturaCabecera;
import ec.edu.ups.entidades.FacturaDetalle;
import ec.edu.ups.entidades.Pedido;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class FacturaDetalleBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FacturaCabeceraFacade ejbfacturaCabecera;
	
	@EJB
	private FacturaDetalleFacade ejbFacturaDetalle;
	
	@EJB
	private ProductoFacade ejbProducto;
	
	public static List<FacturaDetalle> detallesFac = new ArrayList<FacturaDetalle>();
	
	private FacturaDetalle facturaDetalle;
	private FacturaCabecera facturaCabecera=new FacturaCabecera(0, new Date(), 0, 0, (float) 0.12, 'A', new Persona());
	private String cantidad;
	private float total;
	public static float subtotal=0;
	public static float iva=0;
	public static float totalFinal=0;
	
	
	public FacturaDetalleBean() {
		cantidad="";
	}
	
	
	public List<FacturaDetalle> getDetallesFac() {
		return detallesFac;
	}
	
	public void setDetallesFac(List<FacturaDetalle> detallesFac) {
		this.detallesFac = detallesFac;
	}
	
	public void addDetallesFac(Pedido pedido) {
		if(comprobarProduct(Integer.parseInt(pedido.getCantidad()),pedido.getProducto())) {
			DecimalFormat df = new DecimalFormat("#.00");
			cantidad=pedido.getCantidad();
			float total2=Integer.parseInt(cantidad)*pedido.getProducto().getPrecio();
			this.setTotal(total2);
			FacturaDetalle facDet = new FacturaDetalle(0, Integer.parseInt(cantidad), total, facturaCabecera, pedido.getProducto());
			this.detallesFac.add(facDet);
			subtotal=subtotal+total;
			iva=subtotal*(float)0.12;
			totalFinal=subtotal+iva;
			
			subtotal=(float) (Math.round(subtotal*100d)/100d);
			iva=(float) (Math.round(iva*100d)/100d);
			totalFinal=(float) (Math.round(totalFinal*100d)/100d);
			
		}
	}
	
	public boolean comprobarProduct(int cantidad, Producto prod) {
		int cantidadRest=prod.getStock()-cantidad;
		if(cantidadRest>=0) {
			return true;
		}
		return false;
	}
	
	
	public void guardarFactura() {
		PersonaBean persona = new PersonaBean();
		facturaCabecera.setSubtotal(this.getSubtotal());
		facturaCabecera.setTotal(this.getTotalFinal());
		facturaCabecera.setIva(this.getIva());
		facturaCabecera.setPersona(persona.getPersona());
		for(int i=0; i<detallesFac.size(); i++) {
			detallesFac.get(i).setFacturaCabecera(facturaCabecera);
			Producto product=new Producto();
			product=detallesFac.get(i).getProducto();
			int nuevoStock=product.getStock()-detallesFac.get(i).getCantidad();
			product.setStock(nuevoStock);
			ejbProducto.edit(product);
		}
		facturaCabecera.setFacturasDetalle(this.getDetallesFac());
		ejbfacturaCabecera.create(facturaCabecera);
		detallesFac = new ArrayList<FacturaDetalle>();
		subtotal=0;
		iva=0;
		totalFinal=0;
	}
	
	

	public float getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}


	public float getIva() {
		return iva;
	}


	public void setIva(float iva) {
		this.iva = iva;
	}


	public float getTotalFinal() {
		return totalFinal;
	}


	public void setTotalFinal(float totalFinal) {
		this.totalFinal = totalFinal;
	}


	public FacturaDetalle getFacturaDetalle() {
		return facturaDetalle;
	}

	public void setFacturaDetalle(FacturaDetalle facturaDetalle) {
		this.facturaDetalle = facturaDetalle;
	}


	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}


	public FacturaCabecera getFacturaCabecera() {
		return facturaCabecera;
	}


	public void setFacturaCabecera(FacturaCabecera facturaCabecera) {
		this.facturaCabecera = facturaCabecera;
	}
	
	
	
}
