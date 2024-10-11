package pro.sky.mlfedorov.sandbox.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

public class CalculatorServiceImplTest {
    private CalculatorServiceImpl out = null;

    @BeforeEach
    public void initEach() {
        out = new CalculatorServiceImpl();
    }

    @AfterEach
    public void finishEach() {
        out = null;
    }

    @Test
    public void plusShouldReturnFive() {
        int result = out.plus(3, 2);

        assertEquals(5, result);
    }

    @Test
    public void plusShouldReturnOne() {
        int result = out.plus(1, 0);

        assertEquals(1, result);
    }

    @Test
    public void plusShouldThrowExceptionNum1NotExist() {
        assertThrows(ResponseStatusException.class, () -> out.plus(null, 10));
    }

    @Test
    public void plusShouldThrowExceptionNum2NotExist() {
        assertThrows(ResponseStatusException.class, () -> out.plus(10, null));
    }

    @Test
    public void minusShouldReturnFive() {
        int result = out.minus(7, 2);

        assertEquals(5, result);
    }

    @Test
    public void minusShouldReturnOne() {
        int result = out.minus(1, 0);

        assertEquals(1, result);
    }

    @Test
    public void minusShouldThrowExceptionNum1NotExist() {
        assertThrows(ResponseStatusException.class, () -> out.minus(null, 10));
    }

    @Test
    public void minusShouldThrowExceptionNum2NotExist() {
        assertThrows(ResponseStatusException.class, () -> out.minus(10, null));
    }

    @Test
    public void multiplyShouldReturnSix() {
        int result = out.multiply(3, 2);

        assertEquals(6, result);
    }

    @Test
    public void multiplyShouldReturnOne() {
        int result = out.multiply(1, 1);

        assertEquals(1, result);
    }

    @Test
    public void multiplyShouldThrowExceptionNum1NotExist() {
        assertThrows(ResponseStatusException.class, () -> out.multiply(null, 10));
    }

    @Test
    public void multiplyShouldThrowExceptionNum2NotExist() {
        assertThrows(ResponseStatusException.class, () -> out.multiply(10, null));
    }

    @Test
    public void divideShouldReturnSix() {
        Double result = out.divide(12, 2);

        assertEquals(6, result);
    }

    @Test
    public void multiplyShouldReturnOneAndHalf() {
        Double result = out.divide(3, 2);

        assertEquals(1.5d, result);
    }

    @Test
    public void divideShouldThrowExceptionNum1NotExist() {
        assertThrows(ResponseStatusException.class, () -> out.divide(null, 10));
    }

    @Test
    public void divideShouldThrowExceptionNum2NotExist() {
        assertThrows(ResponseStatusException.class, () -> out.divide(10, null));
    }

    @Test
    public void divideShouldThrowExceptionNum2Zero() {
        assertThrows(IllegalArgumentException.class, () -> out.divide(10, 0));
    }
}
