package com.example.Yujin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    private ObjectId id;
    private String name;
    private List<String> conditions;
    private List<String>  medicines;

    private List<String>  symptoms;
    private String lastApp;
    private String nextApp;
    private List<String>  notes;

    private String insurance;


}
