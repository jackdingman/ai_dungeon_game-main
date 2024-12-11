package CHARACTER;
import java.util. Random;

public class Enemy {
    private String enemyName;
    private int health;
    private Attack[] attacks;
    private int damage;

    public Enemy(String enemyName, int health, int damage, Attack ... attacks) {
        this.enemyName = enemyName;
        this.damage = damage;
        this.health = health;
        this.attacks = attacks;
    }

    public String getEnemyName() {
        return enemyName;
    }
    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }

    public int enemyAttack(Character character){
        int randomNum = (int) (Math.random() * 3) + 1;
        Random random = new Random();
        int attackIndex = random.nextInt(attacks.length); // Randomly pick an attack
        Attack chosenAttack = attacks[attackIndex];

        int damage = chosenAttack.calculateDamage();
        //character.takeDamage(damage);
        System.out.println(enemyName + " uses " + chosenAttack.getName() + " for " + damage + " damage");
        return damage;
    }
    public void takeDamage(int damage){
        this.health -= damage;
        if(this.health < 0){
            this.health = 0;
        }
    }
    public boolean isAlive(){
        return this.health > 0;
    }

}
