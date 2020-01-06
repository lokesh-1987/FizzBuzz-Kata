package com.fizzbuzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fizzbuzz.exception.InvalidNumberException;
import com.fizzbuzz.service.FizzbuzzService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FizzbuzzController {
	
	@Autowired
	private FizzbuzzService fizzbuzzService;

    @RequestMapping(value = "/fizzbuzz/{upperLimit}", method = RequestMethod.GET, produces = "application/json")
    public String getFizzBuzz(@PathVariable("upperLimit") int upperLimit) {
    	
    	if(upperLimit < 1)
    		throw new InvalidNumberException("Number upper limit is invalid!!!");
    	
    	return fizzbuzzService.getFizzBuzzNumbers(upperLimit);
    }
}