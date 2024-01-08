package Standalone;

import java.util.ArrayList;
import java.util.Scanner;
public class MyLaptopWallpaper {
//    public static void main(String[] args) {
//        generateWallpaper();
//    }
    public static void generateWallpaper() {
        Scanner userInput = new Scanner(System.in);
        String name = "magic";
        boolean myAvailability = false;
        ArrayList<String> possibleLocations = new ArrayList<>();
        possibleLocations.add("Conferance Room");
        possibleLocations.add("Pantry");
        possibleLocations.add("South Plaza Tent");
        possibleLocations.add("My Home");
        String whenCanYouExpectMe = "I am not sure";
        String emailAddress = "magic.vk@zohocorp.com";


        if(!myAvailability) {
            System.out.println("Hey There ! I am " + name + ", What's your name?");
            System.out.println("I am not available now. I may be in one of the following places :" + possibleLocations);
            System.out.println("The time by which you can expect me "+ whenCanYouExpectMe);
            System.out.println("Are you ready to wait?");
            boolean isVisitorReadyToWait = userInput.nextBoolean();
            if(isVisitorReadyToWait) {
                System.out.println("Great! In the meantime you can find the bug I left for you to find in this code.");
            }else{
                System.out.println("I understand ! Please ping me at "+ emailAddress + ". We can catch up once I am available.");
            }
        }else{
            System.out.println("You shouldn't have come here. I am available.");
        }

    }
}