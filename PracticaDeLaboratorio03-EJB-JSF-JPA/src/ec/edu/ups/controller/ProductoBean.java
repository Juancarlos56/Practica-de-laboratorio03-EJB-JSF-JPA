package ec.edu.ups.controller;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.EJB.CategoriaFacade;
import ec.edu.ups.EJB.ProductoFacade;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Pedido;
import ec.edu.ups.entidades.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class ProductoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public static List<Producto> productos;
	public static boolean centinela=true;
	public static List<Pedido> pedidos=new ArrayList<Pedido>();
	private String nombreBusq;
	
	@EJB
	private ProductoFacade ejbProducto;
	
	@EJB
	private CategoriaFacade ejbCategoria;
	
	public void buscarPorNombre() {
		List<Categoria> cat=ejbCategoria.findAll();
		for(Categoria categoria: cat) {
			List<Producto> productos=categoria.getProductos();
			for(Producto prod : productos) {
				System.out.println("Producto: "+prod.getNombre()+" Categoria: "+categoria.getNombre());
			}
		}
		centinela=false;
		productos=ejbProducto.buscarPorNombre(this.getNombreBusq());
		pedidos=new ArrayList<Pedido>();
		if(productos==null || productos.size() == 0) {
			productos=ejbProducto.findAll();
		}
		for(Producto producto : productos) {
			Pedido pedido=new Pedido(producto, "");
			pedidos.add(pedido);
		}
		
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public String getNombreBusq() {
		return nombreBusq;
	}

	public void setNombreBusq(String nombreBusq) {
		this.nombreBusq = nombreBusq;
	}
	
	

}
