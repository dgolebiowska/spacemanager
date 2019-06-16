package com.example.demo.repository;

import com.example.demo.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
    Optional<Tourist>findById(Long id);
}
