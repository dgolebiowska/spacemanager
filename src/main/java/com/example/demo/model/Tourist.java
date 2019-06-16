package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tourist")
public class Tourist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tourist_id")
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Enumerated (EnumType.STRING)
    @Column(name = "gender")
    private GenderType gender;
    @Column(name = "country")
    private String country;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;
    @ManyToMany
    private List<Flight> flightList;


    public Tourist(String firstName, String lastName, GenderType gender, String country, String remarks, Date dateOfBirth, List<Flight> flightList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.remarks = remarks;
        this.dateOfBirth = dateOfBirth;
        this.flightList = flightList;
    }
public Tourist(){

}
}
