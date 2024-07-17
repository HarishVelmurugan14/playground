package SelfLearn.Java.defaultpackage.Null;

import java.util.Optional;
import java.util.function.Consumer;

public class NullHandler {
    public static void main(String[] args) {
        primary(null, "b");
    }

    static void primary(String a, String b) {

        NewClass newClass = new NewClass();
//        Optional.ofNullable(a).ifPresent(newClass::setLogin);
        handleOptional(a, newClass::setLogin);
//        Optional.ofNullable(b).ifPresent(newClass::setLogin);
        handleOptional(b, newClass::setAdmin);
    }

    public static <T> void handleOptional(T optionalValue, Consumer<T> consumer) {
        Optional.ofNullable(optionalValue).ifPresent(consumer);
    }
}

class NewClass {
    public String login;
    public String admin;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null) {
            throw new NullPointerException();
        }
        System.out.println(login);
        this.login = login;
    }

    public void setAdmin(String admin) {
        if (admin == null) {
            throw new NullPointerException();
        }
        System.out.println(admin);
        this.admin = admin;
    }
}
