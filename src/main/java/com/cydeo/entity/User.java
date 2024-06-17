package com.cydeo.entity;

import com.cydeo.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
//@Where(clause = "is_deleted = false")
public class User extends BaseEntity {


    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private String confirmPassword;

    @ManyToOne
    private Role role;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne (cascade = CascadeType.ALL)
    private Address address;

}
