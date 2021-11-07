package com.ikbo.anticafe.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
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
    private String start;

    @NotBlank(message = "Field is empty!")
    @Size(min = 18, max = 30, message = "Field too big or small")
    @Column(name = "finish")
    private String finish;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    public Room() {

    }
}
