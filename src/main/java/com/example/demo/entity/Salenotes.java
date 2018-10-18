package com.example.demo.entity;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name="Salenotes") //ชื่อตาราง
public class Salenotes {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @GeneratedValue   // Annotations Generate id เอง ตอน insert
    private @NonNull Long salenotes_id;
    @OneToMany(
            mappedBy="salenotes", //bind many to one กับ receipt
            cascade = CascadeType.ALL,
            orphanRemoval = true) //delete Cascade
    private List<Receipt> receipt = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "user_id")      // join colume user_id จาก user กับ entity Salenotes
    private User user;

    protected Salenotes() {}
}