package com.fizzbuzz.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FizzBuzz {
    @JsonProperty("fizz")
    private List<Integer> Fizz;

    @JsonProperty("buzz")
    private List<Integer> Buzz;

    @JsonProperty("fizzBuzz")
    private List<Integer> FizzBuzz;
    
    @JsonProperty("fizzBuzzNumberSeries")
    private List<String> FizzBuzzNumberSeries;

    public List<Integer> getFizz() {
        return Fizz;
    }

    public void setFizz(List<Integer> fizz) {
        Fizz = fizz;
    }

    public List<Integer> getBuzz() {
        return Buzz;
    }

    public void setBuzz(List<Integer> buzz) {
        Buzz = buzz;
    }

    public List<Integer> getFizzBuzz() {
        return FizzBuzz;
    }

    public void setFizzBuzz(List<Integer> fizzBuzz) {
        FizzBuzz = fizzBuzz;
    }

	public List<String> getFizzBuzzNumberSeries() {
		return FizzBuzzNumberSeries;
	}

	public void setFizzBuzzNumberSeries(List<String> fizzBuzzNumberSeries) {
		FizzBuzzNumberSeries = fizzBuzzNumberSeries;
	}
}