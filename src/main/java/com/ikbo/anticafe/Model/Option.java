package com.ikbo.anticafe.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@Table(name = "options")
public class Option {
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
    @Size(min = 3, max = 6, message = "Field too big or small")
    @Column(name = "cost")
    private Integer cost;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kit_options")
    private KitOptions kit_options;

    public Option() {

    }
}
