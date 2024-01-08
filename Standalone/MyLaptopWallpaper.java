public class MyLaptopWallpaper {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String name = "magic";
        Boolean myAvailability = false;
        ArrayList<String> possibleLocations = new ArrayList<String>();
        possibleLocations.add("Conferance Room");
        possibleLocations.add("Pantry");
        possibleLocations.add("South Plaza Tent");
        possibleLocations.add("My Home");
        String whenCanYouExpectMeInMyPlace = "I am not sure";
        String emailAddress = "magic.vk@zohocorp.com";


        if(!myAvailability) {
            System.out.println("Hey There ! I am " + name + ", What's your name?");
            System.out.println("I am not available now. I may be in one of the following places :" + possibleLocations);
            System.out.println("The time by which you can expect me "+ whenCanYouExpectMe);
            System.out.println("Are you ready to wait?");
            Boolean isVisitorReadyToWait = userInput.nextBoolean();
            if(isVisitorReadyToWait) {
                System.out.println("Great! In the meantime you can find the bug I left for you to find in this code.");
            }else{
                Systen.out.println("I understand ! Please ping me at "+ emailAddress + ". We can catch up once I am available.");
            }
        }else{
            System.out.println("You shouldn't have come here. I am available.");
        }

    }
}