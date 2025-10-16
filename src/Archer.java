public class Archer extends Character implements Attackable {
    public Archer(String name) {
        super(name, 70, 15);
    }

    public void attack(Character target) {
        System.out.println(name + " strzela z łuku!");
        target.takeDamage(attackPower);
    }
}
