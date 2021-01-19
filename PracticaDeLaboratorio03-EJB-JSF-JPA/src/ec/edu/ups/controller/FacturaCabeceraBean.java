package ec.edu.ups.controller;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.EJB.FacturaCabeceraFacade;
import ec.edu.ups.entidades.FacturaCabecera;
import ec.edu.ups.entidades.FacturaDetalle;
import ec.edu.ups.entidades.Pedido;
import ec.edu.ups.entidades.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class FacturaCabeceraBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FacturaCabeceraFacade ejbFacturaCabecera;
	
	public static List<FacturaCabecera> cabeceras = new ArrayList<FacturaCabecera>();
	private List<FacturaDetalle> detalles = new ArrayList<FacturaDetalle>();
	private String cedula;
	
	@PostConstruct
	public void init(){
		cabeceras=ejbFacturaCabecera.facturasCabeceraReves();
	}
	
	public void sacarDetalles(FacturaCabecera facCabecera) {
		detalles=facCabecera.getFacturasDetalle();
	}
	
	public void cancelarFactura(FacturaCabecera facCabecera) {
		facCabecera.setEstado('C');
		ejbFacturaCabecera.edit(facCabecera);
		cabeceras=ejbFacturaCabecera.facturasCabeceraReves();
	}
	
	public void filtrarFacturaCabecera() {
		System.out.println("si esta entrando");
		cabeceras=ejbFacturaCabecera.facturasCabeceraFiltrada(cedula);
		if(cabeceras==null || cabeceras.size() == 0) {
			System.out.println("no consigue nada");
			cabeceras=ejbFacturaCabecera.facturasCabeceraReves();
		}
	}
	
	

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public FacturaCabeceraFacade getEjbFacturaCabecera() {
		return ejbFacturaCabecera;
	}

	public void setEjbFacturaCabecera(FacturaCabeceraFacade ejbFacturaCabecera) {
		this.ejbFacturaCabecera = ejbFacturaCabecera;
	}

	public List<FacturaCabecera> getCabeceras() {
		return cabeceras;
	}

	public void setCabeceras(List<FacturaCabecera> cabeceras) {
		this.cabeceras = cabeceras;
	}

	public List<FacturaDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<FacturaDetalle> detalles) {
		this.detalles = detalles;
	}
	
}
