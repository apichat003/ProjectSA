package com.example.demo.entity;
import lombok.NonNull;

import javax.persistence.*;
@Entity
@Table(name="DrugReceipt") //ชื่อตาราง
public class DrugReceipt {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @GeneratedValue   // Annotations Generate id เอง ตอน insert
    private @NonNull Long DrugReceeipt_id;

    @ManyToOne(fetch = FetchType.LAZY)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "drug_id")      // join colume user_id จาก user กับ entity comment
    private Drug drug;

    @ManyToOne(fetch = FetchType.LAZY)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "receipt_id")      // join colume user_id จาก user กับ entity comment
    private Receipt receipt;


}
