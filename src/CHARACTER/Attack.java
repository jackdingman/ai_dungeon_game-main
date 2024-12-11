package CHARACTER;

public class Attack {
    private String name;
    private int minDamage;
    private int maxDamage;

    public Attack(String name, int minDamage, int maxDamage) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }
    public int calculateDamage() {
        return minDamage + (int)(Math.random() * (maxDamage-minDamage) + 1);
    }
    public String getName() {
        return name;
    }
}
