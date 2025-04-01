package com.api.mf_semi_joias;

import org.springframework.boot.SpringApplication;

public class TestMfSemiJoiasApplication {

	public static void main(String[] args) {
		SpringApplication.from(MfSemiJoiasApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
