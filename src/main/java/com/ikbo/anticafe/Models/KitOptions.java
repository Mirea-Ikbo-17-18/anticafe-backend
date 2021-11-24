package com.ikbo.anticafe.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "kit")
public class KitOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kit_reservation_id")
    private Reservation kit_reservation_id;

    @OneToMany(mappedBy = "kit_options", fetch = FetchType.LAZY)
    private List<Option> options;
}
