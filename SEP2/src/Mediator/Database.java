//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Mediator;

import Model.Date;
import Model.Employee;
import Model.EmployeeList;
import Model.Milestone;
import Model.MilestoneList;
import Model.Payment;
import Model.PaymentList;
import Model.Project;
import Model.ProjectList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utility.persistence.MyDatabase;

public class Database implements Persistence {
	private MyDatabase db;
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "lukaso";
	private static final Database INSTANCE = new Database() ;
	

	private Database() {
		try {
			this.db = new MyDatabase("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/postgres","postgres", "******");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Database getInstance() {
		
		return INSTANCE;
	}

	public Connection getConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "lukaso");
		} catch (SQLException var3) {
			var3.printStackTrace();
		}

		return con;
	}

	public synchronized void saveEmployee(Employee emp) {
	
		String sql = "insert into risetheorydb.employee values('" + emp.getEmployeeID() + "'," + "'"
				+ emp.getFirstName() + "'," + "'" + emp.getLastName() + "'," + "'" + emp.getAdress() + "'," + "'"
				+ emp.getCPRnumber() + "'," + "'" + emp.getEmail() + "'," + "'" + emp.getPhoneNr() + "'," + "'"
				+ emp.getDefoultTaxCard() + "'," + "'" + emp.getDOB() + "');";

		try {
			this.db.update(sql);
		} catch (SQLException var4) {
			var4.printStackTrace();
		}

	}
	
	public void removeEmployee() {
		String sql2 = "delete from risetheorydb.employee";
		try {
			this.db.update(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public synchronized void savePayment(Payment paym) {
		String sql = "insert into risetheorydb.payment values('" + paym.getPaymentID() + "'," + "'"
				+ paym.getGrossSalary() + "'," + "'" + paym.getHoursWorked() + "'," + "'" + paym.getNetSalary() + "',"
				+ "'" + paym.getHolidayPay() + "'," + "'" + paym.getCompanyGain() + "'," + "'" + paym.getProjectID()
				+ "'," + "'" + paym.getEmployeeID() + "');";

		try {
			this.db.update(sql);
		} catch (SQLException var4) {
			var4.printStackTrace();
		}

	}
	
	public void removePayment() {
		String sql2 = "delete from risetheorydb.payment";
		try {
			this.db.update(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void saveProject(Project proj) {
		String sql = "insert into risetheorydb.project values('" + proj.getProjectID() + "'," + "'" + proj.getName()
				+ "'," + "'" + proj.getIsCompleted() + "'," + "'" + proj.getIsSomeoneWorkingOn() + "'," + "'"
				+ proj.getCaseType() + "'," + "'" + proj.getDeadLine() + "'," + "'" + proj.getPaymentOfProject() + "',"
				+ "'" + proj.getNameOfContractor() + "'," + "'" + proj.getWebsite() + "'," + "'"
				+ proj.getWinningProposal() + "'," + "'" + proj.getStartDate() + "'," + "'" + proj.getEndDate() + "',"
				+ "'" + proj.getEmployeeID() + "');";

		try {
			this.db.update(sql);
		} catch (SQLException var4) {
			var4.printStackTrace();
		}

	}

	public void removeProject() {
		String sql2 = "delete from risetheorydb.project";
		try {
			this.db.update(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public synchronized void saveMilestone(Milestone mil) {
		String sql = "insert into risetheorydb.milestone values('" + mil.getMilestoneID() + "'," + "'"
				+ mil.getDescription() + "'," + "'" + mil.getPrice() + "'," + "'" + mil.getDeadline() + "'," + "'" + mil.getProjectID() +"'," + "'" + mil.getEmployeeID() + "');";

		try {
			this.db.update(sql);
		} catch (SQLException var4) {
			var4.printStackTrace();
		}

	}
	
	public void removeMilestone() {
		String sql2 = "delete from risetheorydb.milestone";
		try {
			this.db.update(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	public synchronized void saveEmployeeList(EmployeeList empList) {

			removeEmployee();
		for (int i = 0; i < empList.size(); i++) {
			
			this.saveEmployee(empList.getEmployee(i));
		}


	}

	public synchronized void savePaymentList(PaymentList paymList) {
		removePayment();
		for (int i = 0; i < paymList.getNumberOfPayments(); i++) {
			this.savePayment(paymList.getPayment(i));
		}

	}

	public synchronized void saveProjectList(ProjectList projList) {
		removeProject();
		for (int i = 0; i < projList.getNumberOfProject(); i++) {
			this.saveProject(projList.getProject(i));
		}

	}

	public synchronized void saveMilestoneList(MilestoneList milList) {
		removeMilestone();
		for (int i = 0; i < milList.getNumberOfMilestones(); i++) {
			this.saveMilestone(milList.getMilestone(i));
		}

	}

	public EmployeeList getAllEmployees() {

	
		EmployeeList all = new EmployeeList();
		Connection con = this.getConnection();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT EmployeeID, FirstName, LastName, Address, CPRnumber, Email, PhoneNumber, DefaultTaxCard, DOB  FROM risetheorydb.employee");

			while (rs.next()) {

				Employee emp = new Employee(rs.getString("FirstName"), rs.getString("LastName"),
						rs.getString("Address"), rs.getString("CPRnumber"), rs.getString("Email"),
						rs.getString("PhoneNumber"), rs.getString("DefaultTaxCard"), rs.getDate("DOB"));
				emp.setEmployeeID(rs.getInt("EmployeeID"));
				try {
					all.addEmployeeDB(emp);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException var7) {
			var7.printStackTrace();
		}

		return all;
	}

	public ProjectList getAllProjects() {
		ProjectList all = new ProjectList();
		Connection con = this.getConnection();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT ProjectID, name, IsCompleted, IsSomeoneWorkingOn, caseType, deadline, paymentOfProject, nameOfContractor, website, winningProposal, startDate, endDate, EmployeeID FROM risetheorydb.project");

			while (rs.next()) {

				EmployeeList employees = this.getAllEmployees();

				for (int i = 0; i < employees.size(); ++i) {
					if (((Employee) employees.getEmployee(i)).getEmployeeID().intValue() == rs.getInt("EmployeeID")) {
						Employee emp = new Employee(((Employee) employees.getEmployee(i)).getFirstName(),
								((Employee) employees.getEmployee(i)).getLastName(),
								((Employee) employees.getEmployee(i)).getAdress(),
								((Employee) employees.getEmployee(i)).getCPRnumber(),
								((Employee) employees.getEmployee(i)).getEmail(),
								((Employee) employees.getEmployee(i)).getPhoneNr(),
								((Employee) employees.getEmployee(i)).getDefoultTaxCard(),
								((Employee) employees.getEmployee(i)).getDOB());
						Project proj = new Project(rs.getString("name"), rs.getBoolean("IsCompleted"),
								rs.getBoolean("IsSomeoneWorkingOn"), rs.getInt("caseType"), rs.getDate("deadline"),
								rs.getInt("paymentOfProject"), rs.getString("nameOfContractor"),
								rs.getString("website"), rs.getString("winningProposal"), rs.getDate("startDate"),
								rs.getDate("endDate"), emp);
						proj.setProjectID(rs.getInt("ProjectID"));
						proj.setEmployeeID(rs.getInt("EmployeeID"));
						try {
							all.addProjectDB(proj);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		} catch (SQLException var12) {
			var12.printStackTrace();
		}

		return all;
	}

	public PaymentList getAllPayments() {
		PaymentList all = new PaymentList();
		Connection con = this.getConnection();

		
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT PaymentID, GrossSalary, HoursWorked, NetSalary, HolidayPay, CompanyGain, ProjectID, EmployeeID  FROM risetheorydb.payment");

			while (rs.next()) {

				EmployeeList employees = this.getAllEmployees();
				ProjectList projects = this.getAllProjects();

				for (int i = 0; i < employees.size(); ++i) {
					for (int j = 0; j < projects.size(); ++j) {
						if (((Employee) employees.getEmployee(i)).getEmployeeID().intValue() == rs.getInt("EmployeeID")
								&& ((Project) projects.getProject(j)).getProjectID() == rs.getInt("ProjectID")) {
							Employee emp = new Employee(((Employee) employees.getEmployee(i)).getFirstName(),
									((Employee) employees.getEmployee(i)).getLastName(),
									((Employee) employees.getEmployee(i)).getAdress(),
									((Employee) employees.getEmployee(i)).getCPRnumber(),
									((Employee) employees.getEmployee(i)).getEmail(),
									((Employee) employees.getEmployee(i)).getPhoneNr(),
									((Employee) employees.getEmployee(i)).getDefoultTaxCard(),
									((Employee) employees.getEmployee(i)).getDOB());
							Project proj = new Project(((Project) projects.getProject(j)).getName(),
									((Project) projects.getProject(j)).getIsCompleted(),
									((Project) projects.getProject(j)).getIsSomeoneWorkingOn(),
									((Project) projects.getProject(j)).getCaseType(),
									((Project) projects.getProject(j)).getDeadLine(),
									((Project) projects.getProject(j)).getPaymentOfProject(),
									((Project) projects.getProject(j)).getNameOfContractor(),
									((Project) projects.getProject(j)).getWebsite(),
									((Project) projects.getProject(j)).getWinningProposal(),
									((Project) projects.getProject(j)).getStartDate(),
									((Project) projects.getProject(j)).getEndDate(), emp);
							Payment paym = new Payment(rs.getInt("GrossSalary"), rs.getInt("HoursWorked"),
									rs.getInt("NetSalary"), rs.getInt("HolidayPay"), rs.getInt("CompanyGain"), proj,
									emp);
							paym.setPaymentID(rs.getInt("PaymentID"));
							paym.setEmployeeID(rs.getInt("EmployeeID"));
							paym.setProjectID(rs.getInt("ProjectID"));
							try {
								all.addPaymentDB(paym);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}

			}
		} catch (SQLException var15) {
			var15.printStackTrace();
		}


		return all;
		

	}

	public MilestoneList getAllMilestones() {
		MilestoneList all = new MilestoneList();
		Connection con = this.getConnection();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT MilestoneID, Description , Price , MilestoneDeadline, ProjectID, EmployeeID FROM risetheorydb.milestone");

			while (rs.next()) {

				EmployeeList employees = this.getAllEmployees();
				ProjectList projects = this.getAllProjects();

				for (int i = 0; i < employees.size(); ++i) {
					for (int j = 0; j < projects.size(); ++j) {
						if (((Employee) employees.getEmployee(i)).getEmployeeID().intValue() == rs.getInt("EmployeeID")
								&& ((Project) projects.getProject(j)).getProjectID() == rs.getInt("ProjectID")) {
							Employee emp = new Employee(((Employee) employees.getEmployee(i)).getFirstName(),
									((Employee) employees.getEmployee(i)).getLastName(),
									((Employee) employees.getEmployee(i)).getAdress(),
									((Employee) employees.getEmployee(i)).getCPRnumber(),
									((Employee) employees.getEmployee(i)).getEmail(),
									((Employee) employees.getEmployee(i)).getPhoneNr(),
									((Employee) employees.getEmployee(i)).getDefoultTaxCard(),
									((Employee) employees.getEmployee(i)).getDOB());
							Project proj = new Project(((Project) projects.getProject(j)).getName(),
									((Project) projects.getProject(j)).getIsCompleted(),
									((Project) projects.getProject(j)).getIsSomeoneWorkingOn(),
									((Project) projects.getProject(j)).getCaseType(),
									((Project) projects.getProject(j)).getDeadLine(),
									((Project) projects.getProject(j)).getPaymentOfProject(),
									((Project) projects.getProject(j)).getNameOfContractor(),
									((Project) projects.getProject(j)).getWebsite(),
									((Project) projects.getProject(j)).getWinningProposal(),
									((Project) projects.getProject(j)).getStartDate(),
									((Project) projects.getProject(j)).getEndDate(), emp);
							Milestone mil = new Milestone(rs.getString("Description"), rs.getInt("Price"),
									rs.getDate("deadline"), proj, emp);
							mil.setMilestoneID(rs.getInt("MilestonID"));
							try {
								all.addMilestone(mil);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}

			}
		} catch (SQLException var7) {
			var7.printStackTrace();
		}

		return all;
	}
	
	public void setEmployeeInProjectToNull(int id)
	{
		String sql2 = "update risetheorydb.project set EmployeeID = NULL where ProjectID = " + id;
		try {
			this.db.update(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void setEmployeeInPaymentToNull(int id)
	{
		String sql2 = "update risetheorydb.payment set EmployeeID = NULL where PaymentID = " + id;
		try {
			this.db.update(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	



	
	public void setProjectInPaymentToNull(int id)
	{
		String sql2 = "update risetheorydb.payment set ProjectID = NULL where PaymentID = " + id;
		try {
			this.db.update(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setEmployeeInMilestoneToNull(int id)
	{
		String sql2 = "update risetheorydb.milestone set EmployeeID = NULL where MilestoneID = " + id;
		try {
			this.db.update(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setProjectInMilestoneToNull(int id)
	{
		String sql2 = "update risetheorydb.milestone set ProjectID = NULL where MilestoneID = " + id;
		try {
			this.db.update(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
