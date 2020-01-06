package com.fizzbuzz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fizzbuzz.model.FizzBuzz;
import com.fizzbuzz.utils.FizbuzzRules;

@Service
public class FizzbuzzServiceImpl implements FizzbuzzService {

	@Override
	public String getFizzBuzzNumbers(int upperLimit) {
		FizzBuzz fizzBuzzObj = new FizzBuzz();

		List<Integer> fizzList = new ArrayList<>(), buzzList = new ArrayList<>(), fizzBuzzList = new ArrayList<>();

		List<String> fizzbuzzNumberList = new ArrayList<>();

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			IntStream.range(1, upperLimit + 1).forEach(i -> {
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
			throw new RuntimeException();
		}
	}
}
