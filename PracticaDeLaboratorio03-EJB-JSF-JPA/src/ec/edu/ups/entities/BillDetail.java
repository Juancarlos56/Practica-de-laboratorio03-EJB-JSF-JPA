package ec.edu.ups.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: BillDetail
 *
 */
@Entity

public class BillDetail implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="det_id")
    private int cod_det;
	
	@Column(name="det_subtotal",  precision = 12, scale = 2, nullable = false)
    private int subtotal;
	
	@Column(name="det_amount", nullable = false)
    private int amount;
	
	@Column(name = "det_unit_price", precision = 10, scale = 2, nullable = false)
	private double unitPrice;
	
	@Column(name = "det_state", columnDefinition = "VARCHAR(10) DEFAULT 'Activo'")
	private boolean state;
	
	@ManyToOne 
    @JoinColumn(name="fk_productowarehouse_billdetail")
    private ProductWarehouse pro_war_detail;
	
	@ManyToOne 
    @JoinColumn(name="fk_billhead_billdetail")
    private BillHead head_detail;
	
	
	public BillDetail() {
		super();
	}
   
}
