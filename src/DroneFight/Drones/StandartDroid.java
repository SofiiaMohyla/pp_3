package DroneFight.Drones;

public class StandartDroid extends Droid {
    private String name = "default";
    private String type = "Standart Drone";
    private int health = 10;
    private int maxDamage = 5;

    public boolean superPower(Droid enemyDroid) {
        if (enemyDroid.getHealth() > health) {
            health = enemyDroid.getHealth();
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
