package ClassTests;
import Kata01.FizzBuzz;
import org.junit.Test;
import junit.framework.*;

public class FizzBuzzTest extends TestCase{

    @Test
    public void testBuzz() throws Exception {
        FizzBuzz fb = new FizzBuzz();
        assertEquals("Buzz", fb.fizzbuzz(20));
    }

    @Test
    public void testFizz() throws Exception {
        FizzBuzz fb = new FizzBuzz();
        assertEquals("Fizz", fb.fizzbuzz(9));
    }

    @Test
    public void testFizzBuzz() throws Exception {
        FizzBuzz fb = new FizzBuzz();
        assertEquals("FizzBuzz", fb.fizzbuzz(15));
    }

    @Test
    public void testNumber() throws Exception {
        FizzBuzz fb = new FizzBuzz();
        assertEquals("2", fb.fizzbuzz(2));
    }
}
