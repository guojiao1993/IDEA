package JUnit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CalculateTest {
    @Test
    public void add() {
        assertEquals(1, new Calculate().add(3, 5));
    }
}
