public class graRPG {
    public static void main(String[] args) {
        Warrior w = new Warrior("Kratos", 20, 99);
        Mage m = new Mage("Gandalf", 15, 80);
        Archer a = new Archer("Legolas", 12, 90);
        Monster o = new Monster("Minion", 4, 60);
        Boss b = new Boss("Cronos", 60, 200);

        System.out.print("HEROES: \n");
        System.out.print(w);
        System.out.println(m);
        System.out.println(a);
        System.out.println("MONSTERS: \n");
        System.out.print(o);
        System.out.print("BOSS: \n");
        System.out.print(b);

        }
    }