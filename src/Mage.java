public class Mage extends Character implements Attackable {
    public Mage(String imie){
        super(imie, 20, 1, 5);
    }

    @Override
    public void attack(Character target){
        System.out.println(imie + " rzucił zaklęcie!");
        target.dostawaneobrazenia(mocataku);
    }
}
