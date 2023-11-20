package com.example.Yujin;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "Clinicians")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Clinician {
    @Id
    private ObjectId id;
    private String username;
    private String password;
    private String name;
    private String specialty;

    //one-to-many relationship (clinician to clients)
    @DocumentReference
    private List<Client> clientIds;


    public Clinician(String name, List<Client> clientIds , String username, String password, String specialty) {
        this.name = name;
        this.clientIds = clientIds;
        this.username = username;
        this.password = password;
        this.specialty = specialty;
    }
}
