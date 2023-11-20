package com.example.Yujin;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    //get All
    public List<Client> allClients(){
        System.out.println(clientRepository.findAll().toString());
        return clientRepository.findAll();
    }

    // get one
    public Optional<Client> singleClient(ObjectId id){
        return clientRepository.findById(id);
    }

    //post
    public Client createClient(String name, List<String> conditions, List<String> medicines, List<String> symptoms, String lastApp, String nextApp, ObjectId id){
        Client client = clientRepository.insert(new Client(name, conditions, medicines, symptoms, lastApp, nextApp));
        return clientRepository.save(client);

        //come back to fix association !

//        mongoTemplate.update(Clinician.class)
//                .matching(Criteria.where("ObjectId").is(ObjectId))
//                .apply(new Update().push("clientIds").value(client))
//                .first();
    }

    //put

    //delete
}
