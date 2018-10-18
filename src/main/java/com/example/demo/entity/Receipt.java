package com.example.demo.entity;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name="Receipt") //ชื่อตาราง
public class Receipt {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @GeneratedValue   // Annotations Generate id เอง ตอน insert
    private @NonNull Long receipt_id;
    private @NonNull Date date;

    //manytoone with Salenotes
    @ManyToOne(fetch = FetchType.LAZY)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "salenotes_id")      // join colume salenotes_id จาก video กับ entity comment
    private Salenotes salenotes;

    //onetomany with drugreceipt
    @OneToMany(
            mappedBy="receipt", //bind many to one กับ comment
            cascade = CascadeType.ALL)
    private List<DrugReceipt> drugReceipt = new ArrayList<>();

    //manytoone with user
    @ManyToOne(fetch = FetchType.LAZY)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "user_id")      // join colume user_id จาก user กับ entity comment
    private User user;

    protected Receipt() {}

}
