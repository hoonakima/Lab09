package edu.handong.csee.java.lab09; 


public class SalesAssociate {

	private String name;
	private double sales;

	public SalesAssociate() {
		name = "Null";
		sales = 0;
	}


	public SalesAssociate(String name, double sales) {
		this.name = name;
		this.sales = sales;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSales() {
		return sales;
	}
	public void setSales(double sales) {
		this.sales = sales;
	}



}
