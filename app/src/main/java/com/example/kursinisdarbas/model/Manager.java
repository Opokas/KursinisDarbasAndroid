package com.example.kursinisdarbas.model;



import java.time.LocalDate;
import java.util.List;



public class Manager extends User {

    private String employeeId;
    private LocalDate employmentDate;
    private boolean isAdmin;


    public Manager(String login, String password, LocalDate birthDate, String name, String surname, String employeeId, LocalDate employmentDate, boolean isAdmin) {
        super(login, password, birthDate, name, surname);
        this.employeeId = employeeId;
        this.employmentDate = employmentDate;
        this.isAdmin = isAdmin;
    }

//    public Manager(String login, String password, LocalDate birthDate) {
//
//    }

    @Override
    public String toString() {
        return this.employeeId+"| "+this.name;
    }
}
