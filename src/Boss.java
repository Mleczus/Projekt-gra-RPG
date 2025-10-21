public class Boss extends Character {
    public Boss(String imie, int hp, int level, int mocataku){
        super(imie,hp,level,mocataku);
    }

    public void attack(Character target){
        System.out.println(imie + " zadał potęrzny cios bohaterowi!");
        target.dostawaneobrazenia(mocataku);
    }
}
