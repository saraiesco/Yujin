package com.example.Yujin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class YujinApplication {

	public static void main(String[] args) {

		SpringApplication.run(YujinApplication.class, args);
	}

	@GetMapping("/")
	public String apiRoot(){
		return "Yujin";
	}
}
