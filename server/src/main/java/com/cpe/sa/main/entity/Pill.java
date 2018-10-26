package com.cpe.sa.main.entity;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import java.util.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Pill")
public class Pill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private Float price;

    /* @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy="receipt")
    private List<Orders> orders = new ArrayList<>(); */

    protected Pill() {}

    public Pill(String name, Float price) {
        this.name = name;
        this.price = price;
    }
}