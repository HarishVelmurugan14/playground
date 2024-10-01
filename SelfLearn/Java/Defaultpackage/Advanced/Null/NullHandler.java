package SelfLearn.Java.Defaultpackage.Advanced.Null;

import org.json.JSONArray;

import java.util.Optional;
import java.util.function.Consumer;

public class NullHandler {
    public static void main(String[] args) {
//        primary(null, "b");
        secondary(" Hello", null);
    }

    static void primary(String a, String b) {

        NewClass newClass = new NewClass();
//        Optional.ofNullable(a).ifPresent(newClass::setLogin);
        handleOptional(a, newClass::setLogin);
//        Optional.ofNullable(b).ifPresent(newClass::setLogin);
//        handleOptional(b, newClass::setAdmin);
    }

    static void secondary(String workflow, String name) {
        JSONArray detailArray = new JSONArray();
        detailArray.put("Workflow Type : " + workflow);
        detailArray.put("Workflow Name : " + name);
        Optional.ofNullable(workflow).ifPresent(x -> detailArray.put("something" + x));
        Optional.ofNullable(name).ifPresent(x -> detailArray.put("something" + x));

        for (Object jsonObject : detailArray){
            System.out.println(jsonObject);
        }
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
