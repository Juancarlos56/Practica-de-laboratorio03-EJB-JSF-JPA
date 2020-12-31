package ec.edu.ups.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: BillHead
 *
 */
@Entity

public class BillHead implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hea_id")
	private int id;
	
	@Column(name = "hea_subtotal", nullable=false)
	private double subtotal;
	
	@Column(name = "hea_iva" , nullable = false)
    private int iva;
	
	@Column(name = "hea_date", nullable=false)
	private Date date;
	
	@Column(name = "hea_status", nullable=false, columnDefinition = "VARCHAR(10) DEFAULT 'Activo'")
	private char status;
	
	@Column(name = "hea_total", precision = 12, scale = 2, nullable=false)
	private double total;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "head_detail")
    private List<BillDetail> headDetails= new ArrayList<BillDetail>();
	
	@ManyToOne 
    @JoinColumn
    private User user_head;
	
	@ManyToOne 
    @JoinColumn
    private Client client_head;
	
	public BillHead() {
		super();
	}
   
}
