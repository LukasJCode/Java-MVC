package Mediator;

import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Mediator.Database;
import Model.Date;
import Model.Employee;
import Model.EmployeeList;
import Model.Milestone;
import Model.MilestoneList;
import Model.Payment;
import Model.PaymentList;
import Model.Project;
import Model.ProjectList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import utility.observer.RemoteObserver;
import utility.persistence.MyDatabase;

public class ModelManager implements SysModel, Serializable{
	private EmployeeList empList;
	private ProjectList projList;
	private PaymentList paymList;
	private MilestoneList milList;
	private Persistence database;

	public ModelManager() {
		this.database = Database.getInstance();
		empList = new EmployeeList();

		empList = database.getAllEmployees();
		projList = new ProjectList();
		projList = database.getAllProjects();
		paymList = new PaymentList();
		paymList = database.getAllPayments();
		milList = new MilestoneList();
		milList = database.getAllMilestones();
	}

	public void setAllEmployees() {
		empList = database.getAllEmployees();
	}

	// ------------------------------------------------------------------------------------
	// GET ALL
	@Override
	public EmployeeList getAllEmployees() {
		return empList;
	}

	// ------------------------------------------------------------------------------------
	@Override
	public ProjectList getAllProjects() {
		return projList;
	}

	// ------------------------------------------------------------------------------------
	@Override
	public PaymentList getAllPayments() {
		return paymList;
	}

	// ------------------------------------------------------------------------------------
	@Override
	public MilestoneList getAllMilestones() {
		return milList;
	}

	// getStuffByID------------------------------------------------------------------------------------------
	@Override
	public Employee getEmployeeById(int id) {
		return empList.getEmployeeByID(id);
	}

	// ------------------------------------------------------------------------------------
	@Override
	public Project getProjectById(int id) {
		return projList.getProjectByID(id);
	}

	// ------------------------------------------------------------------------------------
	@Override
	public Payment getPaymentById(int id) {
		return paymList.getPaymentByID(id);
	}

	// ------------------------------------------------------------------------------------
	@Override
	public Milestone getMilestoneById(int id) {
		return milList.getMilestoneByID(id);
	}

	// RemoveStuffAfByID------------------------------------------------------------------------------------------
	@Override
	public void removeEmployeeById(int id) {
		for (int i = 0; i < projList.size(); i++) {
			if (projList.getProject(i).getEmployee().getEmployeeID() == id) {
				projList.getProject(i).setEmployee(null);
				database.setEmployeeInProjectToNull(projList.getProject(i).getProjectID());

			}

		}
		for (int i = 0; i < paymList.size(); i++) {
			if (paymList.getPayment(i).getEmployee().getEmployeeID() == id) {
				paymList.getPayment(i).setEmployee(null);
				database.setEmployeeInPaymentToNull(paymList.getPayment(i).getPaymentID());

			}
		}

		for (int i = 0; i < milList.size(); i++) {
			if (milList.getMilestone(i).getEmployee().getEmployeeID() == id) {
				milList.getMilestone(i).setEmployee(null);
				database.setEmployeeInMilestoneToNull(milList.getMilestone(i).getMilestoneID());

			}

		}
		empList.removeEmployeeByID(id);
		try {

			database.saveEmployeeList(empList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------------------------
	@Override
	public void removeProjectById(int id) {
		for (int i = 0; i < paymList.size(); i++) {
			if (paymList.getPayment(i).getProject().getProjectID() == id) {
				paymList.getPayment(i).setProject(null);
				database.setProjectInPaymentToNull(paymList.getPayment(i).getPaymentID());

			}
			
		}
		
		for (int i = 0; i < milList.size(); i++) {
			if (milList.getMilestone(i).getProject().getProjectID() == id) {
				milList.getMilestone(i).setProject(null);
				database.setProjectInMilestoneToNull(milList.getMilestone(i).getMilestoneID());

			}

		}

		projList.removeProjectByID(id);
		try {
			database.saveProjectList(projList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------------------------
	@Override
	public void removePaymentById(int id) {
	
		paymList.removePaymentByID(id);
		try {
			database.savePaymentList(paymList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------------------------
	@Override
	public void removeMilestoneById(int id) {
		milList.removeMilestoneByID(id);
		try {
			database.saveMilestoneList(milList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Adding
	// ------------------------------------------------------------------------

	@Override
	public void addEmployee(Employee emp) {
		try {
			empList.addEmployee(emp);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			database.saveEmployeeList(empList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// -------------------------------------------------------

	@Override
	public void addProject(Project proj) {
		try {
			projList.addProjet(proj);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			database.saveProjectList(projList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// -------------------------------------------------------

	@Override
	public void addPayment(Payment paym) {
		try {
			paymList.addPayment(paym);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			database.savePaymentList(paymList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// -------------------------------------------------------

	@Override
	public void addMilestone(Milestone mil) {
		try {
			milList.addMilestone(mil);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			database.saveMilestoneList(milList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addObserver(RemoteObserver remoteObserver) {
		// TODO Auto-generated method stub
		
		throw new NotImplementedException();
	}

}
