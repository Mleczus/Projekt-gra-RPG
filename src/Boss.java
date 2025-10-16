public class Boss extends Monster {
    public Boss(String name) {
        super(name, 150, 25);
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " wykonuje potężny atak!");
        target.takeDamage(attackPower + 10);
    }
}
