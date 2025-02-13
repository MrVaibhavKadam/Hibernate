package com.manytomany;


import javax.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pid;

    @Column(name = "project_name")
    private String pName;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> emps;

    public Project() {
    }

    public Project(int pid, String pName, List<Employee> emps) {
        this.pid = pid;
        this.pName = pName;
        this.emps = emps;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }
}
