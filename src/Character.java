public abstract class Character {
    protected String name;
    protected int hp;
    protected int level;
    protected int attackPower;

    public Character(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.level = 1;
        this.attackPower = attackPower;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    public void levelUp() {
        level++;
        hp += 10;
        attackPower += 5;
        System.out.println(name + " awansował na poziom " + level + "!");
    }

    public void showStats() {
        System.out.println("Postać: " + name + " | HP: " + hp + " | Poziom: " + level + " | Atak: " + attackPower);
    }
}
