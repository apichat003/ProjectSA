package com.cpe.sa.main;

import com.cpe.sa.main.entity.*;
import com.cpe.sa.main.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoaderSalenote implements ApplicationRunner {

    @Autowired private UserRepository userRepository;
    @Autowired private Personrepos personnelRepository;
    @Autowired private PillRepository pillRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        personnelRepository.save(new personnel("a","b","c","d","e","f"));
        personnelRepository.findAll().forEach(System.out::println);

        userRepository.save(new User("miwtoo","1234567",1L));
        userRepository.findAll().forEach(System.out::println);

        pillRepository.save(new Pill("Para",10.2f));
        pillRepository.save(new Pill("E",5.1f));
        pillRepository.save(new Pill("Ma",100f));
        pillRepository.findAll().forEach(System.out::println);

        
	}
    
}