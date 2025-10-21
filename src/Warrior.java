public class Warrior extends Character implements Attackable{
    public Warrior(String imie){
        super(imie, 25, 1, 7);
    }

    public void attack(Character target){
        System.out.println(imie + " uderza mieczem!");
        target.dostawaneobrazenia(mocataku);
    }
}
