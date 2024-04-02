package com.kevo.calculator;

import com.kevo.calculator.service.InputService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorAppApplication {
	private static final InputService inputService = new InputService();
	public static void main(String[] args) {
		SpringApplication.run(CalculatorAppApplication.class, args);
	}

}
