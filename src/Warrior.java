public class Warrior extends Character implements Attackable {
    public Warrior(String name) {
        super(name, 100, 10);
    }

    public void attack(Character target) {
        System.out.println(name + " atakuje mieczem!");
        target.takeDamage(attackPower);
    }
}
