package com.example.EGovt_CovidHealthApp.Repostiory;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EGovt_CovidHealthApp.Model.Entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	List<Patient> findAllByStatusTrueOrderByCreatedDateDesc();
	
	Patient findByCnicAndStatusTrue(String cnic);
	Patient findByEmailAndPassword(String email, String password);
	Boolean existsByEmailAndPasswordAndStatusTrue(String email, String password);

	Long countByIsCovidTrue();
	Long countByIsCovidTrueAndCity(String city);
	Long countByIsCovidTrueAndProvince(String province);

	Long countByIsAliveFalse();
	Long countByIsAliveFalseAndCity(String city);
	Long countByIsAliveFalseAndProvince(String province);
	
	Long countByPatientReports_CreatedDateBetweenAndPatientReports_TestResultsIgnoreCase(Date after, Date before, String testResult);
	Long countByPatientReports_CreatedDateBetweenAndPatientReports_TestResultsIgnoreCaseAndCityIgnoreCase(Date after, Date before, String testResult, String city);
	Long countByPatientReports_CreatedDateBetweenAndPatientReports_TestResultsIgnoreCaseAndProvinceIgnoreCase(Date after, Date before, String testResult, String province);
}