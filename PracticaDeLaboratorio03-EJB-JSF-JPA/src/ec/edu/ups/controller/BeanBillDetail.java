package ec.edu.ups.controller;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
public class BeanBillDetail implements Serializable {


	private static final long serialVersionUID = 1L;

	/**
     * Default constructor. 
     */
    public BeanBillDetail() {
        // TODO Auto-generated constructor stub
    }

}
