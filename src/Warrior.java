public class Warrior extends Character implements Attackable{
    public Warrior(String imie){
        super(imie, 100, 1, 8);
    }

    public void attack(Character target){
        System.out.println(imie + " uderza mieczem!");
        target.dostawaneobrazenia(mocataku);
    }
}
