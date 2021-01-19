package ec.edu.ups.test;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import ec.edu.ups.EJB.CategoryFacade;
import ec.edu.ups.EJB.CityFacade;
import ec.edu.ups.EJB.ClientFacade;
import ec.edu.ups.EJB.CompanyFacade;
import ec.edu.ups.EJB.ProvinceFacade;
import ec.edu.ups.EJB.ProductFacade;
import ec.edu.ups.EJB.ProductWarehouseFacade;
import ec.edu.ups.EJB.UserFacade;
import ec.edu.ups.EJB.WarehouseFacade;
import ec.edu.ups.entities.Category;
import ec.edu.ups.entities.City;
import ec.edu.ups.entities.Client;
import ec.edu.ups.entities.Company;
import ec.edu.ups.entities.Product;
import ec.edu.ups.entities.ProductWarehouse;
import ec.edu.ups.entities.Province;
import ec.edu.ups.entities.User;
import ec.edu.ups.entities.Warehouse;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class DataCreate implements Serializable{

    
	private static final long serialVersionUID = 1L;

	@EJB
    private CategoryFacade ejbCategoria;
	@EJB
	private ProductFacade ejbProducto;
	@EJB
	private WarehouseFacade ejbBodega;
	@EJB
	private ProvinceFacade ejbProvince;
	@EJB
	private CityFacade ejbCity;
	@EJB
	private CompanyFacade ejbCompany;
	@EJB
	private UserFacade ejbUser;
	@EJB
	private ProductWarehouseFacade ejbWarehouseProduct;
	@EJB
	private ClientFacade ejbClient;
	
	/**
     * Default constructor. 
     */
    public DataCreate() {
    	
    }
    
   public void creacionDatosEstaticos() {
    	
    	//Carga de Empresa
    	Company emp = new Company("Tu Hogar", "https://laopinion.com/wp-content/uploads/sites/3/2018/02/shutterstock_380743111.jpg?quality=80&strip=all&w=1000"
    							, "Empresa para la distribucion de productos para el hogar", "Quito-Guayaquil-Cuenca");
    	
    	ejbCompany.create(emp);
    	
    	
		//Carga de Provincias
		Province provi = new Province("Pichincha");
		Province provi2 = new Province("Azuay");
		Province provi3 = new Province("Guayas");
		
		ejbProvince.create(provi);
		ejbProvince.create(provi2);
		ejbProvince.create(provi3);
		
		//Carga de Ciudades
		City ciu = new City("Quito", "170102", provi);
		City ciu2 = new City("Cuenca", "010107", provi2);
		City ciu3 = new City("Guayaquil", "092301",provi3);
		
		ejbCity.create(ciu);
		ejbCity.create(ciu2);
		ejbCity.create(ciu3);
		
		
		//Carga de Categorias
    	Category cat=new Category("Medica");
    	Category cat2=new Category("Infantil");
    	Category cat3=new Category("Limpieza");
    	Category cat4=new Category("Cocina");
    	//Category cat5=new Category("Electricidad");
    	//Category cat6=new Category("Industrial");
    	//Category cat7=new Category("Electrodomesticos");
    	//Category cat8=new Category("Ferreteria");
    	
    	ejbCategoria.create(cat);
		ejbCategoria.create(cat2);
		ejbCategoria.create(cat3);
		ejbCategoria.create(cat4);
		//ejbCategoria.create(cat5);
		//ejbCategoria.create(cat6);
		//ejbCategoria.create(cat7);
		//ejbCategoria.create(cat8);
		
		//Carga de productos
		
		//Medica
		Product prod=new Product("Andador",45.0, "https://vidaabuelo.com/wp-content/uploads/2016/11/andador-plegable-sin-ruedas.jpg"
						, "Andador para adultos", "Activo",cat);
		Product prod2=new Product("Camillas",1200.0, "https://static.elcontainer.cl/9960-big_default/camilla-de-masajes-color-negro.jpg"
						, "Camillas para hospital", "Activo", cat);
		Product prod3=new Product("Bandeja de Acero",50.0, "https://www.dhmaterialmedico.com/material-medico/fotos/material-hospitalario-1421836754.jpg"
						, "Bandeja de acero inoxidable", "Activo", cat);
		
		
		//Infantil
		Product prod4=new Product("Asientos para niños",140.0, "https://red-viajes.com/wp-content/uploads/2019/09/leyes-de-asientos-de-autos-de-florida.jpg", 
						"Asiento para llevar niños en el auto", "Activo",cat2);
		Product prod5=new Product("Bicicletas",430.0, "https://images-na.ssl-images-amazon.com/images/I/71MjTRRo85L._AC_SX425_.jpg" , 
						"Bicicletas para niños", "Activo", cat2);
		Product prod6=new Product("Andador",45.0, "https://images-na.ssl-images-amazon.com/images/I/61V5t7CFD2L._AC_SX425_.jpg", 
						"Andador para niños","Activo",  cat2);
		
		
		//Limpieza
		Product prod7=new Product("Cloro",3.25, "https://tiaecuador.vteximg.com.br/arquivos/ids/155988-1000-1000/2000223.jpg?v=636229609828370000", 
							"Cloro marca clorox", "Activo",  cat3);
		Product prod8=new Product("Jabon Protex",2.00, "https://production-tailoy-repo-magento-statics.s3.amazonaws.com/imagenes/872x872/productos/i/j/a/jabon-protex-avena-75gr-43561-default-1.jpg", 
							"jabon para limpienza del cuerpo", "Activo", cat3);
		Product prod9=new Product("Crema Dental",2.25, "https://tiaecuador.vteximg.com.br/arquivos/ids/168366-1000-1000/167045000.jpg?v=637323750015200000", 
							"pasta dental Colgate", "Activo", cat3);
		
		//Cocina
		Product prod10=new Product("Platos",6.0, "https://gastronomiaycia.republica.com/wp-content/uploads/2012/01/plato_esmaltado_clasico.jpg",
								"platos de loza", "Activo", cat4);
		Product prod11=new Product("Cubiertos", 1.50, "https://images-na.ssl-images-amazon.com/images/I/81UMq0G-ymL._AC_SX466_.jpg",
								"cubiertos de plata", "Activo", cat4);
		Product prod12=new Product("Cuchillos",3.0, "https://assets.tramontina.com.br/upload/tramon/imagens/CUT/23498048PNM001G.png",
								"Cuchillos de plata", "Activo", cat4);
		
		ejbProducto.create(prod);
		ejbProducto.create(prod2);
		ejbProducto.create(prod3);
		ejbProducto.create(prod4);
		ejbProducto.create(prod5);
		ejbProducto.create(prod6);
		ejbProducto.create(prod7);
		ejbProducto.create(prod8);
		ejbProducto.create(prod9);
		ejbProducto.create(prod10);
		ejbProducto.create(prod11);
		ejbProducto.create(prod12);
		
		
		//Carga de Bodegas
		Warehouse bod = new Warehouse("Tu hogar Quito", "Bodega ubicada en Quito", "Activa", ciu);
		Warehouse bod2 = new Warehouse("Tu hogar Cuenca", "Bodega ubicada en cuenca", "Activa", ciu2);
		Warehouse bod3 = new Warehouse("Tu hogar Guayaquil", "Bodega ubicada en Guayaquil", "Activa", ciu3);
		
		ejbBodega.create(bod);
		ejbBodega.create(bod2);
		ejbBodega.create(bod3);
		
    	
		//Carga informacion stock de productos
		

		ProductWarehouse productoBodega = new ProductWarehouse("Activo", 10, bod, prod);
		ProductWarehouse productoBodega2 = new ProductWarehouse("Activo", 12, bod, prod2);
		ProductWarehouse productoBodega3 = new ProductWarehouse("Activo", 14, bod, prod3);
		ProductWarehouse productoBodega4 = new ProductWarehouse("Activo", 10, bod, prod4);
		ProductWarehouse productoBodega5 = new ProductWarehouse("Activo", 10, bod, prod5);
		ProductWarehouse productoBodega6 = new ProductWarehouse("Activo", 12, bod, prod6);
		ProductWarehouse productoBodega7 = new ProductWarehouse("Activo", 14, bod, prod7);
		ProductWarehouse productoBodega8 = new ProductWarehouse("Activo", 10, bod, prod8);
		ProductWarehouse productoBodega9 = new ProductWarehouse("Activo", 10, bod, prod9);
		ProductWarehouse productoBodega10 = new ProductWarehouse("Activo", 12, bod, prod10);
		ProductWarehouse productoBodega11 = new ProductWarehouse("Activo", 14, bod, prod11);
		ProductWarehouse productoBodega12 = new ProductWarehouse("Activo", 10, bod, prod12);
		
		
		
		ProductWarehouse productoBodega13 = new ProductWarehouse("Activo", 10, bod2, prod);
		ProductWarehouse productoBodega14 = new ProductWarehouse("Activo", 12, bod2, prod2);
		ProductWarehouse productoBodega15 = new ProductWarehouse("Activo", 14, bod2, prod3);
		ProductWarehouse productoBodega16 = new ProductWarehouse("Activo", 10, bod2, prod4);
		ProductWarehouse productoBodega17 = new ProductWarehouse("Activo", 10, bod2, prod5);
		ProductWarehouse productoBodega18 = new ProductWarehouse("Activo", 12, bod2, prod6);
		ProductWarehouse productoBodega19 = new ProductWarehouse("Activo", 14, bod2, prod7);
		ProductWarehouse productoBodega20 = new ProductWarehouse("Activo", 10, bod2, prod8);
		ProductWarehouse productoBodega21 = new ProductWarehouse("Activo", 10, bod2, prod9);
		ProductWarehouse productoBodega22 = new ProductWarehouse("Activo", 12, bod2, prod10);
		ProductWarehouse productoBodega23 = new ProductWarehouse("Activo", 14, bod2, prod11);
		ProductWarehouse productoBodega24 = new ProductWarehouse("Activo", 10, bod2, prod12);
		
		
		ProductWarehouse productoBodega25 = new ProductWarehouse("Activo", 10, bod3, prod);
		ProductWarehouse productoBodega26 = new ProductWarehouse("Activo", 12, bod3, prod2);
		ProductWarehouse productoBodega27 = new ProductWarehouse("Activo", 14, bod3, prod3);
		ProductWarehouse productoBodega28 = new ProductWarehouse("Activo", 10, bod3, prod4);
		ProductWarehouse productoBodega29 = new ProductWarehouse("Activo", 10, bod3, prod5);
		ProductWarehouse productoBodega30 = new ProductWarehouse("Activo", 12, bod3, prod6);
		ProductWarehouse productoBodega31 = new ProductWarehouse("Activo", 14, bod3, prod7);
		ProductWarehouse productoBodega32 = new ProductWarehouse("Activo", 10, bod3, prod8);
		ProductWarehouse productoBodega33 = new ProductWarehouse("Activo", 10, bod3, prod9);
		ProductWarehouse productoBodega34 = new ProductWarehouse("Activo", 12, bod3, prod10);
		ProductWarehouse productoBodega35 = new ProductWarehouse("Activo", 14, bod3, prod11);
		ProductWarehouse productoBodega36 = new ProductWarehouse("Activo", 10, bod3, prod12);
		
		
		ejbWarehouseProduct.create(productoBodega);
		ejbWarehouseProduct.create(productoBodega2);
		ejbWarehouseProduct.create(productoBodega3);
		ejbWarehouseProduct.create(productoBodega4);
		ejbWarehouseProduct.create(productoBodega5);
		ejbWarehouseProduct.create(productoBodega6);
		ejbWarehouseProduct.create(productoBodega7);
		ejbWarehouseProduct.create(productoBodega8);
		ejbWarehouseProduct.create(productoBodega9);
		ejbWarehouseProduct.create(productoBodega10);
		ejbWarehouseProduct.create(productoBodega11);
		ejbWarehouseProduct.create(productoBodega12);
		ejbWarehouseProduct.create(productoBodega13);
		ejbWarehouseProduct.create(productoBodega14);
		ejbWarehouseProduct.create(productoBodega15);
		ejbWarehouseProduct.create(productoBodega16);
		ejbWarehouseProduct.create(productoBodega17);
		ejbWarehouseProduct.create(productoBodega18);
		ejbWarehouseProduct.create(productoBodega19);
		ejbWarehouseProduct.create(productoBodega20);
		ejbWarehouseProduct.create(productoBodega21);
		ejbWarehouseProduct.create(productoBodega22);
		ejbWarehouseProduct.create(productoBodega23);
		ejbWarehouseProduct.create(productoBodega24);
		ejbWarehouseProduct.create(productoBodega25);
		ejbWarehouseProduct.create(productoBodega26);
		ejbWarehouseProduct.create(productoBodega27);
		ejbWarehouseProduct.create(productoBodega28);
		ejbWarehouseProduct.create(productoBodega29);
		ejbWarehouseProduct.create(productoBodega30);
		ejbWarehouseProduct.create(productoBodega31);
		ejbWarehouseProduct.create(productoBodega32);
		ejbWarehouseProduct.create(productoBodega33);
		ejbWarehouseProduct.create(productoBodega34);
		ejbWarehouseProduct.create(productoBodega35);
		ejbWarehouseProduct.create(productoBodega36);

		
		User user = new User("barrerajuan930@gmail.com", "5665", "Juan Barrera", "Usuario", "Activo");
		User user2 = new User("katerinbarrera21@gmail.com", "5665", "Katerin Barrera", "Usuario", "Activo");
		User user3 = new User("johnhenrychiqui@gmail.com", "5665", "John Chiqui", "Usuario", "Activo");
		User user4 = new User("jbarrerab1@est.ups.edu.ec", "5665", "Juan Barrera", "Admin", "Activo");
		User user5 = new User("kbarrerab1@est.ups.edu.ec", "5665", "Katerin Barrera", "Admin", "Activo");
		User user6 = new User("jchiquic@est.ups.edu.ec", "5665", "John Chiqui", "Admin", "Activo");
		
		ejbUser.create(user);
		ejbUser.create(user2);
		ejbUser.create(user3);
		ejbUser.create(user4);
		ejbUser.create(user5);
		ejbUser.create(user6);
		
		
		Client cli = new Client(0, "barrerajuan930@gmail.com", "0106113301", "Juan", "Barrera", "Activo");
		Client cli2 = new Client(0, "katerinbarrera21@gmail.com", "0106114309", "Katherine", "Barrera", "Activo");
		
		ejbClient.create(cli);
		ejbClient.create(cli2);
		
    }
    
    
}
