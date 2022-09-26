package DroneFight.BattleArena;

import DroneFight.Drones.Boss;
import DroneFight.Drones.Droid;

import java.io.IOException;

public class BossFight {
    Droid boss = new Boss();

    public Droid startBossFight(Droid enemyDroid) throws IOException {
        OneVsOneFight fight = new OneVsOneFight();
        Droid winner = fight.setDroids(boss, enemyDroid);
        if (enemyDroid.getHealth() > boss.getHealth()) {
            System.out.println(enemyDroid.getName() + " won bos " + boss.getName());
            return  winner;
        }
        else {
            System.out.println(enemyDroid.getName() + " lose!!");
            return null;
        }
    }

}
