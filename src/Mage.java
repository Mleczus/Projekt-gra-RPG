public class Mage extends Character implements Attackable {
    public Mage(String name) {
        super(name, 60, 20);
    }

    public void attack(Character target) {
        System.out.println(name + " rzuca zaklęcie!");
        target.takeDamage(attackPower);
    }
}
