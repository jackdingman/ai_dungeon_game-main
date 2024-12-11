package CHARACTER;


import java.util.Random;

public class Battle {
    private Character player;
    private Enemy enemy;

    // Constructor
    public Battle(Character player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    // Start the battle
    public void start() {
        while (player.isAlive() && enemy.isAlive()) {
            //displayCombatOptions();
            String action = player.chooseAction();
            handleAction(action);
            // Enemy's turn
            if(enemy.isAlive()) {
                System.out.println(enemy.getEnemyName() + "'s turn!");
                int damage = enemy.enemyAttack(player);
                player.takeDamage(damage);
            }
        }
        endBattle();
        /*System.out.println("A battle begins!");
        System.out.println(player.getCharSelect() + " vs " + enemy.getEnemyName());
        System.out.println("------------------------------");

        // Turn-based combat
        while (player.isAlive() && enemy.isAlive()) {
            // Player's turn
            System.out.println(player.getCharSelect() + "'s turn!");
            player.attack(enemy);

            // Check if the enemy is defeated
            if (!enemy.isAlive()) {
                System.out.println(enemy.getEnemyName() + " has been defeated!");
                break;
            }

            // Enemy's turn
            System.out.println(enemy.getEnemyName() + "'s turn!");
            enemy.enemyAttack(player);

            // Check if the player is defeated
            if (!player.isAlive()) {
                System.out.println(player.getCharSelect() + " has been defeated! Game Over.");
                break;
            }

            System.out.println("------------------------------");
        }

        System.out.println("Battle ends!");*/
    }
    private void displayCombatOptions(){
        System.out.println("Choose your Action: \n");
        System.out.println("1. Attack \n");
        System.out.println("2. Dodge \n");
        System.out.println("3. Magic \n");
        System.out.println("3. Run \n");

    }
    private void handleAction(String action) {
        switch (action.toLowerCase()) {
            case "attack":
                attack();
                break;
            case "dodge":
                dodge();
                break;
            case "magic":
                //magic();
                break;
            case "flee":
                flee();
                break;
            default:
                System.out.println("Invalid action.");
                break;
        }
    }

    private void attack() {

        Random rand = new Random();
        // Calculate if the attack hits
        int attackRoll = rand.nextInt(20) + player.getDexterity();
        int enemyDefense = 0;

        if (attackRoll > enemyDefense) {
            //int damage = player.getWeapon().getDamage() + player.getStrength();
            int damage = player.getStrength();
            enemy.takeDamage(damage);
            System.out.println("You hit the enemy for " + damage + " damage.");
        } else {
            System.out.println("Your attack missed!");
        }
    }

    private void dodge() {
        Random rand = new Random();
        // Calculate dodge chance
        int dodgeRoll = rand.nextInt(20) + player.getDexterity();
        int enemyDamage = enemy.enemyAttack(player);
        int enemyAttack = rand.nextInt(20) + enemyDamage;


        if (dodgeRoll > enemyAttack) {
            System.out.println("You successfully dodged the enemy's attack!");
        } else {
            System.out.println("You failed to dodge.");
            //System.out.println(enemy.getEnemyName() + " uses " + chosenAttack.getName() + " for " + damage + " damage!");
            int damage = enemyDamage;//enemy.getDamage();
            player.takeDamage(damage);
            System.out.println("You took " + damage + " damage.");
        }
    }

    /*private void magic() {
        // Cast a random spell from the magic list
        Magic spell = player.chooseMagicSpell();
        if (spell != null) {
            int spellDamage = spell.cast();
            enemy.takeDamage(spellDamage);
            System.out.println("You cast " + spell.getName() + " dealing " + spellDamage + " damage to the enemy.");
        } else {
            System.out.println("You don't have a magic spell equipped.");
        }
    }*/

    private void flee() {
        Random rand = new Random();
        // Flee if the player succeeds
        int fleeRoll = rand.nextInt(20) + player.getDexterity();
        if (fleeRoll >= enemy.getHealth()) {
            System.out.println("You successfully fled the battle.");
            // Player returns to the previous room or node

        } else {
            System.out.println("You failed to flee.");
            int damage = enemy.getDamage();
            player.takeDamage(damage);
            System.out.println("You took " + damage + " damage.");
        }
    }

    private void endBattle() {
        if (!player.isAlive()) {
            System.out.println("You have been defeated.");
        } else if (!enemy.isAlive()) {
            System.out.println("You defeated the enemy!");
            // Continue with the story or give the player options
        }
    }
}
