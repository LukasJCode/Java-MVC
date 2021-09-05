package Mediator;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Model.Employee;
import Model.EmployeeList;
import Model.Milestone;
import Model.MilestoneList;
import Model.Payment;
import Model.PaymentList;
import Model.Project;
import Model.ProjectList;
import utility.observer.RemoteObserver;

public interface SysModel extends Serializable{

public EmployeeList getAllEmployees();
public ProjectList getAllProjects();
public PaymentList getAllPayments();
public MilestoneList getAllMilestones();

public Employee getEmployeeById(int id);
public Project getProjectById(int id);
public Payment getPaymentById(int id);
public Milestone getMilestoneById(int id);

public void removeEmployeeById(int id);
public void removeProjectById(int id);
public void removePaymentById(int id);
public void removeMilestoneById(int id);

public void addEmployee(Employee emp);
public void addProject(Project proj);
public void addPayment(Payment paym);
public void addMilestone(Milestone mil);

public void addObserver(RemoteObserver remoteObserver);

}
