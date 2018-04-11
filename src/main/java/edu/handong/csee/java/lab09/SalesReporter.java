package edu.handong.csee.java.lab09; //package name
 
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
	private SalesAssociate[] team;// the name of the array is team, and the type of the array is SalesAssociate object
	private int numOfAssociates; //instance variable




	/**
	 * gets the number of total sales associates, name and sales of each sales associates.
	 * And it sets the data of SalesAssociate object. 
	 */
	public void getData() { //defines the getData method
		Scanner keyboard = new Scanner(System.in); //instantiate Scanner object

		System.out.println("Enter number of sales associates:"); //print the line
		this.numOfAssociates = keyboard.nextInt(); //set the instance variable as the entered value.


		team = new SalesAssociate[numOfAssociates]; //instantiate the team array by entering the length of the array


		for(int i=0; i< numOfAssociates; i++ ) { //for loop starts from i is 0, and repeats until i is smaller than numOfAssociates 

			SalesAssociate mySalesAssociate = new SalesAssociate(); //instantiate the SalesAssociate object

			team[i] = mySalesAssociate; //set the team array value as mySalesAssociate object

			System.out.println("Enter data for associate number " + (i+1)); //print the line
			System.out.print("Enter name of sales associate: "); //print the line
			String name = keyboard.nextLine(); //set local variable name as entered value
			name = keyboard.nextLine(); //when entering the length of the team array, the "enter" inputs keyboard.nextLine(). So, write the code one more.
			System.out.print("Enter associate's sales: $ "); //print the line 
			double sales = keyboard.nextDouble(); //set local variable sales as entered value

			mySalesAssociate.setName(name); //set name data of mySalesAssociate object as the variable name.
			mySalesAssociate.setSales(sales); //set sales data of mySalesAssociate object as the variable sales.


		}
	}



	/**
	 * computes average sales of total sales associates.
	 * And it discriminates whose sales is highest.
	 */
	public void computeStates() { //defines computeStates method

		double sum = 0; //local variable

		for(int i=0; i< numOfAssociates; i++ ) { //for loop
			sum += team[i].getSales(); //sums all sales of each objects, which are in the team array.
		}

		averageSales = (int)sum/numOfAssociates; //get average of sales, and make the average value as integer by casting.

		highestSales = team[0].getSales(); //suppose the sales of first object is highest one.
		for(int i=1; i<numOfAssociates; i++) { //for loop
			if(team[i].getSales()>highestSales) //if the sales of other object is higher than first one
				highestSales = team[i].getSales(); //assign highestSales as the sales of the other one. If not, there is no change.
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

		for(int i=0; i<numOfAssociates; i++) { //for loop

			if(highestSales == team[i].getSales()) { //when the sales of ith object is highest one 
				System.out.println("Name: " + team[i].getName()); //print the name of the object
				System.out.println("Sales: $" + team[i].getSales()); //print the sales of the object
				System.out.println("$" + (team[i].getSales()- averageSales)+ " above the average."); //print the difference between the sales and the average.
				System.out.println(""); //print enter
			}
		}	

		System.out.println("The rest performed as follows: "); //print the line
		for(int i=0; i<numOfAssociates; i++) { //for loop

			if(highestSales != team[i].getSales()) { //this case is for the rest objects
				System.out.println("Name: " + team[i].getName()); //print the name of object
				System.out.println("Sales: $" + team[i].getSales()); //print the sales of object
				if(averageSales < team[i].getSales()) { //when average is smaller than the sales of the object
					System.out.println("$" + (team[i].getSales()- averageSales)+ " above the average. " ); //the average subtracted from the sales  
					System.out.println(""); //print enter
				}
				if(averageSales == team[i].getSales()) { //when average is same with the sales of the object
					System.out.println("Sales is same with the average." + "%n"); //print the line
					System.out.println(""); //print enter
				}
				if(averageSales > team[i].getSales()) { //hen average is bigger than the sales of the object
					System.out.println("$" + (averageSales - team[i].getSales())+ " below the average. "); //the sales subtracted from the average
					System.out.println(""); //print enter
				}

			}
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
