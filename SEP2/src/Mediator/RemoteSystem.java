package Mediator;
import java.rmi.Remote;
import java.rmi.RemoteException;

import Model.Employee;
import Model.EmployeeList;
import Model.Milestone;
import Model.MilestoneList;
import Model.Payment;
import Model.PaymentList;
import Model.Project;
import Model.ProjectList;
import utility.observer.RemoteObserver;

public interface RemoteSystem extends Remote{
	public EmployeeList getAllEmployees() throws RemoteException;
	public ProjectList getAllProjects()throws RemoteException;
	public PaymentList getAllPayments()throws RemoteException;
	public MilestoneList getAllMilestones()throws RemoteException;

	public Employee getEmployeeById(int id)throws RemoteException;
	public Project getProjectById(int id)throws RemoteException;
	public Payment getPaymentById(int id)throws RemoteException;
	public Milestone getMilestoneById(int id)throws RemoteException;

	public void removeEmployeeById(int id)throws RemoteException;
	public void removeProjectById(int id)throws RemoteException;
	public void removePaymentById(int id)throws RemoteException;
	public void removeMilestoneById(int id)throws RemoteException;

	public void addEmployee(Employee emp)throws RemoteException;
	public void addProject(Project proj)throws RemoteException;
	public void addPayment(Payment paym)throws RemoteException;
	public void addMilestone(Milestone mil)throws RemoteException;
	
	public void addObserver(RemoteObserver remoteObserver) throws RemoteException;
}