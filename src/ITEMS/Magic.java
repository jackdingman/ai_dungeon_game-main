package ITEMS;

import java.util.HashMap;
import CHARACTER.Character;

public class Magic {

    String name;

    public String getName(){return name;}

    private static HashMap<String, HashMap<Integer, HashMap<String, String>>> magic = new HashMap<>();

    public static HashMap<String, HashMap<Integer, HashMap<String, String>>> getMagicSpells() {
        return magic;
    }

    public static class MagicCreation {

        public MagicCreation(Character charac) {
            // Initialize the magic spells for Wizard
            HashMap<Integer, HashMap<String, String>> wizardSpells = new HashMap<>();

            // Level 1 spells for Wizard
            HashMap<String, String> level1WizardSpells = new HashMap<>();
            level1WizardSpells.put("Arcane bolt", "deals 10 damage");
            level1WizardSpells.put("Spark", "deals 7 damage and applies burning (1-4 damage per turn)");
            level1WizardSpells.put("Acid splash", "deals 5 damage and decreases enemy armor");
            level1WizardSpells.put("Shield", "acts like a successful dodge");

            // Level 2 spells for Wizard
            HashMap<String, String> level2WizardSpells = new HashMap<>();
            level2WizardSpells.put("Arcane blast", "deals 15 damage");
            level2WizardSpells.put("Flame spray", "deals 12 damage and applies burning");
            level2WizardSpells.put("Poison dart", "Deals 10 damage and applies poison");
            level2WizardSpells.put("Cleanse", "removes all ailments");

            // Level 3 spells for Wizard
            HashMap<String, String> level3WizardSpells = new HashMap<>();
            level3WizardSpells.put("Lightning bolt", "deals 20 damage");
            level3WizardSpells.put("Fireball", "deals 17 damage and applies burning");
            level3WizardSpells.put("Bug swarm", "deals 15 damage and applies bleeding");
            level3WizardSpells.put("Enchant weapon", "adds 10 damage to weapon");

            // Add Wizard spells to the main map
            wizardSpells.put(1, level1WizardSpells);
            wizardSpells.put(2, level2WizardSpells);
            wizardSpells.put(3, level3WizardSpells);
           // magicSpells.put("Wizard", wizardSpells);

            // Initialize the magic spells for Priest
            HashMap<Integer, HashMap<String, String>> priestSpells = new HashMap<>();

            // Level 1 spells for Priest
            HashMap<String, String> level1PriestSpells = new HashMap<>();
            level1PriestSpells.put("Lesser heal", "restore 3 HP");
            level1PriestSpells.put("Holy bolt", "deals 10 damage");
            level1PriestSpells.put("Bless weapon", "adds 5 damage to your weapon");
            level1PriestSpells.put("Pray", "acts like a successful dodge");

            // Level 2 spells for Priest
            HashMap<String, String> level2PriestSpells = new HashMap<>();
            level2PriestSpells.put("Heal", "restore 5 HP");
            level2PriestSpells.put("Holy lance", "Deals 15 damage");
            level2PriestSpells.put("Shield of faith", "increase defense");
            level2PriestSpells.put("Cure", "removes status effects");

            // Level 3 spells for Priest
            HashMap<String, String> level3PriestSpells = new HashMap<>();
            level3PriestSpells.put("Greater Heal", "restores 15 HP");
            level3PriestSpells.put("Smite", "Deals 20 damage");
            level3PriestSpells.put("Sanctify weapon", "adds 10 damage to weapon");

            // Add Priest spells to the main map
            priestSpells.put(1, level1PriestSpells);
            priestSpells.put(2, level2PriestSpells);
            priestSpells.put(3, level3PriestSpells);
            //magicSpells.put("Priest", priestSpells);
        }
    }


}
