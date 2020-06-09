package structural_patterns.adapter_design_pattern;

import java.util.ArrayList;
import java.util.List;

class Employee {
	private int empId;
	private String name;
	private String designation;

	public Employee(int empId, String name, String designation) {
		this.empId = empId;
		this.name = name;
		this.designation = designation;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}



// Third party class : adaptee
class ThirdPartyBillingSystem {

	public void processSalary(List<Employee> employees) {
		employees.forEach((employee) -> {
			System.out.println(" Employee == " + employee);
			if (employee.getDesignation().equalsIgnoreCase("team lead")) {
				System.out.println("70000 ammount has credited to "
						+ employee.getName());
			}
			if (employee.getDesignation().equalsIgnoreCase("Developer")) {
				System.out.println("RS 40000 ammount has credited to "
						+ employee.getName());
			}
			if (employee.getDesignation().equalsIgnoreCase("Tester")) {
				System.out.println("RS 30000 ammount has credited to "
						+ employee.getName());
			}
		});

	}
}

/**
 * 
 * client system which having employee information on the form of arrays
 */
class HumanResourceSystem{
	public static String[][] getEmployess(){
		String [][] employees = new String[4][];
		employees[0] = new String[]{"100","DEV", "Team lead"};
		employees[1] = new String[]{"101","RAM", "developer"};
		employees[2] = new String[]{"102","Sagar", "developer"};
		employees[3] = new String[]{"103","Shyam", "tester"};
		return employees;	
	}
}

interface Target{
	public void processCompanySalary(String [][] employees);
}

/**
 * 
 * Adapter class
 *
 */
class EmployeeAdapter implements Target{

	private ThirdPartyBillingSystem thirdPartyBillingSystem = new ThirdPartyBillingSystem();

	@Override
	public void processCompanySalary(String[][] employees) {
			
		List<Employee>  employeeList = new ArrayList<Employee>();
		
		for(int i =0; i< employees.length ;i++){
			Employee employee = new Employee( Integer.parseInt(employees[i][0]), employees[i][1], employees[i][2]);
			employeeList.add(employee);
		}
		thirdPartyBillingSystem.processSalary(employeeList);
	}
	
}


public class AdapterDesignPatternDemo {
	public static void main(String[] args) {
		EmployeeAdapter employeeAdapter = new EmployeeAdapter();
		String [][] employees = HumanResourceSystem.getEmployess(); 
		employeeAdapter.processCompanySalary(employees);
		
	}
}
