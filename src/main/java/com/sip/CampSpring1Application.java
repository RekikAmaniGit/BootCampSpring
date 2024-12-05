package com.sip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.sip.controllers.ArticleController;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class CampSpring1Application {

	public static void main(String[] args) throws IOException {
		//new File(ArticleController.uploadDirectory).mkdir();
		Path path = Paths.get(ArticleController.uploadDirectory);
		try {
		 if (!Files.exists(path))
			 Files.createDirectory(path);
		SpringApplication.run(CampSpring1Application.class, args);
		} catch (IOException e) {
			  // Handle the directory creation error (e.g., log or throw a new exception)
			  e.printStackTrace();
			}
	}

}
