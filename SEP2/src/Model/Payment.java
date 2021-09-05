//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Model;

public class Payment {
    private int PaymentID = 0;
    private Project project;
    private Employee employee;
    private Integer GrossSalary;
    private int HoursWorked;
    private int NetSalary;
    private int HolidayPay;
    private int CompanyGain;

    public Payment(Integer GrossSalary, int HoursWorked, int NetSalary, int HolidayPay, int CompanyGain, Project project, Employee employee) {
        this.GrossSalary = GrossSalary;
        this.HoursWorked = HoursWorked;
        this.NetSalary = NetSalary;
        this.HolidayPay = HolidayPay;
        this.CompanyGain = CompanyGain;
        this.project = project;
        this.employee = employee;
    }

    public void setPaymentID(int PaymentID) {
        this.PaymentID = PaymentID;
    }

    public void setGrossSalary(Integer GrossSalary) {
        this.GrossSalary = GrossSalary;
    }

    public void setHoursWorked(int HoursWorked) {
        this.HoursWorked = HoursWorked;
    }

    public void setNetSalary(int NetSalary) {
        this.NetSalary = NetSalary;
    }

    public void setHolidayPay(int HolidayPay) {
        this.HolidayPay = HolidayPay;
    }

    public void setCompanyGain(int CopmanyGain) {
        this.CompanyGain = this.CompanyGain;
    }

    public int getPaymentID() {
        return this.PaymentID;
    }

    public int getProjectID() {
        return this.project.getProjectID();
    }

    public int getEmployeeID() {
        return this.employee.getEmployeeID();
    }
    
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public void setEmployeeID(int ID) {
        this.employee.setEmployeeID(ID);
    }

    public void setProjectID(int ID) {
        this.project.setProjectID(ID);
    }

    
    public Project getProject() {
    	return this.project;
    }
    
    public void setProject(Project project) {
    	this.project = project;
    }


    public Integer getGrossSalary() {
        return this.GrossSalary;
    }

    public int getHoursWorked() {
        return this.HoursWorked;
    }

    public int getNetSalary() {
        return this.NetSalary;
    }

    public int getHolidayPay() {
        return this.HolidayPay;
    }

    public int getCompanyGain() {
        return this.CompanyGain;
    }

    public String toString() {
        String all = this.PaymentID + " " + this.GrossSalary + " " + this.HoursWorked + " " + this.NetSalary + " " + this.HolidayPay + " " + this.CompanyGain + " " + this.project.getProjectID() + " " + this.employee.getEmployeeID();
        return all;
    }
}
