package textrpg;

public class UserState {

    private State state; // Enum representing the user's current state

    private int progress; // User's progress or level

    public UserState() {
        this.state = State.START;
        this.progress = 0;
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

}
