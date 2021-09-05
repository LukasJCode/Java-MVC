//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Model;

public class Milestone {
    private int milestoneID = 0;
    private String description;
    private Integer price;
    private java.sql.Date deadline;
    private Employee employee;
    private Project project;

    public Milestone(String description, Integer price, java.sql.Date deadline, Project project, Employee employee) {
        this.description = description;
        this.price = price;
        this.deadline = deadline;
        this.project = project;
        this.employee = employee;
    }
    

    public void setMilestoneID(int milestoneID) {
        this.milestoneID = milestoneID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setDeadline(java.sql.Date deadline) {
        this.deadline = deadline;
    }

    public int getMilestoneID() {
        return this.milestoneID;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getPrice() {
        return this.price;
    }

    public java.sql.Date getDeadline() {
        return this.deadline;
    }
    
    public Integer getProjectID() {
        return this.project.getProjectID();
    }
    
    public Project getProject() {
    	return this.project;
    }
    
    public void setProject(Project project) {
    	this.project = project;
    }

    public int getEmployeeID() {
        return this.employee.getEmployeeID().intValue();
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

	
    public String toString() {
        String all = this.milestoneID + " " + this.description + " " + this.price + " " + this.deadline  + " "+ this.project.getProjectID() + " " + this.employee.getEmployeeID();
        return all;
    }
}
