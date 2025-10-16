public class Monster extends Character {
    public Monster(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    public void attack(Character target) {
        System.out.println(name + " atakuje bohatera!");
        target.takeDamage(attackPower);
    }
}
