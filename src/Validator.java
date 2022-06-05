import java.util.Objects;


public class Validator {
    private static final String VALID_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

    private Validator() {
    }

    public static boolean check(String login, String password, String confirmPassword) {
        try {
            validate(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void validate(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20 ) {
            throw new WrongLoginException("dlina logina <=20");
        }
        if (!containsValidSymbols(login)) {
            throw new WrongPasswordException("логин содержит невалидные символы");
        }
        //if( checkPassword(password) || checkPassword(confirmPassword)){
        if (isNotValidPassword(password) || isNotValidPassword(confirmPassword)) {
            throw new WrongPasswordException("dlina logina <20");
        }
        if (!containsValidSymbols(password)) {
            throw new WrongPasswordException("пароль содержит невалидные символы");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("paroli dolzni sovpadat");
        }
    }

    //private static boolean  checkPassword(String password) {
    private static boolean isNotValidPassword(String password) {
        return Objects.isNull(password) || password.length() >= 20 || !containsValidSymbols(password);
    }

    private static boolean containsValidSymbols(String s) {
        char[] symbols = s.toCharArray();
        for (char symbol : symbols) {
            if (!VALID_SYMBOLS.contains(String.valueOf(symbol))) {
                return false;
            }
        }
        return false;
    }
}

