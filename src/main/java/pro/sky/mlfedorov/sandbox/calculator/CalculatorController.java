package pro.sky.mlfedorov.sandbox.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String helloRoot() {
        return calculatorService.hello();
    }

    @GetMapping(path = "/")
    public String hello() {
        return calculatorService.hello();
    }

    @GetMapping(path = "/plus")
    public String plus(
            @RequestParam(value = "num1", required = false) Integer num1,
            @RequestParam(value = "num2", required = false) Integer num2
    ) {
        return "Ответ: " + calculatorService.plus(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String minus(
            @RequestParam(value = "num1", required = false) Integer num1,
            @RequestParam(value = "num2", required = false) Integer num2
    ) {
        return "Ответ: " + calculatorService.minus(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String multiply(
            @RequestParam(value = "num1", required = false) Integer num1,
            @RequestParam(value = "num2", required = false) Integer num2
    ) {
        return "Ответ: " + calculatorService.multiply(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String divide(
            @RequestParam(value = "num1", required = false) Integer num1,
            @RequestParam(value = "num2", required = false) Integer num2
    ) {
        return "Ответ: " + calculatorService.divide(num1, num2);
    }
}
