package com.example.demo.controller;

import com.example.demo.model.Tourist;
import com.example.demo.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class TouristController {

    @Autowired
    private TouristRepository touristRepository;

    @Autowired
    public TouristController(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    @GetMapping("tourist")
    public List<Tourist> getTourist() {
        return touristRepository.findAll();
    }

    @PostMapping("tourist")
    public Tourist addTourist(@RequestBody Tourist tourist) {
        return touristRepository.save(tourist);
    }
@PutMapping("tourist/{id}")
    public ResponseEntity<Tourist> updateTourist(@PathVariable Long id, @RequestBody Tourist tourist) {
        Optional<Tourist> optionalTourist = touristRepository.findById(id);
        if (optionalTourist.isPresent()) {

            optionalTourist.get().setFirstName(tourist.getFirstName());
            optionalTourist.get().setCountry(tourist.getCountry());
            optionalTourist.get().setLastName(tourist.getLastName());
            optionalTourist.get().setDateOfBirth(tourist.getDateOfBirth());
            optionalTourist.get().setGender(tourist.getGender());
            optionalTourist.get().setRemarks(tourist.getRemarks());
            optionalTourist.get().setFlightList(tourist.getFlightList());
            return new ResponseEntity<>(touristRepository.save(optionalTourist.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("tourist/{id}")
    public ResponseEntity<Tourist>deleteTourist(@PathVariable Long id){
        Optional<Tourist>optionalTourist=touristRepository.findById(id);
        if(optionalTourist.isPresent()){
            touristRepository.delete(optionalTourist.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
