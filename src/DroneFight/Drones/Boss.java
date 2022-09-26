package DroneFight.Drones;

import java.util.Random;

public class Boss extends Droid{
    private String name = "AMONG";
    private String type = "BOSS";
    private int health = 17;
    private int maxDamage = 9;

    public boolean superPower(Droid enemyDroid) {
        Random random = new Random();
        if ((random.nextInt(10) % 2) == 0){
            maxDamage += 5;
            return true;
        }
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
