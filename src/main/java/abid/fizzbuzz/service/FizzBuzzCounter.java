package abid.fizzbuzz.service;

import abid.fizzbuzz.model.FizzBuzzCount;
import abid.fizzbuzz.model.FizzBuzzResults;

import java.util.List;

public interface FizzBuzzCounter {

    List<FizzBuzzCount> count(FizzBuzzResults result);
}
