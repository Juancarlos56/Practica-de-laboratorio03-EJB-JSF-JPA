package ec.edu.ups.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cat_id")
    private int cod_cat;
	
	@Column(name="cat_name", length=255, nullable=false, unique=true)
	private String CategoryName;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category_product")
    private List<Product> products= new ArrayList<Product>();
	
	
	public Category() {
		super();
	}


	public Category(int cod_cat, String categoryName) {
		super();
		this.cod_cat = cod_cat;
		CategoryName = categoryName;
	}

	
	public Category(String categoryName) {
		super();
		CategoryName = categoryName;
	}

	public int getCod_cat() {
		return cod_cat;
	}


	public void setCod_cat(int cod_cat) {
		this.cod_cat = cod_cat;
	}


	public String getCategoryName() {
		return CategoryName;
	}


	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProducts(Product product) {
		this.products.add(product);
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
	
}
