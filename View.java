
/**
* <View.java>
* <Kaylynn Diaz-Schott / Section A Thursday/2:30 >
*
* <This class is the IO class and takes in and displays all the data making sure that all the data is valid>
*/

import java.util.HashMap;
import java.util.Scanner;

//Handles all the I/O within the project
public class View {
	private Scanner s = new Scanner(System.in);
	private String input;
	
	/**
	* (Takes in the employees ID number)
	*
	* @param (boolean showHeader - is true or false depending on whether a print statement needs to be ther or not)
	* @return (int idNum - returns the id number of the employee)
	*/
	public int inputIdNumber(boolean showHeader) {
		int idNum = 0;
		
		if (showHeader == true) {
			System.out.println("\nPlease enter an EXISTING employee ID");
		}
		
		while (true) {
			try {
				System.out.print("Please enter employee number ID Number: ");
				input = s.nextLine();
				idNum = Integer.parseInt(input);
				
				break;
			} catch (NumberFormatException nfe) {
			System.out.print("\tERROR " + nfe.getMessage());
			System.out.println(". Please input a whole number instead...");
			}
		}//end of while loop
	return idNum;	
	}//end of idNumber method
	
	/**
	* (Gets the users input of how much they are paid per hour)
	*
	* @param (int i - takes in the index number so it can let the user know which employee they enter the data for)
	* @return (double payRate - the amount they are paid per hour)
	*/
	public double inputPayRate (int i) {
		double payRate = 0;
		System.out.println("");
		
		if (i == 0) {
			System.out.println("Enter additional information for each employee..");
		}
		while (true) {
			try {
				System.out.print("Please enter employee number " + (i+1) + "'s pay rate: ");
				input = s.nextLine();
				payRate = Double.parseDouble(input);
				
				break;
			} catch (NumberFormatException nfe) {
			System.out.print("\tERROR " + nfe.getMessage() +". Please enter a decimal or whole number...\n");
			}
		}//end of while loop
		return payRate;	
	}//end of inputpayRate method
	
	/**
	* (Takes in how many hours the employee works per week)
	*
	* @param (int i = takes in the index number to let the user know which employee they are entering information for)
	* @return (double hoursWorked - returns the amount of hours worked per week)
	*/
	public double inputHoursWorked (int i) {
		double hoursWorked = 0;
		
		while (true) {
			try {
				System.out.print("Please enter the amount of hours employee " + (i + 1) + " works: ");
				input = s.nextLine();
				hoursWorked = Double.parseDouble(input);
				break;
			} catch (NumberFormatException nfe) {
				System.out.print("\tERROR " + nfe.getMessage() +". Please enter a decimal or whole number...\n");
			}
			System.out.println("");
		}//end of while loop
		return hoursWorked;	
	}//end of inputpayRate method
	
	/**
	* (Takes in the users name )
	*
	* @param (boolean showHeader - gives the user more information depending on what the user is supposed to input)
	* @return (String name - returns the name as a String)
	*/
	public String inputName (boolean showHeader) {
		String name  = " ";
		
		if (showHeader == true) {
			System.out.println("\nPlease add another employee...");
		}
		
		while (true) {
			try {
				System.out.print("Please enter the employee's name: ");
				name = s.nextLine();
			
				if (name == null || name.isEmpty()) {
					throw new RuntimeException(); 
				} else {
					break;
				}
			}catch (RuntimeException e) {
				System.out.println("\tERROR " + e.getMessage() + ". You must enter a name..."); 
			
			}
		}
	
		return name;
	}//end of inputName method
	
	
	/**
	* (Asks the user if they would like to add another employee)
	*
	* @return (String reply - returns the user input as a String)
	*/
	public String reply () {
		System.out.println("\nWould you like to enter another employee?");
		System.out.print("\tEnter (Y)es or (N)o: ");
		String reply = s.nextLine();
		
		System.out.println("");
		
		return reply;
	}
	
	/**
	* (Prints out a header for the beginning of the program)
	*/
	public void header() {
		System.out.println("PLEASE ENTER THE FOLLOWING EMPLOYEE INFORMATION");
		System.out.println("***********************************************");
		
	}
	
	
	/**
	* (Prints out that the employee is deleted)
	*/
	public void deleteEmployee (){
		System.out.println("\tEmployee was deleted.");
	}
	
	
	/**
	* (Prints out statement if the employee is not found in the ArrayList)
	*/
	public void employeeNotFound() {
		System.out.println("\tEmployee was not found");
	}
	
	
	/**
	* (Prints out the results using the toString() method in the Payroll class)
	*
	* @param (int loopNum - keeps track of the number of loops so that the header is not printed every single time)
	* @param (Payroll msg - the payroll object that is printed using the toString() method)
	*/
	public void displayResults(int loopNum, Payroll msg) {
		if (loopNum == 0) {
			System.out.println("\nEMPLOYEES RESULTS");
			System.out.println("*****************");
		}
		System.out.println(msg + "\n");
	}
	
	
	
}
