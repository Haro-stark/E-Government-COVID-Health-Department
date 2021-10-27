package com.example.EGovt_CovidHealthApp.Model.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "hospital")
public class Hospital {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = true)
    private String createdDate;
    @Column(nullable = true)
    private String updatedDate;
    @Column
    private boolean status;
    @Column
    private int totalNumberOfBeds;
    @Column
    private int totalNumberOfVentilators;
    @Column
    private int availableNumberOfBeds;
    @Column
    private int availableNumberOfVentilators;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String province;
    
    @OneToMany(targetEntity = CovidTest.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hospitalId")
    private List<CovidTest> covidTests = new ArrayList<CovidTest>();
    
    @OneToMany(targetEntity = MobileVaccineCar.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MobileVaccineCar> mobileVaccineCars = new ArrayList<MobileVaccineCar>();
}
