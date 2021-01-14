package ec.edu.ups.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.EJB.ProductWarehouseFacade;
import ec.edu.ups.EJB.UserFacade;
import ec.edu.ups.entities.BillDetail;
import ec.edu.ups.entities.BillHead;
import ec.edu.ups.entities.Client;
import ec.edu.ups.entities.User;



@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class BillHeadBean implements Serializable{

    
	private static final long serialVersionUID = 1L;

	
	@EJB
	private ProductWarehouseFacade ejbProductWarehouseFacade;
	
	@EJB
	private UserFacade ejbUserFacade;
	
	
	private Client user;
	private BillHead billHead;
	
	private boolean userSelected;
	private List<BillDetail> billDetailList;
	private String dniUserSearch;
	
	/**
     * Default constructor. 
     */
    public BillHeadBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
	public void init() {
		billDetailList = new ArrayList<>();
		dniUserSearch = "";
	}
	
	public String resetBilling() {
		billHead = null;
		user = null;
		userSelected = false;
		billDetailList = null;
		return null;
	}
	
	public ProductWarehouseFacade getEjbProductWarehouseFacade() {
		return ejbProductWarehouseFacade;
	}



	public void setEjbProductWarehouseFacade(ProductWarehouseFacade ejbProductWarehouseFacade) {
		this.ejbProductWarehouseFacade = ejbProductWarehouseFacade;
	}



	public UserFacade getEjbUserFacade() {
		return ejbUserFacade;
	}



	public void setEjbUserFacade(UserFacade ejbUserFacade) {
		this.ejbUserFacade = ejbUserFacade;
	}



	public void setUser(Client user) {
		System.out.println("JOderrrrrrr: cliente nuevo"+user.toString());
		this.user = user;
	}



	public String changeUser() {
		this.userSelected = false;
		return null;
	}
	
	public Client getUser() {
		return user;
	}

	public BillHead getBillHead() {
		return billHead;
	}

	public void setBillHead(BillHead billHead) {
		this.billHead = billHead;
	}

	public boolean isUserSelected() {
		return userSelected;
	}

	public void setUserSelected(boolean userSelected) {
		this.userSelected = userSelected;
	}

	public List<BillDetail> getBillDetailList() {
		return billDetailList;
	}

	public void setBillDetailList(List<BillDetail> billDetailList) {
		this.billDetailList = billDetailList;
	}

	public String getDniUserSearch() {
		return dniUserSearch;
	}

	public void setDniUserSearch(String dniUserSearch) {
		this.dniUserSearch = dniUserSearch;
	}

}
