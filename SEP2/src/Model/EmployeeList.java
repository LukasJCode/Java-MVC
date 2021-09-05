package Model;

import java.util.ArrayList;

import Mediator.ModelManager;

public class EmployeeList {
	private ArrayList<Employee> list;


	public EmployeeList() {
		this.list = new ArrayList<>();
	}

	public void setEmployeeList(ArrayList<Employee> list) {
		this.list = list;
	}

	public void addEmployee(Employee emp) throws Exception {
		loop: while (true) {
			int ID = (int) ((Math.random() * 1000)) + 1;
			int counter = 0;

			for (int i = 0; i < list.size(); i++) {
				if (ID == (int) list.get(i).getEmployeeID())
					counter++;
			}

			if (counter == 0) {
				
				emp.setEmployeeID(ID);

				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getCPRnumber().equals(emp.getCPRnumber())) {
						throw new Exception("Employee is already in");
					}
				}
				if (emp.getEmployeeID() == null || emp.getFirstName().equals("") || emp.getLastName().equals("")
						|| emp.getCPRnumber().equals("") || emp.getEmail().equals("")) {
					throw new Exception("Employee can't be added");
				} else 
					
					list.add(emp);
				
				break loop;
			}

		}
			}
	public void addEmployeeDB(Employee emp)
	{
		list.add(emp);
	}

		

	

	public int getNumberOfEmployees() {
		return list.size();
	}

	public Employee getEmployee(int index) {
		return list.get(index);
	}

	public int size() {
		return list.size();
	}

	public Employee getEmployeeByID(int ID) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEmployeeID() == ID) {
				return list.get(i);
			}
		}
		return null;
	}
	
	public void removeEmployeeByID(int ID) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEmployeeID() == ID) {
				list.remove(i);
			}
		}
	}
	
	public String toString() {
		String all="";
		for (int i = 0; i < list.size(); i++) {
			all+= i +1 + ". " + list.get(i) + "\n";
		}
		return all;
	}

}

