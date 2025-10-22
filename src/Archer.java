public class Archer extends Character implements Attackable {
    public Archer(String imie){
        super(imie, 80, 1, 8);
    }

    public void attack(Character target){
        System.out.println(imie + " strzela z łuku!");
        target.dostawaneobrazenia(mocataku);
    }
}
