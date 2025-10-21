public class Monster extends Character {
    public Monster(String imie, int hp, int level, int mocataku){
        super(imie,hp,1,mocataku);
    }

    public void attack(Character target){
        System.out.println(imie + " atakuje bohatera!");
        target.dostawaneobrazenia(mocataku);
    }
}
