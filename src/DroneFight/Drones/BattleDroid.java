package DroneFight.Drones;

public class BattleDroid extends Droid {
    private String name = "default";
    private String type = "Battle Drone";
    private int health = 8;
    private int maxDamage = 7;

    public boolean superPower(Droid enemyDroid) {
        if (enemyDroid.getHealth() >= 0) {
            maxDamage = enemyDroid.getHealth() / 2;
            return true;
        }
        else
            return false;
    }
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxDamage() { return maxDamage; }
    public void setHealth(int health) { this.health = health; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "[" + type + "] - name: " + name;
    }
}
