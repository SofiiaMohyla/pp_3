package DroneFight.Drones;

public class HeavyDroid extends Droid {
    private String name = "default";
    private String type = "Heavy Drone";
    private int health = 15;
    private int maxDamage = 4;

    public boolean superPower(Droid enemyDroid) {
        if (enemyDroid.getHealth() >= 0) {
            health += enemyDroid.getHealth();
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
