package edu.handong.csee.java.lab09;

import java.util.Scanner;

public class SalesReporter {

	private double highestSales;
	private double averageSales;
	private SalesAssociate[] team;// Team array's type is SalesAssociate class.
	private int numOfAssociates;




	public void getData() {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter number of sales associates:");
		this.numOfAssociates = keyboard.nextInt();


		team = new SalesAssociate[numOfAssociates];


		for(int i=0; i< numOfAssociates; i++ ) {

			SalesAssociate mySalesAssociate = new SalesAssociate();

			team[i] = mySalesAssociate;

			System.out.println("Enter data for associate number " + (i+1));
			System.out.print("Enter name of sales associate: ");
			String name = keyboard.nextLine();
			name = keyboard.nextLine();
			System.out.print("Enter associate's sales: $ ");
			double sales = keyboard.nextDouble();

			mySalesAssociate.setName(name);
			mySalesAssociate.setSales(sales);


		}
	}



	public void computeStates() {

		double sum = 0;

		for(int i=0; i< numOfAssociates; i++ ) {
			sum += team[i].getSales(); //바로 double sum 하면 안되는 이유?
		}

		averageSales = (int)sum/numOfAssociates;

		highestSales = team[0].getSales();
		for(int i=1; i<numOfAssociates; i++) {
			if(team[i].getSales()>highestSales)
				highestSales = team[i].getSales();
		}

	}

	public void displayResults() {

		System.out.println("Average sales per associate is $" + averageSales);
		System.out.println("The highest sales figure is $" + highestSales);
		System.out.println("");
		System.out.println("The following had the highest sales: ");

		for(int i=0; i<numOfAssociates; i++) {

			if(highestSales == team[i].getSales()) {
				System.out.println("Name: " + team[i].getName());
				System.out.println("Sales: $" + team[i].getSales());
				System.out.println("$" + (team[i].getSales()- averageSales)+ " above the average.");
				System.out.println("");
			}
		}	

		System.out.println("The rest performed as follows: ");
		for(int i=0; i<numOfAssociates; i++) {

			if(highestSales != team[i].getSales()) {
				System.out.println("Name: " + team[i].getName());
				System.out.println("Sales: $" + team[i].getSales());
				if(averageSales < team[i].getSales()) {
					System.out.println("$" + (team[i].getSales()- averageSales)+ " above the average. " );
					System.out.println("");
				}
				if(averageSales == team[i].getSales()) {
					System.out.println("Sales is same with the average." + "%n");
					System.out.println("");
				}
				if(averageSales > team[i].getSales()) {
					System.out.println("$" + (averageSales - team[i].getSales())+ " below the average. ");
					System.out.println("");
				}

			}
		}

	}
	
	public static void main(String[] args) {

		SalesReporter mySalesReporter = new SalesReporter();

		mySalesReporter.getData();
		mySalesReporter.computeStates();
		mySalesReporter.displayResults();

	}





}
