package textrpg;

import java.util.List;

public class UserState {

    private State state; // Enum representing the user's current state
    private int progress; // User's progress or level
    private List<String> inventory;
    public UserState() {
        this.state = State.START;
        this.progress = 0;
        // this.inventory = new ArrayList<>();
    }

    // Getters and setters for state, progress, and inventory


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void addToInventory(String item) {
        inventory.add(item);
    }

    public void removeFromInventory(String item) {
        inventory.remove(item);
    }

    // Additional methods and functionality as per your requirements

    // Add any other relevant fields and methods as needed

    // Constructors, getters, and setters

}
