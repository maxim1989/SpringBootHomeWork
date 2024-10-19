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

    public Integer plus(Integer num1, Integer num2) {
        paramsRequired(num1, num2);
        return num1 + num2;
    }

    public Integer minus(Integer num1, Integer num2) {
        paramsRequired(num1, num2);
        return num1 - num2;
    }

    public Integer multiply(Integer num1, Integer num2) {
        paramsRequired(num1, num2);
        return num1 * num2;
    }

    public Double divide(Integer num1, Integer num2) {
        paramsRequired(num1, num2);
        if (num2 == 0) {
            throw new IllegalArgumentException("Деление на 0 запрещено");
        }
        return (double) num1 / num2;
    }
}
