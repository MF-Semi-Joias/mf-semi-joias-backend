package com.api.mfsemijoias_cadastracliente;

import org.springframework.boot.SpringApplication;

public class TestMfSemiJoiasApplication {

	public static void main(String[] args) {
		SpringApplication.from(MfSemiJoiasApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
