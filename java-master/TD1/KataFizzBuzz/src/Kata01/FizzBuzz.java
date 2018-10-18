package Kata01;

public class FizzBuzz {
    public String fizzbuzz(int i){
        if (i % 3 == 0 && i % 5 == 0){
            return "FizzBuzz";
        } else if (i % 5 == 0){
            return "Buzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else {
            return Integer.toString(i);
        }

    }
}
