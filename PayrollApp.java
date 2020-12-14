
/**
* <PayrollApp.java>
* <Kaylynn Diaz-Schott / Section A Thursday/2:30 >
*
* <This class is the controller class and is the main application class which goes between the model and the view class>
*/


import java.util.*;

public class PayrollApp {
	/**
	* (Drives the payroll application by calling methods from both the Payroll class and the view class)
	*
	* @param (String[] args - String arguements)
	*/
    public static void main(String[] args) {
    	
    	//Declare variables
    String reply = " ";
    	String name = " ";
    	int id = 0;
    	double payRate = 0;
    	double hoursWorked = 0;
    	boolean showHeader = false;
    	
    	//Declare ArrayList
    	ArrayList<Payroll> employeeList = new ArrayList<Payroll>();
    	//Declare View Object
    	View view = new View();
    	Payroll employee = new Payroll(name, id);
    	
    	//Declare while loop to add employees to the arrayList
    	view.header();
	do {
    		name = view.inputName(showHeader);
    		id = view.inputIdNumber(showHeader);
    		
    		employee = new Payroll (name, id);
    		employeeList.add(employee);
    		reply = view.reply();
    		
    	} while (reply .equalsIgnoreCase("y"));
	
	//Add different things to the ArrayList 
	for (int i = 0; i < employeeList.size(); i++) {
		payRate = view.inputPayRate(i);
		employeeList.get(i).setPayRate(payRate);
		hoursWorked = view.inputHoursWorked(i);
		employeeList.get(i).setHoursWorked(hoursWorked);
		
	}

	//Declare an iterator
	int loopNum  = 0;
	Iterator<Payroll> it = employeeList.iterator();
	while (it.hasNext()) {
		employee = it.next();
		view.displayResults(loopNum, employee); //Print out all the employees 
		
		loopNum += 1;
	
	}
	
	HashMap <Integer, Payroll> map = new HashMap<>();
	for (int i = 0; i < employeeList.size(); i++) {
		showHeader = true;
		map.put(employeeList.get(i).getIdNumber(), employeeList.get(i));
		
	}
		
		id  = view.inputIdNumber(showHeader);
		Payroll payrollMap = map.get(id);
			
		while (payrollMap == null){
			view.employeeNotFound();
			id  = view.inputIdNumber(showHeader);
			payrollMap = map.get(id);
		}
	employeeList.remove(map.get(id));
	view.deleteEmployee();
	name = view.inputName(showHeader);
	showHeader = false;
	id = view.inputIdNumber(showHeader);
	
	Payroll addEmployee = new Payroll(name, id);
	employeeList.add(employeeList.size()-1, addEmployee);
	
	int i = 0;
	payRate = view.inputPayRate(i);
	employeeList.get(employeeList.size()-1).setPayRate(payRate);
	hoursWorked = view.inputHoursWorked(i);
	employeeList.get(employeeList.size()-1).setHoursWorked(hoursWorked);
	
	loopNum = 0;
	Iterator <Payroll> it2 = employeeList.iterator();
	while (it2.hasNext()) {
		employee = it2.next();
		view.displayResults(loopNum, employee);
		
		loopNum += 1;
	}
	
    }
}