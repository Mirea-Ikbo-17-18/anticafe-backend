package com.ikbo.anticafe.Models;

import com.ikbo.anticafe.Models.Enums.Role;
import com.ikbo.anticafe.Models.Enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usr")
    private List<Reservation> reservation;
}
