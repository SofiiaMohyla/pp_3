package DroneFight.BattleArena;

import DroneFight.Drones.Droid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TeamsFight {
    private List<Droid> firstTeam = new ArrayList<>();
    private List<Droid> secondTeam = new ArrayList<>();

    public void setFirstTeam(Droid droid) {
        firstTeam.add(droid);
        System.out.println("added " + droid.getName() + " in 1 arr");
    }
    public void setSecondTeam(Droid droid) {
        secondTeam.add(droid);
        System.out.println("added " + droid.getName() + " in 2 arr");
    }

    public List<Droid> startTeamBattle() throws IOException {
        List<Droid> winners = new ArrayList<>();
        Droid winner;
        int randF = 0, randS = 0;
        OneVsOneFight battle = new OneVsOneFight();
        Random random = new Random();
        while (firstTeam.size() > 0 && secondTeam.size() > 0) {
            randF = random.nextInt(firstTeam.size());
            randS = random.nextInt(secondTeam.size());
            Droid firstDroid = firstTeam.get(randF);
            Droid secondDroid = secondTeam.get(randS);
            winner = battle.setDroids(firstDroid, secondDroid);
            if (winner == firstDroid)
                secondTeam.remove(randS);
            else
                firstTeam.remove(randF);
        }
        if (firstTeam.size() > secondTeam.size()) {
            System.out.println("First team won!!");
            winners.addAll(firstTeam);
        }
        else {
            System.out.println("Second team won!!");
            winners.addAll(secondTeam);
        }
        return winners;
    }


}
