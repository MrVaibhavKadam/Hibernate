package crudandcascade;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@ToString(exclude = "projects")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String sName;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects;

    public Student(String sName, List<Project> projects) {
        this.sName = sName;
        this.projects = projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
        for (Project project : projects)
            project.setStudent(this);
    }

}
