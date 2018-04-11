
package edu.handong.csee.java.lab09; 

/**
 * defines a SalesAssociate object, which has two data, name and sales.
 * Also, you can get and set the data by calling getter and setter.
 * 
 * @author jo jeong hoon
 *
 */
public class SalesAssociate {

	private String name;
	private double sales;

	public SalesAssociate() {
		name = "Null";
		sales = 0;
	}

	/**
	 * defines the constructor which has name and sales parameters.
	 * By this constructor, you can initialize the data. 
	 * And the data is entered into corresponding class variable.
	 * @param name refers sales associate's name.
	 * @param sales refers sales associate's sales.
	 */
	public SalesAssociate(String name, double sales) {
		this.name = name;
		this.sales = sales;
	}

	/**
	 * returns sales associate's name.
	 * @return refers the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets sales associate's name which is entered.
	 * @param name refers the entered name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * returns sales associate's sales.
	 * @return refers the sale.
	 */
	public double getSales() {
		return sales;
	}
	/**sets sales associate's sales which is entered.
	 * @param sales refers the entered sales.
	 */
	public void setSales(double sales) {
		this.sales = sales;
	}



}
