package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Employee Class holds all information for individual Employees
 * @author Susan Hundt
 */
//TODO Add hibernate annotations to allow mapping from your table to the entity
@Entity
@Table(name="Employee")
public class Employee {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private String phoneExtension;
    private String cellPhone;
    private String emailAddress;

    /**
     * Empty Constructor
     */
    public Employee() {

    }

    /**
     *  Overloaded  Constructor for class - Takes data passed
     *  and sets instance variables to create new employee
     */
    public Employee (String newFirstName, String newLastName, String newDepartment,
                     String newCellPhone, String newPhoneExtension, String newEmailAddress) {

        super();
        firstName = newFirstName;
        lastName = newLastName;
        department = newDepartment;
        phoneExtension = newPhoneExtension;
        cellPhone = newCellPhone;
        emailAddress = newEmailAddress;

    }


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setPhoneExtension(String phoneExtension) {
        this.phoneExtension = phoneExtension;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhoneExtension() {
        return phoneExtension;
    }

    public void setPhoneExt(String phoneExtension) {
        this.phoneExtension = phoneExtension;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", phoneExtension='" + phoneExtension + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

}
