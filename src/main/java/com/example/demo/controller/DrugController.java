package com.example.demo.controller;
import java.util.Collection;
import com.example.demo.entity.Drug;
import com.example.demo.repository.DrugRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin("http://localhost:4200")
public class DrugController {
    private DrugRepository repo;

    @GetMapping("/Drug")
    public Collection<Drug> Drug(){ 
        return repo.findAll();
    }
}
