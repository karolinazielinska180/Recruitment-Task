package com.example.zadanietest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PrimeNumberController {

    @GetMapping(value = "/")
    public String showForm() {
        return "/form";
    }

    @PostMapping(value = "/")
    public String processSubmit(@RequestParam("boundary") int boundary, Model model) {
        List<Integer> primeNumbers;
        primeNumbers = checkIfPrime(boundary);
        model.addAttribute("primeNumbers", primeNumbers);
        return "/showPrimeNumbers";
    }


    public List<Integer> checkIfPrime(int bound) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int i = 2; i <= bound; i++) {
            boolean isPrime = true;
            if (i % 2 == 0 && i != 2) {
                isPrime = false;
            } else {
                for (int j = 2; j <= i / 2; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                primeNumbers.add(i);
            }

        }
//        for (int number : primeNumbers) {
//            System.out.println(number);
//        }

        return primeNumbers;
    }
}
