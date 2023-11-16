package com.example.Yujin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @GetMapping
    public ResponseEntity<String> allClients(){
        return new ResponseEntity<String>("All Clients", HttpStatus.OK);
    }
}
