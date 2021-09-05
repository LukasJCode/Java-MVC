package Mediator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import Model.Employee;
import Model.EmployeeList;
import Model.Milestone;
import Model.MilestoneList;
import Model.Payment;
import Model.PaymentList;
import Model.Project;
import Model.ProjectList;
import utility.observer.AbstractRemoteSubject;
import utility.observer.RemoteObserver;

public class SystemServer extends AbstractRemoteSubject<String> implements RemoteSystem{
	private SysModel model;
	
	public SystemServer()throws RemoteException{
		this.model = new ModelManager();
		startRegistry();
		startServer();
		
	}
	
	

	private void startRegistry() {
		try {
			Registry reg = LocateRegistry.createRegistry(1099);
		} catch (java.rmi.server.ExportException ex) {
			System.out.println("Already started");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void startServer()
	{
		try {
			UnicastRemoteObject.exportObject(this,0);
			Naming.rebind("System", this);
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public EmployeeList getAllEmployees() {
		notifyObservers("Employees are listed");
		return model.getAllEmployees();
	}

	@Override
	public ProjectList getAllProjects() {
		notifyObservers("Projects are listed");
		return model.getAllProjects();
	}

	@Override
	public PaymentList getAllPayments() {
		notifyObservers("Payments are listed");
		return model.getAllPayments();
	}

	@Override
	public MilestoneList getAllMilestones() {
		notifyObservers("Milestones are listed");
		return model.getAllMilestones();
	}

	@Override
	public Employee getEmployeeById(int id) {
		notifyObservers("Employee by given ID is listed");
		return model.getEmployeeById(id);
	}

	@Override
	public Project getProjectById(int id) {
		notifyObservers("Project by given ID is listed");
		return model.getProjectById(id);
	}

	@Override
	public Payment getPaymentById(int id) {
		notifyObservers("Payment by given ID is listed");
		return model.getPaymentById(id);
	}

	@Override
	public Milestone getMilestoneById(int id) {
		notifyObservers("Milestone by given ID is listed");
		return model.getMilestoneById(id);
	}

	@Override
	public void removeEmployeeById(int id) {
		notifyObservers("Employee by given ID is removed");
		model.removeEmployeeById(id);
	}

	@Override
	public void removeProjectById(int id) {
		notifyObservers("Project by given ID is removed");
		model.removeProjectById(id);
	}

	@Override
	public void removePaymentById(int id) {
		notifyObservers("Payment by given ID is removed");
		model.removePaymentById(id);
	}

	@Override
	public void removeMilestoneById(int id) {
		notifyObservers("Milestone by given ID is removed");
		model.removeMilestoneById(id);
	}

	@Override
	public void addEmployee(Employee emp) {
		notifyObservers("Employee is added");
		model.addEmployee(emp);
	}

	@Override
	public void addProject(Project proj) {
		notifyObservers("Employee is added");
		model.addProject(proj);
	}

	@Override
	public void addPayment(Payment paym) {
		notifyObservers("Payment is added");
		model.addPayment(paym);
	}

	@Override
	public void addMilestone(Milestone mil) {
		notifyObservers("Milestone is added");
		model.addMilestone(mil);
	}



	@Override
	public void addObserver(RemoteObserver remoteObserver) throws RemoteException {
		// TODO Auto-generated method stub
		super.addObserver(remoteObserver);
		
	}

}