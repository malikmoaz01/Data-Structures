import java.util.ArrayList;
import java.util.Collections;

public class MaximizeSalary {
    public static void main(String[] args) {
        long number = 8912889123L; 
        ArrayList<Long> digits = new ArrayList<>();

        while (number > 0) {
            digits.add(number % 10); 
            number /= 10;           
        }

        Collections.sort(digits, Collections.reverseOrder());

        StringBuilder maxSalary = new StringBuilder();
        for (long digit : digits) {
            maxSalary.append(digit);
        }

        System.out.println("Maximum Salary: " + maxSalary.toString());
    }
}
