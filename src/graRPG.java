import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("|WITAJ W GRZE RPG|");
        System.out.println("Wybierz postać:");
        System.out.println("1.Wojownik");
        System.out.println("2.Mag");
        System.out.println("3.Łucznik");
        System.out.print("Twój wybór: ");

        int wybor = sc.nextInt();
        sc.nextLine();
        System.out.print("Podaj imię postaci: ");
        String imie = sc.nextLine();

        Character bohater = null;

        switch(wybor){
            case 1:
                bohater = new Warrior(imie);
                break;
            case 2:
                bohater = new Mage(imie);
                break;
            case 3:
                bohater = new Archer(imie);
                break;
            default:
                System.out.println("Wybrano złego bohatera!");
                break;
        }
        bohater.pokazStatystyki();


        System.out.println("\n--- ROZPOCZYNASZ PRZYGODĘ ---");
        System.out.println("Wybierz walkę:");
        System.out.println("1.Potwór");
        System.out.println("2.Boss");
        System.out.println("3.Ultra Mega Hard Boss");
        System.out.print("Twój wybór: ");
        int wybor2 = sc.nextInt();
        sc.nextLine();
        switch(wybor2){
            case 1:
                Monster m = new Monster("Horda Minionów", 50, 1, 5);
                m.pokazStatystyki();
                break;
            case 2:
                Boss b = new Boss("Smok Kresu", 100, 4, 25);
                b.pokazStatystyki();
                break;
            case 3:
                UltraMegaHardBoss u = new UltraMegaHardBoss("Poseidon", 250, 10, 35);
                u.pokazStatystyki();
                break;
            default:
                System.out.println("Wybrano złego złoczyńce!");
                break;
        }

        if(wybor == 1) {
            System.out.println("Ile chcesz pokonać potworów");
            int iloscWalk = sc.nextInt();
            for(int i = 0; i < iloscWalk; i++){
                System.out.println("\n--- WALKA Z POTWOREM ---");
                Monster monster = new Monster("Horda Minionów", 50, 1, 5);

                while (bohater.czyZyje() && monster.czyZyje()) {
                    bohater.attack(monster);
                    if (monster.czyZyje()) {
                        monster.attack(bohater);
                    }
                    System.out.println(bohater.imie + " ma teraz HP: " + bohater.hp);
                    System.out.println(monster.imie + " ma teraz HP: " + monster.hp);
                }

                if (bohater.czyZyje()) {
                    System.out.println("\nWygrałeś walkę!");
                    bohater.levelUp();
                } else {
                    System.out.println("\nZostałeś pokonany...");
                }

                sc.close();
            }
            }
        }
    }

