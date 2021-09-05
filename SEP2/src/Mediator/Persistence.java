package Mediator;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;

import Model.Employee;
import Model.EmployeeList;
import Model.Milestone;
import Model.MilestoneList;
import Model.Payment;
import Model.PaymentList;
import Model.Project;
import Model.ProjectList;

public interface Persistence extends Serializable {
	public void saveEmployee(Employee emp);
	public void savePayment(Payment paym);
	public void saveProject(Project proj);
	public void saveMilestone(Milestone mil);
	
	public  void saveEmployeeList(EmployeeList empList);
	public  void savePaymentList(PaymentList paymList);
	public  void saveProjectList(ProjectList projList);
	public  void saveMilestoneList(MilestoneList milList);
	
	public EmployeeList getAllEmployees();
	public ProjectList getAllProjects();
	public PaymentList getAllPayments();
	public MilestoneList getAllMilestones();
	
	public void setEmployeeInProjectToNull(int id);
	public void setEmployeeInPaymentToNull(int id);
	public void setProjectInPaymentToNull(int id);
	public void setEmployeeInMilestoneToNull(int id);
	public void setProjectInMilestoneToNull(int id);
}
