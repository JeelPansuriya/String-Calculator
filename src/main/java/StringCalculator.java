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
        for (String part : parts) {
            sum += Integer.parseInt(part);
        }

        return sum;
    }
}
