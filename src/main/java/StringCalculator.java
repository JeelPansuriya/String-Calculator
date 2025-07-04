public class StringCalculator {

    public int add(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] parts = input.split(",");
        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part.trim());
        }

        return sum;
    }
}
