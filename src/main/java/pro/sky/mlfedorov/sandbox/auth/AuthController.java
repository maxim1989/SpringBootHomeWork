package pro.sky.mlfedorov.sandbox.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.mlfedorov.exceptions.WrongLoginException;
import pro.sky.mlfedorov.exceptions.WrongPasswordException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @GetMapping
    public String register(
            @RequestParam() String login,
            @RequestParam() String password,
            @RequestParam() String confirmPassword
    ) {
        try {
            AuthServiceImpl.checkRegisterParams(login, password, confirmPassword);
        } catch (WrongLoginException error) {
            return error.getMessage();
        } catch (WrongPasswordException error) {
            return error.getMessage();
        }

        return "Successful registration";
    }
}
