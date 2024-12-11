package CHARACTER;

import java.util.Scanner;

//Fathia: constructor class that works as a "middle man" so Mage, Priest Thief, and Warrior extends to this class instead of directly to the CharacterStats class
public class Character {

    public int health;
    public int dexterity;
    public int constitution;
    public int willpower;
    public int strength;
    Inventory playerInventory;
    public String characterSelection;

    // == setters
    public void setDexterity(int dexterity) {this.dexterity = dexterity;}
    public void setWillpower(int willpower) {this.willpower = willpower;}
    public void setStrength(int strength) {this.strength = strength;}
    public void setCharSelect(String charSel){ characterSelection = charSel; }
    public void setHealth(int health) { this.health = health; }
    public void setConstitution(int constitution) {this.constitution = constitution;}

    // == getters
    public int getStrength(){return strength;}
    public int getHealth() {return health;}
    public int getDexterity() {return dexterity;}
    public int getConstitution(){return constitution;}
    public int getWillpower(){return willpower;}
    public String getCharSelect(){return characterSelection;}

    // == constructors
    public Character(int health, int dexterity, int constitution, int willpower, int strength, String charSel) {

        this.health = health;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.willpower = willpower;
        this.strength = strength;
        characterSelection = charSel;
        playerInventory = Inventory.inv.getFullInventory();

        health+= constitution;
    }
    public void attack(Enemy enemy) {
        if (enemy == null) {
            throw new IllegalArgumentException("Target enemy cannot be null.");
        }

        int damage = 0;
        switch (characterSelection.toLowerCase()) {
            case "mage":
                damage = willpower * 2 + (int)(Math.random() * 5); // Mages use magic power
                System.out.println(characterSelection + " casts a spell!");
                break;
            case "priest":
                damage = willpower + constitution; // Priests have balanced attacks
                System.out.println(characterSelection + " channels divine energy!");
                break;
            case "thief":
                damage = dexterity * 2 + (int)(Math.random() * 3); // Thieves are agile
                System.out.println(characterSelection + " strikes quickly!");
                break;
            case "warrior":
                damage = strength * 3; // Warriors are brute-force attackers
                System.out.println(characterSelection + " delivers a heavy blow!");
                break;
            default:
                damage = 5; // Default damage for custom characters
                System.out.println(characterSelection + " attacks!");
        }

        // Apply damage to the enemy
        enemy.takeDamage(damage);
        System.out.println("Enemy " + enemy.getEnemyName() + " takes " + damage + " damage. Remaining health: " + enemy.getHealth());
    }
    public Character (String characterChoice)
    {
        health = 0;
        dexterity =0;
        constitution =0;
        willpower = 0;
        strength = 0;
        playerInventory = Inventory.inv.getFullInventory();
        characterSelection=characterChoice;
    }

    public Character ()
    {
        health = 0;
        dexterity =0;
        constitution =0;
        willpower = 0;
        strength = 0;
        characterSelection="";
        playerInventory = Inventory.inv.getFullInventory();
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if(this.health < 0) {this.health = 0;}
    }

    public boolean isAlive(){
        return this.health > 0;
    }

    public String chooseAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your action:");
        System.out.println("1. Attack");
        System.out.println("2. Dodge");
        System.out.println("3. Magic");
        System.out.println("4. Flee");
        System.out.print("Enter the number of your choice: ");

        String input = scanner.nextLine();
        switch (input) {
            case "1":
                return "attack";
            case "2":
                return "dodge";
            case "3":
                return "magic";
            case "4":
                return "flee";
            default:
                System.out.println("Invalid choice. Defaulting to 'attack'.");
                return "attack";
        }
    }

    @Override
    public String toString() {

        String characterInfo = "character class : " + characterSelection;
        characterInfo += " | health : "+health+" | dexterity : " + dexterity;
        characterInfo += " | constitution : " + constitution + " | willpower : " + willpower;
        characterInfo += " | strength : " + strength;

        return characterInfo;
    }
}
