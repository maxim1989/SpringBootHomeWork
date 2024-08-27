package pro.sky.mlfedorov.sandbox.auth;

import org.springframework.stereotype.Service;
import pro.sky.mlfedorov.exceptions.WrongLoginException;
import pro.sky.mlfedorov.exceptions.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthServiceImpl implements AuthService {
    public static void checkRegisterParams(
            String login,
            String password,
            String confirmPassword
    ) {
        Pattern loginPattern = Pattern.compile(loginRegExp);
        Matcher loginMatcher = loginPattern.matcher(login);

        if (!loginMatcher.matches()) {
            throw new WrongLoginException("Validation failed: params: login");
        }

        Pattern passwordPattern = Pattern.compile(passwordRegExp);
        Matcher passwordMatcher = passwordPattern.matcher(password);

        if (!passwordMatcher.matches()) {
            throw new WrongPasswordException("Validation failed: params: password");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Validation failed: params: confirmPassword");
        }
    }
}
