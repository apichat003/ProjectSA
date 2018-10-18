package com.example.demo.entity;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.*;
import lombok.*;
@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name="User") //ชื่อตาราง
public class User {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @GeneratedValue   // Annotations Generate id เอง ตอน insert
    private @NonNull Long user_id;
    private @NonNull String userName;

    @OneToMany(
            mappedBy="user", //bind many to one กับ comment
            cascade = CascadeType.ALL)
    private List<Salenotes> salenotes = new ArrayList<>();

    @OneToMany(
            mappedBy="user", //bind many to one กับ comment
            cascade = CascadeType.ALL)
    private List<Receipt> receipt = new ArrayList<>();

    protected User() {}
    public User (String userName){
        this.userName=userName;
    }
}