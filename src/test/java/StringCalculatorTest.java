import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    public void testEmptyStringReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testNullStringReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(null));
    }

    @Test
    public void testSingleNumberReturnsValue() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(5, calculator.add("5"));
    }

    @Test
    public void testTwoNumberReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(9, calculator.add("4,5"));
    }

    @Test
    public void testMultipleNumbersReturnsSum() {
        assertEquals(10, new StringCalculator().add("1,2,3,4"));
        assertEquals(55, new StringCalculator().add("1,2,3,4,5,6,7,8,9,10"));
        assertEquals(60, new StringCalculator().add("10,20,30"));
    }

    @Test
    public void testDelimiterNewLine() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void testCustomDelimiterSemicolon() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
        assertEquals(6, new StringCalculator().add("//|\n1|2|3"));
        assertEquals(9, new StringCalculator().add("//.\n2.3.4"));
    }

    @Test
    public void testNegativeNumbersThrowException() {
        StringCalculator calculator = new StringCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });

        assertEquals("negative numbers not allowed: -2,-4", exception.getMessage());
    }
}
