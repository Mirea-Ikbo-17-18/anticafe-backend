package com.ikbo.anticafe.Model;

import com.ikbo.anticafe.Model.Enums.Role;
import com.ikbo.anticafe.Model.Enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    //@NotBlank(message = "")
    //@Size(min = , max = , message = "")
    @NotBlank(message = "Field is empty!")
    @Size(min = 3, max = 25, message = "Field too big or small")
    @Column(name = "firstname")
    private String firstname;

    @NotBlank(message = "Field is empty!")
    @Size(min = 3, max = 25, message = "Field too big or small")
    @Column(name = "lastname")
    private String lastname;

    @NotBlank(message = "Field is empty!")
    @Size(min = 11, max = 12, message = "Field too big or small")
    @Column(name = "number")
    private String number;

    @NotBlank(message = "Field is empty!")
    @Size(min = 3, max = 64, message = "Field too big or small")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Field is empty!")
    @Size(min = 3, max = 255, message = "Field too big or small")
    @Column(name = "password")
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private Reservation reservation;

    public User() {

    }
}
