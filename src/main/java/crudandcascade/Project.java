package crudandcascade;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int pId;

    private String projectName;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
