package com.ikbo.anticafe.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Field is empty!")
    @Size(min = 3, max = 30, message = "Field too big or small")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Field is empty!")
    @Size(min = 3, max = 255, message = "Field too big or small")
    @Column(name = "description")
    private String description;

    @NotBlank(message = "Field is empty!")
    @Size(min = 3, max = 5, message = "Field too big or small")
    @Column(name = "cost")
    private Integer cost;

    @NotBlank(message = "Field is empty!")
    @Size(min = 18, max = 30, message = "Field too big or small")
    @Column(name = "start")
    private Date start;

    @NotBlank(message = "Field is empty!")
    @Size(min = 18, max = 30, message = "Field too big or small")
    @Column(name = "finish")
    private Date finish;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_reservation_id")
    private Reservation room_reservation_id;
}
