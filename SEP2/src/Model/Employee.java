//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Model;

public class Employee {
    private Integer employeeID = 0;
    private String firstName;
    private String lastName;
    private String adress;
    private String CPRnumber;
    private String Email;
    private String phoneNr;
    private String DefaultTaxCard;
    private java.sql.Date DOB;

    public Employee(String firstName, String lastName, String adress, String CPRnumber, String Email, String phoneNR, String DefoultTaxCard, java.sql.Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.CPRnumber = CPRnumber;
        this.Email = Email;
        this.phoneNr = phoneNR;
        this.DefaultTaxCard = DefoultTaxCard;
        this.DOB = dob;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLasttName(String name) {
        this.lastName = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCPRnumber(String CPRnumber) {
        this.CPRnumber = CPRnumber;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public void setDefoultTaxCard(String DefoultTaxCard) {
        this.DefaultTaxCard = DefoultTaxCard;
    }

    public void setDOB(java.sql.Date dob) {
        this.DOB = dob;
    }

    public Integer getEmployeeID() {
        return this.employeeID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAdress() {
        return this.adress;
    }

    public String getCPRnumber() {
        return this.CPRnumber;
    }

    public String getEmail() {
        return this.Email;
    }

    public String getPhoneNr() {
        return this.phoneNr;
    }

    public String getDefoultTaxCard() {
        return this.DefaultTaxCard;
    }

    public java.sql.Date getDOB() {
        return this.DOB;
    }

    public String toString() {
        String all = this.employeeID + " " + this.firstName + " " + this.lastName + " " + this.adress + " " + this.CPRnumber + " " + this.Email + " " + this.phoneNr + " " + this.DefaultTaxCard + " " + this.DOB;
        return all;
    }
}
