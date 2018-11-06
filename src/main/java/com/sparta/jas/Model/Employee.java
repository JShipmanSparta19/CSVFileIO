package com.sparta.jas.Model;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    private String id;
    private String prefix;
    private String firstName;
    private String midInitial;
    private String lastName;
    private boolean gender;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDate dateOfJoining;
    private int salary;

    public Employee(String id, String prefix, String firstName, String midInitial, String lastName, String gender, String email, String dateOfBirth, String dateOfJoining, String salary) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        this.id = id;
        this.prefix = prefix;
        this.firstName = firstName;
        this.midInitial = midInitial;
        this.lastName = lastName;
        if (gender.equals("M")){
            this.gender = false;
        } else if(gender.equals("F")) {
            this.gender = true;
        }
        this.email = email;
        this.dateOfBirth = LocalDate.parse(dateOfBirth, formatter);
        this.dateOfJoining = LocalDate.parse(dateOfJoining, formatter);
        this.salary = Integer.parseInt(salary);
    }

    public String getId() {
        return id;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMidInitial() {
        return midInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isFemale() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Emp ID=" + getId() + ", Name Prefix=" + getPrefix() + ", First Name=" + getFirstName() + ", Middle Initial=" + getMidInitial() + ", Last Name=" + getLastName() + ", Gender=" + (isFemale() ? "F":"M") + ", E Mail=" + getEmail() + ", Date of Birth=" + getDateOfBirth() + ", Date of Joining=" + getDateOfJoining() + ", Salary=" + getSalary();
    }
}
