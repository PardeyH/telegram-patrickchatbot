package textrpg;

import java.util.Scanner;

public class GameLogic {

    static Scanner scanner = new Scanner(System.in);
    static Player player;
    public static String playerName;

    public GameLogic() {}

    //method to get user input from console
    public static int readInt(String prompt, int userChoices) {
        int input;

        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter a number!");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }

    //method to print a seperator with length n
    public static String printSeperator(int n) {
        StringBuilder seperator = new StringBuilder();
        for(int i = 0; i < n; i++)
            seperator.append("-");
        return seperator.toString();
    }

    //method to print a heading
    public static String printHeading(String title) {
        StringBuilder heading = new StringBuilder(printSeperator(22));
        heading.append(title);
        heading.append(printSeperator(22));
        return heading.toString();
    }

    //method to start the game
    public static String titleScreen() {
        //print title screen
        return printHeading("\n\"Text-RPG\" by Patrick\n");
    }


    //getting the player name
    public static String chooseName(String name) {
        playerName = name;
        return "Your name is " + name + ". \n" +
                "Is that correct? Please enter 'Yes' or 'No'!";
    }

    public static String createPlayer() {
        player = new Player(playerName);
        return playerName;
    }

        //start main game loop
        // gameLoop();

}



