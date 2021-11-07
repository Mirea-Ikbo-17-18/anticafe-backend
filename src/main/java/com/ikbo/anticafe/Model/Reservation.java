package com.ikbo.anticafe.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "reservation")
    private Room room;

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

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "reservation")
    private KitOptions kitOptions;

    public Reservation() {

    }
}
