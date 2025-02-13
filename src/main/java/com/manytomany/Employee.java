package com.manytomany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int eid;
    private String name;


    @ManyToMany// first column created is known as join Column and second Column is Inverse Join Column.
    @JoinTable(name = "FK_Table")
    private List<Project> projects;

    public Employee() {
    }

    public Employee(int eid, String name, List<Project> projects) {
        this.eid = eid;
        this.name = name;
        this.projects = projects;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
