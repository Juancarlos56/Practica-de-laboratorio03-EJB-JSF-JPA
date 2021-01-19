package ec.edu.ups.entidades;

public class ListaFacturas {
	
	private FacturaCabecera facturaCabecera;
	private String detalle;
	
	public ListaFacturas(FacturaCabecera facturaCabecera, String detalle) {
		this.setFacturaCabecera(facturaCabecera);
		this.setDetalle(detalle);
	}
	
	public FacturaCabecera getFacturaCabecera() {
		return facturaCabecera;
	}
	public void setFacturaCabecera(FacturaCabecera facturaCabecera) {
		this.facturaCabecera = facturaCabecera;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	

}
