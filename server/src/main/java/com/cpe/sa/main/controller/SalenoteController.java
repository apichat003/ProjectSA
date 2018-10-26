package com.cpe.sa.main.controller;

import java.util.List;
import java.util.Map;

import com.cpe.sa.main.entity.*;
import com.cpe.sa.main.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/salenote")
public class SalenoteController{
    @Autowired ReceiptRepository receiptRepository;
    @Autowired OrdersRepository ordersRepository;

    @GetMapping("/receipt")
    public List<Receipt> allReceipts(){
        return receiptRepository.findAll();
    }

    @GetMapping("/orders")
    public List<Orders> allOrders() {
        return ordersRepository.findAll();
    }

    @PostMapping("/receipt")
    public Receipt addReceipt(Receipt newReceipt, @RequestBody Map<String,String> body){


        return receiptRepository.save(newReceipt);
    }

}