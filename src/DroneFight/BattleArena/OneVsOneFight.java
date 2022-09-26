package DroneFight.BattleArena;

import DroneFight.Drones.Droid;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class OneVsOneFight {
    private Droid firstDroid;
    private Droid secondDroid;

    public Droid setDroids(Droid firstDroid, Droid secondDroid) throws IOException {
        this.firstDroid = firstDroid;
        this.secondDroid = secondDroid;
        return startFight();
    }

    public Droid startFight() throws IOException {
        FileWriter fileWriter = new FileWriter("/Users/admin/Desktop/Studing/3 sem/pp/cod/pp_3/src/DroneFight/BattleLog.txt");
        boolean flag = true;
        Droid temp;
        Droid attacker = firstDroid;
        Droid defender = secondDroid;
        Random randDamage = new Random();
        int damage;
        fileWriter.write("=================================");
        fileWriter.write("\n" + attacker.getName() + "[" + attacker.getHealth() +"]" +
                " VS " + defender.getName()+ "[" + defender.getHealth() +"]");
        fileWriter.write("\n=================================\n");
        do{
            damage = randDamage.nextInt(attacker.getMaxDamage() + 1);
            fileWriter.write("\n" +attacker.getName() + " attacks " + defender.getName() + " with damage - " + damage + "\n");
            defender.setHealth(defender.getHealth() - damage);
            fileWriter.write(defender.getName() + " health after attack - " + defender.getHealth() + "\n");
            if (attacker.getHealth() < 3 && defender.getHealth() > 0 && flag) {
                fileWriter.write("\n@@@ " + attacker.getName() + " used super power!! @@@\n");
                if(attacker.superPower(defender))
                    fileWriter.write("power is used by " + attacker.getName() + "\n");
                else
                    fileWriter.write("power is not used by " + attacker.getName() + "\n");
                flag = false;
            }
            if (defender.getHealth() > 0) {
                temp = defender;
                defender = attacker;
                attacker = temp;
            }
        }while (defender.getHealth() > 0);
        fileWriter.write("\n" + defender.getName() + " died a brave death\n");
        fileWriter.write(attacker.getName() + " is won!!!\n");
        fileWriter.write("=================================\n");
        System.out.println("The battle is over, " + attacker.getName() + " won!!!" + "\n(the battle can be viewed in a file)");
        fileWriter.close();
        return attacker;
    }
}
