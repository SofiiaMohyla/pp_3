package DroneFight.Drones;

public abstract class Droid {
    public abstract String getName();
    public abstract boolean superPower(Droid enemyDroid);
    public abstract int getMaxDamage();
    public abstract int getHealth();
    public abstract void setHealth(int health);
    public abstract void setName(String name);
    @Override
    public abstract String toString();
}
