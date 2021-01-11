package ec.edu.ups.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Ajax implements Serializable{

    private static final long serialVersionUID = 1L;
    private String level1, level2, level3;
    private boolean level2ListDisabled = true, level3ListDisabled = true;

    public String getLevel3() {
	return level3;
    }

    public void setLevel3(String level3) {
	this.level3 = level3;
    }

    public boolean isLevel2ListDisabled() {
	return level2ListDisabled;
    }

    public void setLevel2ListDisabled(boolean level2ListDisabled) {
	this.level2ListDisabled = level2ListDisabled;
    }

    public boolean isLevel3ListDisabled() {
	return level3ListDisabled;
    }

    public void setLevel3ListDisabled(boolean level3ListDisabled) {
	this.level3ListDisabled = level3ListDisabled;
    }

    public String getLevel1() {
	return level1;
    }

    public String getLevel2() {
	return level2;
    }

    public void setLevel1(String level1) {
	this.level1 = level1;
	this.setLevel2("---Elige---");
	this.level2ListDisabled = this.level1.equals("---Elige---");
    }

    public void setLevel2(String level2) {
	this.level2 = level2;
	this.setLevel3("---Elige---");
	this.level3ListDisabled = this.level2.equals("---Elige---");
    }

    private String[] generateList(String pre, int size) {
	String[] list = new String[size];
	list[0] = "---Elige---";
	for (int i = 1; i < size; i++)
	    list[i] = pre + i;
	return list;
    }

    public String[] getLevel1List() {
	return this.generateList("", 5);
    }

    public String[] getLevel2List() {
	if (this.level2ListDisabled)
	    return this.generateList("", 1);
	else
	    return this.generateList(this.level1 + "--", 5);
    }

    public String[] getLevel3List() {
	if (this.level3ListDisabled)
	    return this.generateList("", 1);
	else
	    return this.generateList(this.level2 + "--", 5);
    }
}
