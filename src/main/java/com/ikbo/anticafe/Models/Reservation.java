package com.ikbo.anticafe.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "kit_reservation_id")
    private KitOptions kitOptions;


    ///////////////////

    /*@OneToOne(mappedBy = "room_reservation_id")
    private Room room;*/

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rm")
    private Room rm ;

    ///////////////////


    @NotBlank(message = "Field is empty!")
    @Column(name = "start")
    private Date start;

    @NotBlank(message = "Field is empty!")
    @Column(name = "finish")
    private Date finish;

    @NotBlank(message = "Field is empty!")
    @Size(min = 3, max = 6, message = "Field too big or small")
    @Column(name = "cost")
    private Integer cost;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usr")
    private User usr;



    ////////////////////////////////////////////////////////////////////////
    @Size(min = 3, max = 64, message = "Field too big or small")
    @Column(name = "email")
    private String email;

    @Size(min = 11, max = 12, message = "Field too big or small")
    @Column(name = "number")
    private String number;

    @Size(min = 3, max = 25, message = "Field too big or small")
    @Column(name = "firstname")
    private String firstname;

    @Size(min = 3, max = 25, message = "Field too big or small")
    @Column(name = "lastname")
    private String lastname;
}
