package com.ikbo.anticafe.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "kit")
public class KitOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    @OneToMany(mappedBy = "kit_options", fetch = FetchType.LAZY)
    private List<Option> options;

    public KitOptions() {

    }
}
