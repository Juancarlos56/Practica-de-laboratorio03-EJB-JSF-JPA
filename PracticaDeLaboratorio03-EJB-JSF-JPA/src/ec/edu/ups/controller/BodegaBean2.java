package ec.edu.ups.controller;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;

import javax.faces.annotation.FacesConfig;

import javax.inject.Named;

import ec.edu.ups.EJB.BodegaFacade;
import ec.edu.ups.EJB.CategoriaFacade;
import ec.edu.ups.EJB.ProductoFacade;
import ec.edu.ups.entidades.Bodega;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Producto;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@ApplicationScoped
public class BodegaBean2 implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private BodegaFacade ejbBodegas;
	@EJB
	private CategoriaFacade ejbCategorias;
	@EJB
	private ProductoFacade ejbProducto;
	
	private List<Bodega> bodegas;
	public static List<Producto> productosBodega;
	private int bodegaActual;	
	private String nombreProducto;
	private float precioProducto;
	private int stockProducto;
	private char estadoProducto;
	private String categoria;
	private String nombre;
	
	
	public BodegaBean2 () {
		
	}
	@PostConstruct
	public void init(){
		bodegas=ejbBodegas.findAll();	
	}
	
	public void filtrado() {
		productosBodega=new ArrayList<Producto>();
		productosBodega=ejbProducto.buscarPorNombre(nombre);
		for(Producto p: productosBodega) {
			System.out.println("pro: "+p.getNombre());
		}
	}
	
	public List<Bodega> getBodegas() {
		return bodegas;
	}
	public void setBodegas(List<Bodega> bodegas) {
		this.bodegas = bodegas;
	}
	public List<Categoria> getCategoriasBodega(){
		return ejbCategorias.findAll();
	}
	public String[] getNombreCategoria() {
		String[] lista= {"Limpieza","Jardineria","Cuidado personal","Cocina","Electricidad", 
				"Herramientas","Electrodomesticos","Licores"};
		return lista;
	}
	
	public List<Producto> getProductosBodega(){
		return bodegas.get(bodegaActual).getProductos();
	}
	
	public void setProductosBodega(List<Producto> productosBodega) {
		this.productosBodega = productosBodega;
	}
	
	public int getBodegaActual() {
		return bodegaActual;
	}
	public void setBodegaActual(int bodegaActual) {
		this.bodegaActual = bodegaActual;
	}
	
	public BodegaFacade getEjbBodegas() {
		return ejbBodegas;
	}
	public void setEjbBodegas(BodegaFacade ejbBodegas) {
		this.ejbBodegas = ejbBodegas;
	}
	public void editarProducto(Producto p) {		
		ejbProducto.edit(p);
	}
	public void crearProducto() {		
		Producto productoAuxiliar= new Producto(0,nombreProducto, precioProducto, stockProducto, estadoProducto,buscarCategoria(categoria));		
		ejbProducto.create(productoAuxiliar);		
		bodegas.get(bodegaActual).addProductos(productoAuxiliar);
		ejbBodegas.edit(bodegas.get(bodegaActual));
	}
	public void eliminarProducto(Producto p) {		
		bodegas.get(bodegaActual).delelteProducto(p);
		ejbBodegas.edit(bodegas.get(bodegaActual));
		ejbProducto.remove(p);			
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public float getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(float precioProducto) {
		this.precioProducto = precioProducto;
	}
	public int getStockProducto() {
		return stockProducto;
	}
	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}
	public char getEstadoProducto() {
		return estadoProducto;
	}
	public void setEstadoProducto(char estadoProducto) {
		this.estadoProducto = estadoProducto;
	}
	public String[] getNombresBodega() {
		String [] nombres=new String [bodegas.size()];
		for(int i=0;i<bodegas.size();i++) {
			nombres[i]=bodegas.get(i).getNombre();
		}
		return nombres;
	}	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Categoria buscarCategoria(String nombre) {
		int salida=0;		
		for(int i=0;i<this.getCategoriasBodega().size();i++) {			
			if(this.getCategoriasBodega().get(i).getNombre().equals(nombre)) {
				salida=i;
			}
		}		
		return this.getCategoriasBodega().get(salida);
	}
	
	public ArrayList<Producto> getTodos() {
		ArrayList<Producto> stos = new ArrayList<Producto>();				
		for (int i = 0; i < bodegas.size(); i++) {								
			for (Producto producto : bodegas.get(i).getProductos()) {
				if(!stos.contains(producto)) {
					Producto aux=new Producto(1000, producto.getNombre(), producto.getPrecio(), 0, producto.getEstado(), producto.getCategoria());					
					stos.add(aux);
				}					
			}			
		}		
		for (int i = 0; i < bodegas.size(); i++) {
			Bodega actual= bodegas.get(i);
			for(int j=0;j<stos.size();j++) {
				List<Producto> listaActual=actual.getProductos();
				Producto productoActual=stos.get(j);
				for(int k=0;k<listaActual.size();k++) {
					if(listaActual.get(k).getNombre().equals(productoActual.getNombre())) {
						System.out.println("Stock Bodega: "+listaActual.get(k).getStock());
						System.out.println("Stock lista: "+stos.get(j).getStock());
						stos.get(j).setStock(stos.get(j).getStock() + listaActual.get(k).getStock());
					}
				}
				
			}
			
		}
		return stos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	
	
	
}
