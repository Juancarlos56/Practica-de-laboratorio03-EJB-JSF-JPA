package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity

public class Producto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private float precio;
	private int stock;
	private char estado;
	@ManyToOne
	@JoinColumn
	private Categoria categoria;
	
	@ManyToMany(mappedBy = "productos")
	private List<Bodega> bodegas;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<FacturaDetalle> facturasDetallesList;
	
	public Producto(int id, String nombre, float precio, int stock, char estado, Categoria categoria) {
		this.setId(id);
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setStock(stock);
		this.setEstado(estado);
		this.setCategoria(categoria);
		bodegas = new ArrayList<Bodega>();
	}

	public Producto() {
		bodegas = new ArrayList<Bodega>();
	}
	
	
		
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public float getPrecio() {
		return precio;
	}



	public void setPrecio(float precio) {
		this.precio = precio;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}



	public char getEstado() {
		return estado;
	}



	public void setEstado(char estado) {
		this.estado = estado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Bodega> getBodegas() {
		return bodegas;
	}

	public void setBodegas(List<Bodega> bodegas) {
		this.bodegas = bodegas;
	}
	
	public void addBodegas(Bodega bodegas) {
		this.bodegas.add(bodegas);
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
		Producto other = (Producto) obj;
		if (id != other.id)
		    return false;
		return true;
	}
   
}
