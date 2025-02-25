package org.example;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")

//@Data -> If we use this then we dont need @Getter @Setter and @ToString bcoz it is included in @Data

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // User name (required, not empty, size between 3 and 20)
    @Size(max = 20, min = 5, message = "Invalid name. Name must be between 5 to 20")
    @NotEmpty(message = "Please enter name")
    @Column(name = "f_name")
    private String firstName;

    @Column(name = "l_name" )
    private String lastName;

    // User email ID (required, not empty, valid email format)
    @Email(message = "Invalid email address. Please enter a proper email ID.")
    @NotEmpty(message = "Please enter your email ID.")
    @Column(name = "email" )
    private String email;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
