package com.example.demo.repository;
import com.example.demo.entity.Drug;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
    public interface DrugRepository extends JpaRepository < Drug, Long> {

}
