import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }
        String delimiter = "[,\n]";
        if(input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf('\n');
            String customDelimiter = input.substring(2, delimiterEndIndex);
            delimiter = Pattern.quote(customDelimiter);
            input = input.substring(delimiterEndIndex + 1);
        }

        String[] parts = input.split(delimiter);
        int sum = 0;
        List<Integer> NegativeNumbers = new ArrayList<>();
        for (String part : parts) {
            int number = Integer.parseInt(part);
            if(number < 0) {
                NegativeNumbers.add(number);
            }
            else if(number <= 1000){
                sum += number;
            }
        }
        if(!NegativeNumbers.isEmpty()) {
            throw new IllegalArgumentException( "negative numbers not allowed: " + NegativeNumbers.toString().replaceAll("[\\[\\] ]",""));
        }
        return sum;
    }
}
