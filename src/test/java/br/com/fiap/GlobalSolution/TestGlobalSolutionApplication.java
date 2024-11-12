package br.com.fiap.GlobalSolution;

import org.springframework.boot.SpringApplication;

public class TestGlobalSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.from(GlobalSolutionApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
