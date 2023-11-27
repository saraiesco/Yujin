package com.example.Yujin;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private ClientRepository clientRepository;

    //getAll
    public List<Clinician> allClinicians(){
        System.out.println(clinicianRepository.findAll());
        return clinicianRepository.findAll();
    }


    //login
    public Clinician login(String username, String password) {
        Clinician clinician = clinicianRepository.findByUsername(username);

        if (clinician != null && clinician.getPassword().equals(password)) {
            List<Client> fullClientObjects = clinician.populateClientObjects(clientRepository);
            clinician.setFullClientObjects(fullClientObjects);
            return clinician;
        } else {
            return null;
        }
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

    public static class ClinicianNotFoundException extends RuntimeException {
        public ClinicianNotFoundException(ObjectId id) {
            super("Clinician not found with ID: " + id);
        }
    }
    //patch
    @Transactional
    public void patchClinician(ObjectId id, String name, String username, String password, String specialty) {
        Optional<Clinician> clinicianOptional = clinicianRepository.findById(id);

        if (clinicianOptional.isPresent()) {
            Clinician clinician = clinicianOptional.get();

            if (name != null) {
                clinician.setName(name);
            }

            if (username != null) {
                clinician.setUsername(username);
            }

            if (password != null) {
                clinician.setPassword(password);
            }

            if (specialty != null) {
                clinician.setSpecialty(specialty);
            }

            clinicianRepository.save(clinician);
        } else {
            throw new ClinicianNotFoundException(id);
        }
    }

    //delete
    public void deleteClinician(ObjectId id) {
        clinicianRepository.deleteById(id);
    }
}
