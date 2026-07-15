import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            // Check divisibility by both 3 and 5 first
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            } 
            // Check divisibility by 3
            else if (i % 3 == 0) {
                answer.add("Fizz");
            } 
            // Check divisibility by 5
            else if (i % 5 == 0) {
                answer.add("Buzz");
            } 
            // If not divisible by 3 or 5, add the number as a string
            else {
                answer.add(String.valueOf(i));
            }
        }
        
        return answer;
    }
}
