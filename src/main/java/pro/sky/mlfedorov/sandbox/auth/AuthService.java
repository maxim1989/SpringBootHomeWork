package pro.sky.mlfedorov.sandbox.auth;

public interface AuthService {
    public final String loginRegExp = "[a-zA-Z_0-9]{1,20}";
    public final String passwordRegExp = "[a-zA-Z_0-9]{1,20}";

    static void checkRegisterParams(
            String login,
            String password,
            String confirmPassword
    ) {
    }
}
