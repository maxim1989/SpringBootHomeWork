package pro.sky.mlfedorov.sandbox.calculator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private static void paramsRequired(Integer num1, Integer num2) {
        if (num1 == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "num1 не передан");
        }
        if (num2 == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "num2 не передан");
        }
    }

    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    public int plus(Integer num1, Integer num2) {
        paramsRequired(num1, num2);
        return num1 + num2;
    }

    public int minus(Integer num1, Integer num2) {
        paramsRequired(num1, num2);
        return num1 - num2;
    }

    public int multiply(Integer num1, Integer num2) {
        paramsRequired(num1, num2);
        return num1 * num2;
    }

    public double divide(Integer num1, Integer num2) {
        paramsRequired(num1, num2);
        if (num2 == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Деление на 0 запрещено");
        }
        return (double) num1 / num2;
    }
}
