package deleteparentnchild;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;
    private String deptName;

    //@OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;

    //For remove all the employess at a time.
    public void removeAllEmployees() {
        for (Employee emp : employees) {
            emp.setDepartment(null); // Break the relationship
        }
        employees.clear(); // Remove all employees from the list
    }


}
