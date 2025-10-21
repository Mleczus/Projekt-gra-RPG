public abstract class Character {
    protected String imie;
    protected int hp;
    protected int level;
    protected int mocataku;

    public Character(String imie, int hp, int level, int mocataku) {
        this.imie = imie;
        this.hp = hp;
        this.level = level;
        this.mocataku = mocataku;
    }

    public void levelUp(){
        level++;
        hp += 20;
        mocataku += 15;
        System.out.println("LEVEL UP NA POZIOM: " + level);
    }

    public void pokazStatystyki(){
        System.out.println("STATYSTYKI: | " + imie + " | " + "HP: " + hp + " | " + "LVL: " + level + " | " + "MOC: " + mocataku + " | " );
    }

    public void dostawaneobrazenia(int obrazenia){
        hp -= obrazenia;
        if(hp <= 0){
            System.out.println("Nie żyjesz. | PRZEGRANA |");
        }
    }

    public boolean czyZyje(){
        return hp > 0;
    }

    public void Leczenie(){
        hp += 20;
        mocataku += 2;
        levelUp();
    }



    public abstract void attack(Character target); // Abstrakcyjna metoda — każda klasa musi ją zaimplementować
}
