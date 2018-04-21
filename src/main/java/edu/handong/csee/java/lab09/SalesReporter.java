package edu.handong.csee.java.lab09; //package name

import java.util.ArrayList;
import java.util.Scanner; //import Scanner class

/**
 * defines a SalesReporter object.
 * This object has three data, which are highestSales, averageSales, and array of SalesAssociate class.
 * By entering sales associate's name and sales, you can figure out whose sales is highest, 
 * the average sales of total sales associates, and the difference between average sales and each sales associate's sales.
 *
 * @author jo jeong hoon
 *
 */
public class SalesReporter { //defines SalesReporter class

	private double highestSales; //instance variable
	private double averageSales; //instance variable
	private ArrayList<SalesAssociate> team;
	private int numOfAssociates; //instance variable




	/**
	 * gets the number of total sales associates, name and sales of each sales associates.
	 * And it sets the data of SalesAssociate object. 
	 */
	public void getData() { //defines the getData method
		Scanner keyboard = new Scanner(System.in); //instantiate Scanner object

		team = new ArrayList<SalesAssociate>();
		boolean done = false;

		while(!done) {

			SalesAssociate mySalesAssociate = new SalesAssociate(); //instantiate the SalesAssociate object


			System.out.println("Enter data for associate"); //print the line
			System.out.print("Enter name of sales associate: "); //print the line
			String name = keyboard.nextLine(); //set local variable name as entered value
			mySalesAssociate.setName(name); //set name data of mySalesAssociate object as the variable name.


			System.out.print("Enter associate's sales: $ "); //print the line 
			double sales = keyboard.nextDouble(); //set local variable sales as entered value
			mySalesAssociate.setSales(sales); //set sales data of mySalesAssociate object as the variable sales.

			team.add(mySalesAssociate);

			System.out.println("Do you want to enter more data of a sales associate? [yes/no]:");
			String ans = keyboard.nextLine();
			ans = keyboard.nextLine();
	
			if(ans.equalsIgnoreCase("no"))
				done = true;
		}
	}



	/**
	 * computes average sales of total sales associates.
	 * And it discriminates whose sales is highest.
	 */
	public void computeStates() { //defines computeStates method

		double sum = 0; //local variable

		for(SalesAssociate salesAssociate : team ) { //for loop
			sum += salesAssociate.getSales();
		}

		averageSales = (int)sum/team.size(); //get average of sales, and make the average value as integer by casting.

		SalesAssociate man = team.get(0);

		highestSales = man.getSales(); //suppose the sales of first object is highest one.

		for(SalesAssociate salesAssociate : team ) { //for loop
			if(salesAssociate.getSales() > highestSales) //if the sales of other object is higher than first one
				highestSales = salesAssociate.getSales(); //assign highestSales as the sales of the other one. If not, there is no change.
		}

	}

	/**
	 * shows all results, which are average sales, highest sales, whose sale is highest,
	 * and the difference between the average and sales of each sales associate.
	 * 
	 */
	public void displayResults() { //defines displayResults method

		System.out.println("Average sales per associate is $" + averageSales); //print the line
		System.out.println("The highest sales figure is $" + highestSales); //print the line
		System.out.println(""); //print enter
		System.out.println("The following had the highest sales: "); //print the line

		for(SalesAssociate salesAssociate : team ) { //for loop

			if(highestSales == salesAssociate.getSales()) { //when the sales of ith object is highest one 
				System.out.println("Name: " + salesAssociate.getName()); //print the name of the object
				System.out.println("Sales: $" + salesAssociate.getSales()); //print the sales of the object
				System.out.println("$" + (salesAssociate.getSales()- averageSales)+ " above the average."); //print the difference between the sales and the average.
				System.out.println(); //print enter
			}
		}	

		System.out.println("The rest performed as follows: "); //print the line

		for(SalesAssociate salesAssociate : team ) { //for loop

			if(highestSales != salesAssociate.getSales()) { //this case is for the rest objects
				System.out.println("Name: " + salesAssociate.getName()); //print the name of object
				System.out.println("Sales: $" + salesAssociate.getSales()); //print the sales of object
				if(averageSales < salesAssociate.getSales()) { //when average is smaller than the sales of the object
					System.out.println("$" + (salesAssociate.getSales()- averageSales)+ " above the average. " ); //the average subtracted from the sales  
					System.out.println(); //print enter
				}
				if(averageSales == salesAssociate.getSales()) { //when average is same with the sales of the object
					System.out.println("Sales is same with the average."); //print the line
					System.out.println(); //print enter
				}
				if(averageSales > salesAssociate.getSales()) { //hen average is bigger than the sales of the object
					System.out.println("$" + (averageSales - salesAssociate.getSales())+ " below the average. "); //the sales subtracted from the average
					System.out.println(""); //print enter
				}

			}
		}

	}

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

	/**
	 * starts this program.
	 * @param args refers command-line arguments as an array of String objects.
	 */
	public static void main(String[] args) { //defines the main method

		SalesReporter mySalesReporter = new SalesReporter(); //instantiate a SalesReporter object

		mySalesReporter.getData(); //call getData method
		mySalesReporter.computeStates(); //call computeStates method
		mySalesReporter.displayResults(); //call displayResults method

	}





}
