package com.example.Yujin;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    //get all clients
    @GetMapping
    public ResponseEntity<String> allClients(){
        return new ResponseEntity<String>("All Clients", HttpStatus.OK);
    }

    //get one client
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> getSingleClient(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Client>>(clientService.singleClient(id), HttpStatus.OK);
    }

    //post client
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Map<String, Object> payload) {
        String name = (String) payload.get("name");
        List<String> conditions = (List<String>) payload.get("conditions");
        List<String> medicines = (List<String>) payload.get("medicines");
        List<String> symptoms = (List<String>) payload.get("symptoms");
        String lastApp = (String) payload.get("lastApp");
        String nextApp = (String) payload.get("nextApp");
        ObjectId id = (ObjectId) payload.get("id");

        Client client = clientService.createClient(name, conditions, medicines, symptoms, lastApp, nextApp,id);
        return new ResponseEntity<Client>(client, HttpStatus.CREATED);
    }

    //put client

    //delete client
}
