public class Mage extends Character implements Attackable {
    public Mage(String imie){
        super(imie, 70, 1, 8);
    }

    @Override
    public void attack(Character target){
        System.out.println(imie + " rzucił zaklęcie!");
        target.dostawaneobrazenia(mocataku);
    }
}
