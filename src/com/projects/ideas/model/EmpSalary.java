package model;

import java.sql.Timestamp;

public class EmpSalary {
    int empId;
    String empName;
    int managerId;
    Timestamp timestamp;
    double salary;

    public EmpSalary(int empId, String empName, Timestamp timestamp, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.timestamp = timestamp;
        this.salary = salary;
    }
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
