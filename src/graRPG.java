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
        while(bohater.hp > 0){
        System.out.println("Wybierz walkę:");
        System.out.println("1.Potwór");
        System.out.println("2.Boss");
        System.out.println("3.Ultra Mega Hard Boss");
        System.out.print("Twój wybór: ");
        int wybor2 = sc.nextInt();
        sc.nextLine();
        switch(wybor2){
            case 1:
                Monster m = new Monster("Horda Minionów", 40, 1, 8);
                m.pokazStatystyki();
                break;
            case 2:
                Boss b = new Boss("Smok Kresu", 120, 4, 18);
                b.pokazStatystyki();
                break;
            case 3:
                UltraMegaHardBoss u = new UltraMegaHardBoss("Poseidon", 250, 10, 30);
                u.pokazStatystyki();
                break;
            default:
                System.out.println("Wybrano złego złoczyńce!");
                break;
        }

        if(wybor2 == 1) {
            System.out.println("Ile chcesz pokonać potworów");
            int iloscWalk = sc.nextInt();
            for (int i = 0; i < iloscWalk; i++) {
                System.out.println("\n--- WALKA Z POTWOREM ---");
                Monster monster = new Monster("Horda Minionów", 40, 1, 8);

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
                    bohater.pokazStatystyki();
                } else {
                    System.out.println("\nZostałeś pokonany...");
                    sc.close();
                    return;
                }
            }
        } else if (wybor2 == 2) {
            if(bohater.level >= 10){
            System.out.println("\"\\n--- WALKA Z BOSSEM ---\"");

            Boss boss = new Boss("Smok Kresu", 200, 4, 18);

            //TRYB NORMALNY
                while (bohater.czyZyje() && boss.czyZyje()) {
                    bohater.attack(boss);
                    if (boss.czyZyje()) {
                        boss.attack(bohater);
                    }

                    if(boss.hp <= 100 && !boss.furia){
                        System.out.println("| BOSS PRZECHODZI W TRYB FURII |");
                        boss.mocataku *= 2;
                        boss.hp += 10;
                        boss.furia = true;
                    }

                    System.out.println(bohater.imie + " ma teraz HP: " + bohater.hp);
                    System.out.println(boss.imie + " ma teraz HP: " + boss.hp);

                }

                if (bohater.czyZyje()) {
                    System.out.println("\nWygrałeś walkę z Bossem, ale to jeszcze nie koniec...");
                    bohater.levelUp();
                    bohater.pokazStatystyki();
                } else {
                    System.out.println("\nZostałeś pokonany...");
                    sc.close();
                    return;
                }

        }
        } else if (wybor2 == 3) {
            if(bohater.level >= 20){
                System.out.println("\"\\n--- WALKA Z ULTRA MEGA HARD BOSSEM ---\"");

                UltraMegaHardBoss ultraMegaHardBoss = new UltraMegaHardBoss("Poseidon", 500, 10, 50);

                //TRYB NORMALNY
                while (bohater.czyZyje() && ultraMegaHardBoss.czyZyje()) {
                    bohater.attack(ultraMegaHardBoss);
                    if (ultraMegaHardBoss.czyZyje()) {
                        ultraMegaHardBoss.attack(bohater);
                    }

                    //TRYB FURII
                    if(ultraMegaHardBoss.hp <= 350 && !ultraMegaHardBoss.furia){
                        System.out.println("| BOSS PRZECHODZI W TRYB FURII |");
                        ultraMegaHardBoss.mocataku *= 2;
                        ultraMegaHardBoss.hp += 10;
                        ultraMegaHardBoss.furia = true;
                    }

                    //TRYB FURII
                    if(ultraMegaHardBoss.hp <= 250 && !ultraMegaHardBoss.ultraRage){
                        System.out.println("| BOSS PRZECHODZI W TRYB ULTRA RAGE |");
                        ultraMegaHardBoss.mocataku *= 3;
                        ultraMegaHardBoss.hp += 20;
                        ultraMegaHardBoss.ultraRage = true;
                    }

                    System.out.println(bohater.imie + " ma teraz HP: " + bohater.hp);
                    System.out.println(ultraMegaHardBoss.imie + " ma teraz HP: " + ultraMegaHardBoss.hp);

                }

                if (bohater.czyZyje()) {
                    System.out.println("\nWygrałeś walkę z Bossem, ale to jeszcze nie koniec...");
                    bohater.levelUp();
                    bohater.pokazStatystyki();
                } else {
                    System.out.println("\nZostałeś pokonany...");
                    sc.close();
                    return;
                }

            }
        }

            System.out.println("| ULECZ SIĘ PRZED  KOLEJNĄ WALKĄ |");
            System.out.println("Czy chcesz się uleczyć? ");
            System.out.println("1.Tak");
            System.out.println("2.Nie");
            sc.nextLine();
            System.out.println("Twój wybór: ");
            int wybor3 = sc.nextInt();

            switch (wybor3) {
                case 1:
                    System.out.println("Uleczyłeś się!");
                    bohater.Leczenie();
                    bohater.pokazStatystyki();
                    break;
                case 2:
                    System.out.println("Nie uleczyłeś się!");
                    bohater.pokazStatystyki();
                    break;
            }

            System.out.println("Chcesz walczyć dalej?");
            System.out.println("1.Tak");
            System.out.println("2.Nie");
            int wybor4 = sc.nextInt();

            if (wybor4 == 2) {
                System.out.println(imie + " się poddał!");
                sc.close();
            }
        }
        }
    }


