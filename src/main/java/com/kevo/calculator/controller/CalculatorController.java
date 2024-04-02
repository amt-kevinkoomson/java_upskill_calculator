package com.kevo.calculator.controller;

import com.kevo.calculator.model.HealthCheck;
import com.kevo.calculator.model.InputExpression;
import com.kevo.calculator.service.InputService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CalculatorController {
    private final InputService inputService;
    private final long startTime = System.currentTimeMillis();
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public HealthCheck healthCheck() {
        long uptime = (System.currentTimeMillis() - startTime)/1000;
        return HealthCheck.builder()
                .message("Calculator Service Running")
                .uptime(uptime)
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/calculate")
    public double calculate(@RequestBody InputExpression expression) {
        return inputService.evaluateExpression(expression.getExpression());
    }
}
