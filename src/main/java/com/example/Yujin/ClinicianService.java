package com.example.Yujin;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//CRUD would be in here
//layer inbetween repo(data) and controller (UI)
@Service
public class ClinicianService {
    //autowire tells program to instantiate repo
    @Autowired
    private ClinicianRepository clinicianRepository;

    //getAll
    public List<Clinician> allClinicians(){
        System.out.println(clinicianRepository.findAll().toString());
                return clinicianRepository.findAll();
    }

    //getOne
    //optional needed in case id returns null
    public Optional<Clinician> singleClinician(ObjectId id){
            return clinicianRepository.findById(id);
    }

    //post
    public Clinician createClinician( String name, List<Client> clientIds, String username, String password, String specialty, ObjectId id){
        Clinician clinician = clinicianRepository.insert(new Clinician( name ,clientIds, username, password, specialty));

        return clinicianRepository.save(clinician);
    }

    //patch

    //delete
    public void deleteClinician(ObjectId id) {
        clinicianRepository.deleteById(id);
    }
}
