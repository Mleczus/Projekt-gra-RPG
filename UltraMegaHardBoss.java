public class UltraMegaHardBoss extends Character {
    public UltraMegaHardBoss(String imie, int hp, int level, int mocataku){
        super(imie,hp,level,mocataku);
    }

    public void attack(Character target){
        System.out.println(imie + " wykonał wielkie uderzenie falą!");
        target.dostawaneobrazenia(mocataku);
    }
}
