package com.example.demo.controller;

import com.example.demo.model.Tourist;
import com.example.demo.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class TouristController {

    @Autowired
    private TouristRepository touristRepository;

    @GetMapping("tourist")
    public List<Tourist>getTourist(){
        return touristRepository.findAll();
    }
@PostMapping("tourist")
    public Tourist addTourist(@RequestBody Tourist tourist){
        return touristRepository.save(tourist);
}
}
