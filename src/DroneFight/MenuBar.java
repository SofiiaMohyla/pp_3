package DroneFight;

import DroneFight.BattleArena.BossFight;
import DroneFight.BattleArena.OneVsOneFight;
import DroneFight.BattleArena.TeamsFight;
import DroneFight.Drones.BattleDroid;
import DroneFight.Drones.Droid;
import DroneFight.Drones.HeavyDroid;
import DroneFight.Drones.StandartDroid;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuBar {
    private List<Droid> droidList = new ArrayList<>();

    public void menu() throws IOException {
        boolean flag = false;
        int key = 0;
        Scanner inp = new Scanner(System.in);
        while(!flag){
            System.out.println("\n1 - Create droid\n2 - Show list\n3 - Start battle(1 vs 1)\n4 - Start battle(team vs team)" +
                    "\n5 - Boss Fight\n6 - reproduce last battle\n7 - exit\n");
            try {
                key = inp.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Please, enter integer number!!");
                break;
            }
            switch (key){
                case(1):
                    createDrone();
                    break;
                case(2):
                    showList();
                    break;
                case(3):
                    startOneVsOneFight();
                    break;
                case(4):
                    startTeamsFight();
                    break;
                case (5):
                    startBoss();
                    break;
                case(6):
                    reproduceBattle();
                    break;
                case(7):
                    flag = true;
                    break;
                default:
                    System.out.println("Enter the number specified in the menu!!");
                    break;
            }
        }
    }

    public void startBoss() throws IOException {
        BossFight bossFight= new BossFight();
        Droid fighter;
        Scanner in = new Scanner(System.in);
        int droidN = 0;
        if (droidList.size() == 0) {
            System.out.println("For boss fight you need 1 or more droids");
            return;
        }
        System.out.println("Choose droid:");
        showList();
        try {
            droidN = in.nextInt();
            if (droidN <= 0 || droidN > droidList.size()) {
                System.out.println("Choose droids in interval");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Please, enter integer number!!");
            return;
        }
        fighter = droidList.get(droidN - 1);
        droidList.remove(droidN - 1);
        fighter = bossFight.startBossFight(fighter);
        if (fighter != null)
            droidList.add(fighter);
    }

    public void reproduceBattle() throws IOException {
        FileReader fileReader = new FileReader("C:\\Workspace\\Desktop\\Education\\2 курс\\Прикладне програмування (Java)\\Labs\\Lab3\\src\\DroneFight\\BattleLog.txt");
        Scanner scan = new Scanner(fileReader);
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        fileReader.close();
    }

    public void startTeamsFight() throws IOException {
        TeamsFight arena = new TeamsFight();
        Scanner in = new Scanner(System.in);
        List<Droid> temp = new ArrayList<>();
        int droidN = 0, teamN;
        if (droidList.size() >= 2) {
            while (droidList.size() > 0) {
                int key = 0;
                System.out.println("Choose droid:");
                showList();
                try {
                    droidN = in.nextInt();
                    if (droidN <= 0 || droidN > droidList.size()) {
                        System.out.println("Choose droids in interval");
                        return;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please, enter integer number!!");
                    return;
                }
                System.out.println("Choose team or start battle(3):");
                try {
                    key = in.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Please, enter integer number!!");
                    return;
                }
                switch (key) {
                    case (1):
                        arena.setFirstTeam(droidList.get(droidN - 1));
                        droidList.remove(droidN - 1);
                        break;
                    case (2):
                        arena.setSecondTeam(droidList.get(droidN - 1));
                        droidList.remove(droidN - 1);
                        break;
                    case (3):
                        temp = arena.startTeamBattle();
                        droidList.addAll(temp);
                        break;
                    default:
                        System.out.println("Choose one from two teams!");
                        break;
                }
            }
            temp = arena.startTeamBattle();
            droidList.addAll(temp);
        } else
            System.out.println("For team vs team fight, you need 2 or more droids!!");
    }

    public void startOneVsOneFight() throws IOException {
        if (droidList.size() >= 2) {
            OneVsOneFight arena = new OneVsOneFight();
            Droid firstDroid, secondDroid;
            int firstDroidN = 0, secondDroidN = 0;
            Scanner in = new Scanner(System.in);
            System.out.println("Choose Droids:");
            showList();
            try {
                firstDroidN = in.nextInt();
            } catch (InputMismatchException a){
                System.out.println("Please, enter integer number!!");
                return;
            }
            if (firstDroidN <= 0 || firstDroidN > droidList.size()){
                System.out.println("Choose droids in interval");
                return;
            }
            firstDroid = droidList.get(firstDroidN - 1);
            droidList.remove(firstDroidN - 1);
            System.out.println("Choose Droids:");
            showList();
            try {
                secondDroidN = in.nextInt();
            } catch (InputMismatchException a){
                System.out.println("Please, enter integer number!!");
                System.exit(0);
            }
            if (secondDroidN <= 0 || secondDroidN > droidList.size()){
                System.out.println("Choose droids in interval");
                System.exit(0);
            }
            secondDroid = droidList.get(secondDroidN - 1);
            droidList.remove(secondDroidN - 1);
            droidList.add(arena.setDroids(firstDroid, secondDroid));
        }else
            System.out.println("For 1 vs 1 fight, you need 2 droids!!");
    }

    public void createDrone(){
        int typeN = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter:\n1 - Standart Droid\n2 - Heavy Droid\n3 - Battle Droid");
        try{
            typeN = Integer.parseInt(in.nextLine());
        }catch (NumberFormatException a){
            System.out.println("Please, enter integer number!!");
            return;
        }
        switch (typeN){
            case(1):
                Droid sDroid = new StandartDroid();
                System.out.println("Enter name of Droid:");
                sDroid.setName(in.nextLine());
                droidList.add(sDroid);
                break;
            case(2):
                Droid hDroid = new HeavyDroid();
                System.out.println("Enter name of Droid:");
                hDroid.setName(in.nextLine());
                droidList.add(hDroid);
                break;
            case(3):
                Droid bDroid = new BattleDroid();
                System.out.println("Enter name of Droid:");
                bDroid.setName(in.nextLine());
                droidList.add(bDroid);
                break;
            default:
                System.out.println("The droid does not exist under this number!!");
                break;
        }
    }

    public void showList(){
        if (droidList.size() == 0){
            System.out.println("Droids are not created!!");
        }
        for (int i = 0; i < droidList.size(); i++) {
            System.out.println((i+1) + ". " + droidList.get(i));
        }
    }
}
