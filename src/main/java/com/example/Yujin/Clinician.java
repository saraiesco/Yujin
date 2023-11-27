package com.example.Yujin;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Pattern;

@Document(collection = "Clinicians")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Clinician {
    @Id
    @DocumentReference(lazy = true)
    private ObjectId id;
    private String username;
    private String password;
    private String name;
    private String specialty;

    //one-to-many relationship (clinician to clients)
    @DocumentReference
    private List<Client> clientIds;

//names because ObjectIDs are turned into timestamps/date
    private ArrayList<String> clientNames;

    // Property to hold full client objects and setter
    private List<Client> fullClientObjects;

    public void setFullClientObjects(List<Client> fullClientObjects) {
        this.fullClientObjects = fullClientObjects;
    }

//    method to be used in service .... actually populate client data for client names
public List<Client> populateClientObjects(ClientRepository clientRepository) {
    List<Client> fullClientObjects = new ArrayList<>();

    for (String clientName : clientNames) {
        List<Client> clients = clientRepository.findByName(clientName);
        fullClientObjects.addAll(clients);
    }
    return fullClientObjects;
}



    public Clinician(String name, List<Client> clientIds, String username, String password, String specialty) {
        this.name = name;
        this.clientIds = clientIds;
        this.username = username;
        this.password = password;
        this.specialty = specialty;
    }

}
