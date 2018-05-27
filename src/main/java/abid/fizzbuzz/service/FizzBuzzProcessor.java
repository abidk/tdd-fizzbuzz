package abid.fizzbuzz.service;

import abid.fizzbuzz.model.FizzBuzzInput;
import abid.fizzbuzz.model.FizzBuzzResults;

public interface FizzBuzzProcessor {

    FizzBuzzResults process(FizzBuzzInput input);
}
