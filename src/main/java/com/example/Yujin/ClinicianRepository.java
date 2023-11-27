package com.example.Yujin;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//data access layer for api, does job of talking to database and get data back
@Repository
public interface ClinicianRepository extends MongoRepository<Clinician, ObjectId> {

    Clinician findByUsername(String username);
}
