package textrpg;

public class Enemy extends Character {
    public Enemy(String name, int maxHp, int xp) {
        super(name, maxHp, xp);
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }
}
