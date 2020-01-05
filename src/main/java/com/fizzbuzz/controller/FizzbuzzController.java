package com.fizzbuzz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fizzbuzz.model.FizzBuzz;
import com.fizzbuzz.utils.FizbuzzRules;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FizzbuzzController {
	

    @RequestMapping(value = "/fizzbuzz/{upperLimit}", method = RequestMethod.GET, produces = "application/json")
    public String getFizzBuzz(@PathVariable("upperLimit") int upperLimit, HttpServletResponse response) {

        FizzBuzz fizzBuzzObj = new FizzBuzz();
        
        List<Integer> fizzList = new ArrayList<>(),
                      buzzList = new ArrayList<>(), 
                      fizzBuzzList = new ArrayList<>();
        
        List<String> fizzbuzzNumberList = new ArrayList<>();
         
        ObjectMapper objectMapper = new ObjectMapper();

        try {
        	
            IntStream.range(1, upperLimit + 1)
            .forEach(i -> {
            	String numbers = FizbuzzRules.calculateFizzBuzz(i);
            	fizzbuzzNumberList.add(numbers);
                switch (numbers) {  
                    case "Buzz":
                        buzzList.add(i);
                        break;
                    case "Fizz":
                        fizzList.add(i);
                        break;
                    case "FizzBuzz":
                        fizzBuzzList.add(i);
                        break;
                }
            });

            fizzBuzzObj.setFizz(fizzList);
            fizzBuzzObj.setBuzz(buzzList);
            fizzBuzzObj.setFizzBuzz(fizzBuzzList);
            fizzBuzzObj.setFizzBuzzNumberSeries(fizzbuzzNumberList);
            return objectMapper.writeValueAsString(fizzBuzzObj);
        } catch (JsonProcessingException e) {
        	
        }

        return null;
    }
}