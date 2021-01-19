package ec.edu.ups.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.EJB.CategoryFacade;
import ec.edu.ups.EJB.ProductFacade;
import ec.edu.ups.EJB.UserFacade;
import ec.edu.ups.entities.Category;
import ec.edu.ups.entities.Product;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class CategoryBean implements Serializable{

	String[] list;
    private String categoria;
    private String text = "";
    private List<Product> listaProductos;
    private List<Product> listaProductosBuscado; 
    private String lista = "nada aqui";
    private List<Product> productos;
    private List<Category> categorias;
    
	@EJB
	private CategoryFacade ejbCategoria;
	@EJB
	private ProductFacade ejbProducto;
    
    
    public CategoryBean() {
    
    }
    
    @PostConstruct
	public void init(){
		productos=ejbProducto.findAll();
		categorias=ejbCategoria.findAll();
		obtencionProductosActivos();
	}
    
    
    public void obtencionProductosActivos() {
		List<Product> productosActivos = new ArrayList<Product>();
		Boolean f = true;
		List<Product> todosLosProductos = getProductos();
		
		for (Product producto : todosLosProductos) {
			if (producto.getProductState().equals("Activo")) {					
				productosActivos.add(producto);					
			
			}
		}
		setListaProductos(productosActivos);	
	}
    
    public String[] obtencionListaCategorias() {
    	list = new String[categorias.size()];
    	list[0] = "Todas";
    	

		for (int i = 1; i < categorias.size(); i++)
		    list[i] = "" +  categorias.get(i-1).getCategoryName();
	
		return this.list;
	}
    
    
    public void ajaxObtencionProductos() {
		System.out.println("Texto de busqueda: " + text);
        System.out.println("Seleccionada : " + categoria);
        
        List<Product> prod = new ArrayList<Product>(); 
        
        
        if(getCategoria().equals("Todas")) {
    		
        	if (getText().equals("")) {
				prod = getListaProductos();
			}else {
				
				for (Product producto : getListaProductos()) {	
					if (producto.getProductName().toLowerCase().contains(text.toLowerCase())) {
						prod.add(producto);
	    			}
	    		}
			}
    	}else {
    		for (Product producto : getListaProductos()) {
				
				if (producto.getProductName().toLowerCase().contains(text.toLowerCase())) {
					if (producto.getCategory_product().getCategoryName().equalsIgnoreCase(getCategoria())) {
						prod.add(producto);
					}
					
    			}
				
    		}
    	}
        
        setListaProductosBuscado(prod);

    }
	
    public void buscarProducto() {
		ajaxObtencionProductos();
	}
    
    
    

	public List<Product> getListaProductosBuscado() {
		return listaProductosBuscado;
	}

	public void setListaProductosBuscado(List<Product> listaProductosBuscado) {
		this.listaProductosBuscado = listaProductosBuscado;
	}

	public String[] getList() {
		return list;
	}

	public void setList(String[] list) {
		this.list = list;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	

	public List<Product> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Product> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public String getLista() {
		return lista;
	}

	public void setLista(String lista) {
		this.lista = lista;
	}

	public List<Product> getProductos() {
		return productos;
	}

	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}

	public List<Category> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Category> categorias) {
		this.categorias = categorias;
	}

	public CategoryFacade getEjbCategoria() {
		return ejbCategoria;
	}

	public void setEjbCategoria(CategoryFacade ejbCategoria) {
		this.ejbCategoria = ejbCategoria;
	}

	public ProductFacade getEjbProducto() {
		return ejbProducto;
	}

	public void setEjbProducto(ProductFacade ejbProducto) {
		this.ejbProducto = ejbProducto;
	}
    
    
}
