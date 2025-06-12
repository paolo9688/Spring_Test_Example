package com.example.test_exercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calcolatrice")
public class CalcolatriceController {

    @GetMapping("/sum")
    public Integer getSum(@RequestParam Integer a, @RequestParam Integer b) {
        Integer sum = a + b;
        return sum;
    }

    @GetMapping("/sub")
    public Integer getSub(@RequestParam Integer a, @RequestParam Integer b) {
        Integer sub = a - b;
        return sub;
    }

    @GetMapping("/multip")
    public Integer getMultip(@RequestParam Integer a, @RequestParam Integer b) {
        Integer multip = a * b;
        return multip;
    }

    @GetMapping("/div")
    public Double getDiv(@RequestParam Double a, @RequestParam Double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero!");
        }

        Double div = a / b;
        return div;
    }

    @GetMapping("/pow")
    public Double getPow(@RequestParam Double a, @RequestParam Double b) {
        Double pow = Math.pow(a, b);
        return pow;
    }

    @GetMapping("/rad")
    public Double getRad(@RequestParam Double a) {
        Double rad = Math.sqrt(a);
        return rad;
    }
}
