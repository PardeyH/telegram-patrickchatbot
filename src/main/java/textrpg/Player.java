package textrpg;

import java.util.Arrays;

public class Player extends Character {

    //integers to store number of upgrades/Skills in each path
    public int numAtkUpgrades, numDefUpgrades;

    public String[] atkUpgrades = {"Strength", "Power", "Might", "Godlike Strength"};
    public String[] defUpgrades = {"Heavy Bones", "Stoneskin","Scale Armor", "Holy Aura"};

    //Player specific constructor
    public Player(String name) {
        //calling constructor of superclass
        super(name, 100,0);
        //Setting # of upgrades to 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        //let the player chose a trait when creating a new character
        //chooseTrait();
    }
    /*

    private void chooseTrait() {
        GameLogic.printHeading("Choose a trait:");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
        //get the players choice:
        int input = GameLogic.readInt("-> ", 2);
        //deal with both cases
        if (input == 1) {
            GameLogic.printHeading("You chose " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        } else {
            GameLogic.printHeading("You chose " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
    }

     */

    //Player specific methods
    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "numAtkUpgrades=" + numAtkUpgrades +
                ", numDefUpgrades=" + numDefUpgrades +
                ", atkUpgrades=" + Arrays.toString(atkUpgrades) +
                ", defUpgrades=" + Arrays.toString(defUpgrades) +
                '}';
    }
}
