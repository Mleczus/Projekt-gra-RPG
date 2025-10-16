import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Attackable player = null;

        System.out.println("Witaj w grze RPG!");
        System.out.println("Wybierz swoją postać główną:");
        System.out.println("1. Wojownik");
        System.out.println("2. Mag");
        System.out.println("3. Łucznik");

        int choice = scanner.nextInt();
        scanner.nextLine(); // pochłonięcie entera

        System.out.print("Podaj imię swojej postaci: ");
        String playerName = scanner.nextLine();

        switch (choice) {
            case 1 -> player = new Warrior(playerName);
            case 2 -> player = new Mage(playerName);
            case 3 -> player = new Archer(playerName);
            default -> {
                System.out.println("Niepoprawny wybór.");
                System.exit(0);
            }
        }

        Character playerChar = (Character) player;
        playerChar.showStats();

        List<Attackable> team = new ArrayList<>();
        team.add(player);
        List<Character> teamChars = new ArrayList<>();
        teamChars.add(playerChar);

        // Lista poziomów, przy których można dodać nowego członka drużyny
        int[] levelsToAddCompanion = {5, 10, 15};
        int nextCompanionIndex = 0;

        while (playerChar.level < 20 && playerChar.isAlive()) {
            System.out.print("\nIle potworów chcesz pokonać w tej rundzie? ");
            int monstersCount = scanner.nextInt();

            for (int i = 1; i <= monstersCount && playerChar.isAlive() && playerChar.level < 20; i++) {
                Character enemy;
                if (playerChar.level + 1 >= 20 && i == monstersCount) {
                    enemy = new Boss("Boss przejściowy");
                } else {
                    enemy = new Monster("Potwór #" + i, 50, 10 + i * 2);
                }

                System.out.println("\n--- Walka " + i + " ---");

                while (enemy.isAlive() && anyTeamAlive(teamChars)) {
                    for (Attackable member : team) {
                        if (enemy.isAlive()) {
                            member.attack(enemy);
                        }
                    }
                    if (enemy.isAlive()) {
                        Character target = getRandomAliveCharacter(teamChars);
                        if (target != null) {
                            ((Monster) enemy).attack(target);
                            System.out.println(target.name + " otrzymał obrażenia, HP: " + target.hp);
                        }
                    }
                }

                if (!anyTeamAlive(teamChars)) {
                    System.out.println("Cała drużyna została pokonana...");
                    break;
                } else {
                    System.out.println(enemy.name + " został pokonany!");
                    for (Character c : teamChars) {
                        if (c.isAlive()) {
                            c.levelUp();
                            c.showStats();
                        }
                    }
                }
            }

            if (!anyTeamAlive(teamChars)) break;

            // Sprawdź, czy osiągnęliśmy kolejny próg poziomów na dodanie towarzysza
            while (nextCompanionIndex < levelsToAddCompanion.length &&
                    playerChar.level >= levelsToAddCompanion[nextCompanionIndex] &&
                    team.size() < 4) {

                System.out.println("\nOsiągnąłeś poziom " + levelsToAddCompanion[nextCompanionIndex] + "!");
                System.out.println("Możesz dodać do drużyny nowego towarzysza. Wybierz klasę:");
                System.out.println("1. Wojownik");
                System.out.println("2. Mag");
                System.out.println("3. Łucznik");
                System.out.print("Twój wybór: ");
                int companionChoice = scanner.nextInt();
                scanner.nextLine(); // pochłonięcie entera

                System.out.print("Podaj imię towarzysza: ");
                String companionName = scanner.nextLine();

                Attackable companion = null;
                switch (companionChoice) {
                    case 1 -> companion = new Warrior(companionName);
                    case 2 -> companion = new Mage(companionName);
                    case 3 -> companion = new Archer(companionName);
                    default -> {
                        System.out.println("Niepoprawny wybór towarzysza, pominięto dodanie.");
                        companion = null;
                    }
                }

                if (companion != null) {
                    team.add(companion);
                    teamChars.add((Character) companion);
                    System.out.println("Dodano " + companionName + " do drużyny!");
                }

                nextCompanionIndex++;
            }

            // Leczenie całej drużyny
            System.out.println("\nCzy chcesz uleczyć całą drużynę? (tak/nie)");
            String healChoice = scanner.nextLine().toLowerCase();

            if (healChoice.equals("tak")) {
                int healAmount = 30;
                for (Character c : teamChars) {
                    if (c.isAlive()) {
                        c.hp += healAmount;
                        System.out.println(c.name + " został uleczony o " + healAmount + " HP.");
                        c.showStats();
                    }
                }
            }
        }

        // Walka z bossem od poziomu 20 i pełną drużyną
        if (playerChar.level >= 20 && team.size() == 4 && anyTeamAlive(teamChars)) {
            System.out.println("\nGratulacje! Osiągnąłeś poziom 20 i masz pełną drużynę!");
            System.out.println("Czas na walkę z Wielkim Bossem!");

            Character boss = new Boss("Wielki Boss");

            System.out.println("\n--- Walka z bossem ---");

            while (boss.isAlive() && anyTeamAlive(teamChars)) {
                for (Attackable member : team) {
                    if (boss.isAlive()) {
                        member.attack(boss);
                    }
                }
                if (boss.isAlive()) {
                    Character target = getRandomAliveCharacter(teamChars);
                    if (target != null) {
                        ((Boss) boss).attack(target);
                        System.out.println(target.name + " otrzymał obrażenia, HP: " + target.hp);
                    }
                }
            }

            if (!anyTeamAlive(teamChars)) {
                System.out.println("Cała drużyna została pokonana przez Bossa...");
            } else {
                System.out.println("Gratulacje! Pokonaliście Wielkiego Bossa i ukończyliście grę!");
                for (Character c : teamChars) {
                    if (c.isAlive()) {
                        c.levelUp();
                        c.showStats();
                    }
                }
            }
        } else if (playerChar.isAlive()) {
            System.out.println("\nNie osiągnąłeś jeszcze poziomu 20 lub nie masz pełnej drużyny (4 osoby), by walczyć z bossem.");
        }

        scanner.close();
    }

    private static boolean anyTeamAlive(List<Character> teamChars) {
        for (Character c : teamChars) {
            if (c.isAlive()) return true;
        }
        return false;
    }

    private static Character getRandomAliveCharacter(List<Character> teamChars) {
        List<Character> alive = new ArrayList<>();
        for (Character c : teamChars) {
            if (c.isAlive()) alive.add(c);
        }
        if (alive.isEmpty()) return null;
        int index = (int) (Math.random() * alive.size());
        return alive.get(index);
    }
}
