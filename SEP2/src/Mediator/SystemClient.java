package Mediator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Scanner;

import Model.Employee;
import Model.EmployeeList;
import Model.Milestone;
import Model.MilestoneList;
import Model.Payment;
import Model.PaymentList;
import Model.Project;
import Model.ProjectList;
import utility.observer.RemoteObserver;

public class SystemClient implements Remote, SysModel{
	private RemoteSystem system;
	private Scanner input;

	public SystemClient(String host) {
		input = new Scanner(System.in);

		try {
			system = (RemoteSystem) Naming.lookup("rmi://" + host + "/System");
			UnicastRemoteObject.exportObject(this, 0);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void start() {

	}

	@Override
	public EmployeeList getAllEmployees() {
		try {
			return system.getAllEmployees();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProjectList getAllProjects() {
		try {
			system.getAllProjects();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PaymentList getAllPayments() {
		try {
			system.getAllPayments();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MilestoneList getAllMilestones() {
		try {
			system.getAllMilestones();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {
		try {
			system.getEmployeeById(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Project getProjectById(int id) {
		try {
			system.getProjectById(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Payment getPaymentById(int id) {
		try {
			system.getAllPayments();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Milestone getMilestoneById(int id) {
		try {
			system.getAllMilestones();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void removeEmployeeById(int id) {
		try {
			system.removeEmployeeById(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeProjectById(int id) {
		try {
			system.removeProjectById(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void removePaymentById(int id) {
		try {
			system.removePaymentById(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeMilestoneById(int id) {
		try {
			system.removeMilestoneById(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addEmployee(Employee emp) {
		try {
			system.addEmployee(emp);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addProject(Project proj) {
		try {
			system.addProject(proj);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addPayment(Payment paym) {
		try {
			system.addPayment(paym);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addMilestone(Milestone mil) { 
		try {
			system.addMilestone(mil);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addObserver(RemoteObserver remoteObserver) {
		// TODO Auto-generated method stub
		try {
			this.system.addObserver(remoteObserver);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}