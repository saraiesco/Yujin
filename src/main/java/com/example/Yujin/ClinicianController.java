package com.example.Yujin;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//uses service class to call All clinicians, delegate task of getting clinician to api layer
//ui layer
@RestController
@RequestMapping("/Clinicians")
public class ClinicianController {
    @Autowired
    private ClinicianService clinicianService;

    //get all
    @GetMapping
    public ResponseEntity<List<Clinician>> getAllClinicians(){
        return new ResponseEntity<List<Clinician>>(clinicianService.allClinicians(), HttpStatus.OK);
    }

    //get one
    //pathvar is like params
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Clinician>> getSingleClinician(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Clinician>>(clinicianService.singleClinician(id), HttpStatus.OK);
    }

    //post
    @PostMapping
    public ResponseEntity<Clinician> createClinician(@RequestBody Map<String, Object> payload) {
        String name = (String) payload.get("name");
        List<Client> clientIds = (List<Client>) payload.get("clientIds");
        String username = (String) payload.get("username");
        String password = (String) payload.get("password");
        String specialty = (String) payload.get("specialty");
        ObjectId id = (ObjectId) payload.get("id");

        Clinician clinician = clinicianService.createClinician(name, clientIds, username, password, specialty, id);
        return new ResponseEntity<Clinician>(clinician, HttpStatus.CREATED);
    }


    //patch
    @PatchMapping("/{id}")
    public ResponseEntity<Clinician> updateClinician(@PathVariable ObjectId id, @RequestBody Map<String, Object> payload) {
        clinicianService.patchClinician(id,
                (String) payload.get("name"),
                (String) payload.get("username"),
                (String) payload.get("password"),
                (String) payload.get("specialty"));

        return new ResponseEntity<Clinician>(HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClinician(@PathVariable ObjectId id) {
        clinicianService.deleteClinician(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
