package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: FacturaDetalle
 *
 */
@Entity

public class FacturaDetalle implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int cantidad;
	private float total;
	
	@ManyToOne
	@JoinColumn
	private FacturaCabecera facturaCabecera;
	
	@ManyToOne
	private Producto producto;
	
	public FacturaDetalle(int id, int cantidad, float total, FacturaCabecera facturaCabecera, Producto producto) {
		this.setId(id);
		this.setCantidad(cantidad);
		this.setTotal(total);
		this.setFacturaCabecera(facturaCabecera);
		this.setProducto(producto);
	}
	
	public FacturaDetalle() {
		super();
	}
	
	
	
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getCantidad() {
		return cantidad;
	}




	public void setCantidad(int cantidad) {
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




	public Producto getProducto() {
		return producto;
	}




	public void setProducto(Producto producto) {
		this.producto = producto;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		    return true;
		if (obj == null)
		    return false;
		if (getClass() != obj.getClass())
		    return false;
		FacturaDetalle other = (FacturaDetalle) obj;
		if (id != other.id)
		    return false;
		return true;
	}
   
}
