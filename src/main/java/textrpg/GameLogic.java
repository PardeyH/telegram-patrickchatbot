package textrpg;

import java.util.Scanner;

public class GameLogic {

    static Scanner scanner = new Scanner(System.in);
    static Player player;
    public static String playerName;

    public static boolean isRunning;

    public GameLogic() {}


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

    public static void createPlayer() {
        player = new Player(playerName);
    }

    //method to continue the journey
    public static void continueJourney() {

    }
    public static String printMenu() {
        String menu = "Choose an action:\n" +
                "1. Continue\n" +
                "2. Character Info\n" +
                "3. Exit\n";
        return menu;
    }

    public static String characterInfo() {
        return printHeading("CHARACTER_INFO\n") + "\n"
                + player.name + "\tHP: " + player.hp + "/" + player.maxHp + "\t"
                + printSeperator(22) + "\n"
                + "XP: " + player.xp + "\n"
                + (player.numAtkUpgrades > 0 ? "Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1] : "")
                + printSeperator(22) + "\n"
                + (player.numDefUpgrades > 0 ? "Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1] : "");
    }

    //anythingToContinue();
/*
    //start main game loop
    public static void gameLoop() {
        while(isRunning) {
            printMenu();
            int input = readInt("-> ", 3);
            if (input == 1) {
                continueJourney;
            } else if(input == 2) {
                characterInfo();
            } else {
                isRunning = false;
            }
        }

    }*/


}



