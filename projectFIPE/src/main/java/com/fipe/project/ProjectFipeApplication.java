package com.fipe.project;

import com.fipe.project.application.Program;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectFipeApplication.class, args);
	}
	@Override
	public void run(String... args) {
				Program program = new Program();
				program.menuExibit();
	}
}
