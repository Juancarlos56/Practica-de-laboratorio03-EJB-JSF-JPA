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
import ec.edu.ups.EJB.ProductWarehouseFacade;
import ec.edu.ups.EJB.UserFacade;
import ec.edu.ups.EJB.WarehouseFacade;
import ec.edu.ups.entities.Category;
import ec.edu.ups.entities.Product;
import ec.edu.ups.entities.ProductWarehouse;
import ec.edu.ups.entities.Warehouse;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class WarehouseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private boolean b; 
	private int bodega = 0;
	private int bodegaActual;	
	
	
	private String[] list;
    private String categoria;
    private String text = "";
    
    private ArrayList<Product> listaArr  = new ArrayList<Product>();
    private String lista = "";
    private List<Product> productos;
    private List<Category> categorias;
    private List<Warehouse> bodegas;
    private List<Product> listaProductos;
    private List<Product> listaProductosBuscado; 
    private List<ProductWarehouse> productosBuscadoBodega; 
    private Warehouse bodegaSeleccionada;
    private List<ProductWarehouse> productosBodegaSelect;
    
	@EJB
	private CategoryFacade ejbCategoria;
	
	@EJB
	private ProductFacade ejbProducto;
	
	@EJB
	private WarehouseFacade ejbBodega;
	
	@EJB
	private UserFacade ejbUsuario;
	
	@EJB
	private ProductWarehouseFacade ejbproductoBodega;
	
    public WarehouseBean() {
        // TODO Auto-generated constructor stub
    }
    
    
    @PostConstruct
	public void init(){
		productos=ejbProducto.findAll();
		categorias=ejbCategoria.findAll();
		bodegas=ejbBodega.findAll();
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
		

		for (int i = 1; i < categorias.size(); i++) {
		    list[i] = "" +  categorias.get(i-1).getCategoryName();
		}
		
		
    	
		return this.list;
	}
    
    
    public void ajaxObtencionProductosBodega(String bodega) {
		System.out.println("Texto de busqueda: " + text);
        System.out.println("Seleccionada : " + categoria);
        System.out.println("Bodega : " + bodega);
        List<ProductWarehouse> prodBodega = new ArrayList<ProductWarehouse>(); 
        List<Product> prod = new ArrayList<Product>(); 
        
        
        Warehouse bodegaProductos=null; 
        String cat; 
        String nomPro;
        
        for (Warehouse bodegaABuscada : getBodegas()) {
			if (bodegaABuscada.getWareHouseName().equals(bodega)) {
				bodegaProductos = bodegaABuscada;
			}
		}
        
        List<ProductWarehouse> productosBodega = bodegaProductos.getWarehousesProduct();
		
		
		
		
        
        if(getCategoria().equals("Todas")) {
        	if (getText().equals("")) {
        		for (ProductWarehouse productWareHouse : productosBodega) {
        			prodBodega.add(productWareHouse);	
        		}
			}else {
				System.out.println("Joder...............................................................");
				for (ProductWarehouse productWareHouse : productosBodega) {
        			nomPro = productWareHouse.getProduct_ware_pro().getProductName();
        			if (nomPro.toLowerCase().contains(text.toLowerCase())) {
						//prod.add(productWareHouse.getProduct_ware_pro());
        				prodBodega.add(productWareHouse);
	    			}
        		}
			}
    	}else {
    		for (ProductWarehouse productWareHouse : productosBodega) {
    			cat  = productWareHouse.getProduct_ware_pro().getCategory_product().getCategoryName();
    			if (cat.equalsIgnoreCase(getCategoria())) {
    				if (getText().equals("")) {
    					prodBodega.add(productWareHouse);
    				}else {
    					nomPro = productWareHouse.getProduct_ware_pro().getProductName();
        				if (nomPro.toLowerCase().contains(text.toLowerCase())) {
    						//prod.add(productWareHouse.getProduct_ware_pro());
        					prodBodega.add(productWareHouse);
    	    			}
    				}
    			}	
    		}
    	}
        
        //setListaProductosBuscado(prod);
        setProductosBuscadoBodega(prodBodega);
    }
    
    
    
    public void buscarProducto(String bodega) {
    	ajaxObtencionProductosBodega(bodega);
	}
    
    
    public String buscarProductoBodegaCodigo(int cod) {
    	System.out.println("Este es el codigo: >>>>>>>>>"+cod);
    	bodegaSeleccionada= ejbBodega.find(cod);
    	productosBodegaSelect = bodegaSeleccionada.getWarehousesProduct();
    	
		return "listo";
	}
    
    
    
    
    public void editarProducto(ProductWarehouse p) {
    	System.out.println("Editar producto"+p.getProduct_ware_pro().getProductName());
		ejbproductoBodega.edit(p);
		//return "listo";
	}
    
    
    public String eliminarProducto(ProductWarehouse p) {	
    	p.setProductState("Inactivo");
    	ejbproductoBodega.edit(p);	
    	return "listo";
	}
    
    

	public ProductWarehouseFacade getEjbproductoBodega() {
		return ejbproductoBodega;
	}


	public void setEjbproductoBodega(ProductWarehouseFacade ejbproductoBodega) {
		this.ejbproductoBodega = ejbproductoBodega;
	}


	public List<ProductWarehouse> getProductosBodegaSelect() {
		return productosBodegaSelect;
	}


	public void setProductosBodegaSelect(List<ProductWarehouse> productosBodegaSelect) {
		this.productosBodegaSelect = productosBodegaSelect;
	}


	public Warehouse getBodegaSeleccionada() {
		return bodegaSeleccionada;
	}


	public void setBodegaSeleccionada(Warehouse bodegaSeleccionada) {
		this.bodegaSeleccionada = bodegaSeleccionada;
	}


	public List<ProductWarehouse> getProductosBuscadoBodega() {
		return productosBuscadoBodega;
	}


	public void setProductosBuscadoBodega(List<ProductWarehouse> productosBuscadoBodega) {
		this.productosBuscadoBodega = productosBuscadoBodega;
	}


	public List<Product> getListaProductos() {
		return listaProductos;
	}


	public void setListaProductos(List<Product> listaProductos) {
		this.listaProductos = listaProductos;
	}


	public List<Product> getListaProductosBuscado() {
		return listaProductosBuscado;
	}


	public void setListaProductosBuscado(List<Product> listaProductosBuscado) {
		this.listaProductosBuscado = listaProductosBuscado;
	}


	public boolean isB() {
		return b;
	}


	public void setB(boolean b) {
		this.b = b;
	}


	public int getBodega() {
		return bodega;
	}


	public void setBodega(int bodega) {
		this.bodega = bodega;
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


	public List<Warehouse> getBodegas() {
		return bodegas;
	}


	public void setBodegas(List<Warehouse> bodegas) {
		this.bodegas = bodegas;
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


	public ArrayList<Product> getListaArr() {
		return listaArr;
	}


	public void setListaArr(ArrayList<Product> listaArr) {
		this.listaArr = listaArr;
	}


	public String getLista() {
		return lista;
	}


	public void setLista(String lista) {
		this.lista = lista;
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


	public WarehouseFacade getEjbBodega() {
		return ejbBodega;
	}


	public void setEjbBodega(WarehouseFacade ejbBodega) {
		this.ejbBodega = ejbBodega;
	}


	public UserFacade getEjbUsuario() {
		return ejbUsuario;
	}


	public void setEjbUsuario(UserFacade ejbUsuario) {
		this.ejbUsuario = ejbUsuario;
	}


	public int getBodegaActual() {
		return bodegaActual;
	}


	public void setBodegaActual(int bodegaActual) {
		this.bodegaActual = bodegaActual;
	}
	
    
    
    
    
    
    
    
    

}
