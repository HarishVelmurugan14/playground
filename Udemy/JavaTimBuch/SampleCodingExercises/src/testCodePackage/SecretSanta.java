package testCodePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@SuppressWarnings("ALL")
public class SecretSanta {

    public static void main(String[] args) {


        ArrayList<String> inputList = inputData();
        ArrayList<String> recieverList = recieverList();
        HashMap<String, String> mappedData = new HashMap<>();

        String reciever = "";

        for (String user : inputList) {
            do {
                reciever = randomPicker(recieverList);
            } while (user.equalsIgnoreCase(reciever));
            recieverList.remove(reciever);
            mappedData.put(user, reciever);
        }

        for (String user : inputList) {
            System.out.println(user + " -> " + mappedData.get(user));
        }

    }

    public static ArrayList inputData() {
        ArrayList<String> userList = new ArrayList<>();
        userList.add("harish");
        userList.add("gokul");
        userList.add("vishnu");
        userList.add("rohith");
        userList.add("jawahar");
        userList.add("ram");
        userList.add("vignesh");
        userList.add("karthick");
        userList.add("siva");

        return userList;
    }

    public static ArrayList<String> recieverList() {
        ArrayList<String> userList = inputData();
        return userList;
    }

    public static String randomPicker(ArrayList<String> recieverList) {
        Random randomizer = new Random();
        String reciever = recieverList.get(randomizer.nextInt(recieverList.size()));
        return reciever;
    }
}
