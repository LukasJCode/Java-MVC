//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Model;

public class Project {
    private Employee employee;
    private Integer projectID = 0;
    private String name;
    private boolean isCompleted;
    private boolean isSomeoneWorkingOn;
    private int caseType;
    private java.sql.Date deadline;
    private int paymentOfProject;
    private String nameOfContractor;
    private String website;
    private String winningProposal;
    private java.sql.Date startDate;
    private java.sql.Date endDate;

    public Project(String name, boolean isCompleted, boolean isSomeoneWorkingOn, int caseType, java.sql.Date deadline, int paymentOfProject, String nameOfContractor, String website, String winningProposal, java.sql.Date startDate, java.sql.Date endDate, Employee employee) {
        this.name = name;
        this.isCompleted = isCompleted;
        this.isSomeoneWorkingOn = isSomeoneWorkingOn;
        this.caseType = caseType;
        this.deadline = deadline;
        this.paymentOfProject = paymentOfProject;
        this.nameOfContractor = nameOfContractor;
        this.website = website;
        this.winningProposal = winningProposal;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
    }

    public int getProjectID() {
        return this.projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public boolean getIsSomeoneWorkingOn() {
        return this.isSomeoneWorkingOn;
    }

    public void setIsSomeoneWorkingOn(boolean isSomeoneWorkingOn) {
        this.isSomeoneWorkingOn = isSomeoneWorkingOn;
    }

    public int getCaseType() {
        return this.caseType;
    }

    public void setCaseType(int caseType) {
        this.caseType = caseType;
    }

    public java.sql.Date getDeadLine() {
        return this.deadline;
    }

    public void setDeadLine(java.sql.Date deadline) {
        this.deadline = deadline;
    }

    public int getPaymentOfProject() {
        return this.paymentOfProject;
    }

    public void setPaymentOfProject(int paymentOfProject) {
        this.paymentOfProject = paymentOfProject;
    }

    public String getNameOfContractor() {
        return this.nameOfContractor;
    }

    public void setNameOfContractor(String nameOfContractor) {
        this.nameOfContractor = nameOfContractor;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setSite(String website) {
        this.website = website;
    }

    public String getWinningProposal() {
        return this.winningProposal;
    }

    public void setWinningProposal(String winningProposal) {
        this.winningProposal = winningProposal;
    }

    public java.sql.Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate;
    }

    public java.sql.Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(java.sql.Date endDate) {
        this.endDate = endDate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public Integer getEmployeeID() {
    	if(employee.equals(null))
    		return 0;
    	else return this.employee.getEmployeeID();
    }

    public void setEmployeeID(int ID) {
        this.employee.setEmployeeID(ID);
    }

    public String toString() {
    	String all = "";
        if (employee.equals(null))
        	 all = this.projectID + " " + this.name + " " + this.isCompleted + " " + this.isSomeoneWorkingOn + " " + this.caseType + " " + this.deadline + " " + this.paymentOfProject + " " + this.nameOfContractor + " " + this.website + " " + this.winningProposal + " " + this.startDate + " " + this.endDate + " " + "0";
        else  
        	all = this.projectID + " " + this.name + " " + this.isCompleted + " " + this.isSomeoneWorkingOn + " " + this.caseType + " " + this.deadline + " " + this.paymentOfProject + " " + this.nameOfContractor + " " + this.website + " " + this.winningProposal + " " + this.startDate + " " + this.endDate + " " + this.employee.getEmployeeID();
    	
    	return all;
    }
}
