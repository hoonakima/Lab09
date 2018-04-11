
package edu.handong.csee.java.lab09; //package name

/**
 * defines a SalesAssociate object, which has two data, name and sales.
 * Also, you can get and set the data by calling getter and setter.
 * 
 * @author jo jeong hoon
 *
 */
public class SalesAssociate { //defines SalesAssociate class

	private String name; //instance variable
	private double sales; //instance variable

	public SalesAssociate() { //default constructor
		name = "Null"; //set name as Null
		sales = 0; //set sales as 0
	}

	/**
	 * defines the constructor which has name and sales parameters.
	 * By this constructor, you can initialize the data. 
	 * And the data is entered into corresponding class variable.
	 * @param name refers sales associate's name.
	 * @param sales refers sales associate's sales.
	 */
	public SalesAssociate(String name, double sales) { //constructor
		this.name = name; //initialize the instance variable name by input parameter
		this.sales = sales; //initialize the instance variable sales by input parameter
	}

	/**
	 * returns sales associate's name.
	 * @return refers the name.
	 */
	public String getName() { //defines getter for name
		return name; //returns instance variable name
	}
	/**
	 * sets sales associate's name which is entered.
	 * @param name refers the entered name.
	 */
	public void setName(String name) { //defines setter for name
		this.name = name; //sets instance variable name as entered parameter value
	}
	/**
	 * returns sales associate's sales.
	 * @return refers the sale.
	 */
	public double getSales() { //defines getter for sales
		return sales; //returns instance variable sales
	}
	/**sets sales associate's sales which is entered.
	 * @param sales refers the entered sales.
	 */
	public void setSales(double sales) { //defines setter for sales
		this.sales = sales; //sets instance variable sales as entered parameter value
	}



}
