package com.example.demo.entity;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name="Drug") //ชื่อตาราง
public class Drug {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @GeneratedValue   // Annotations Generate id เอง ตอน insert
    private @NonNull Long drug_id;
    private @NonNull String drugName;
    private @NonNull int price;
    private @NonNull int amount;
    private @NonNull String type;

    //onetomany with drugreceipt
    @OneToMany(
            mappedBy="receipt", //bind many to one กับ comment
            cascade = CascadeType.ALL)
    private List<DrugReceipt> drugReceipt = new ArrayList<>();

    protected Drug() {}
    public Drug(String drugName,int price,int amount,String type) {  //constructor
        this.drugName = drugName;
        this.price = price;
        this.amount=amount;
        this.type = type;
    }
}