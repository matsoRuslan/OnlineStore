package com.test.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = {"email", "userName"})
public class User {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private long id;

    private String email;
    @Column(unique = true, nullable = false)
    private String userName;

    private String password;

    private transient String confirmPassword;

    private String firstName;

    private String lastName;

    private boolean active;

    private String address;

    private String phoneNumber;

    @ManyToOne
    private Role role;

    public User() {
    }
}
