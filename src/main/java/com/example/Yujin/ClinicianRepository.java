package com.example.Yujin;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//data access layer for api, does job of talking to database and get data back
@Repository
public interface ClinicianRepository extends MongoRepository<Clinician, ObjectId> {

}
