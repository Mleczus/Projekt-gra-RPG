public class Archer extends Character implements Attackable {
    public Archer(String imie){
        super(imie, 15, 1, 4);
    }

    public void attack(Character target){
        System.out.println(imie + " strzela z łuku!");
        target.dostawaneobrazenia(mocataku);
    }
}
