package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "flight")
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "flight_id")
    private Long id;
    @Column(name = "departureDate")
    private LocalDateTime departureDate;
    @Column (name = "arrivalDate")
    private LocalDateTime arrivalDate;
    @Column (name = "numberOfSeats")
    private int numberOfSeats;
    @ManyToMany
    private List<Tourist> touristList;
    @Column (name = "ticketPrice")
    private float ticketPrice;


    public Flight(LocalDateTime departureDate, LocalDateTime arrivalDate, int numberOfSeats, List<Tourist> touristList, float ticketPrice) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.numberOfSeats = numberOfSeats;
        this.touristList = touristList;
        this.ticketPrice = ticketPrice;
    }
    public Flight(){

    }
}
