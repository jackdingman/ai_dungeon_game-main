package CHARACTER;
import java.util.Scanner;

public class CharacterCreation
{
    // === a factory that switches between constructor calls ===
    public Character characterFactory(String playerChoice)
    {
        Character player = null;
        switch (playerChoice.toLowerCase())
        {
            case "mage":
                player = new Character(20, 7, 5, 10, 3, playerChoice);
                break;
            case "priest":
                player = new Character(20,3,9,10,3, playerChoice);
                break;
            case "thief":
                player = new Character(20,10,7,3,5, playerChoice);
                break;
            case "warrior":
                player = new Character(20,5,8,2,10, playerChoice);
                break;
            default:
                player = characterBuilder(playerChoice);
                break;
        }

        return player;
    }

    // === generalized prompt for character Builder ===
    private <v> v getStats(String prompt)
    {
        System.out.println("set " + prompt + " :: ");
        if(prompt == "character class")
            return (v) new Scanner(System.in).nextLine();
        else
           return (v) Integer.valueOf(new Scanner(System.in).nextInt());

    }
    // === the character builder ===
    public Character characterBuilder(String playerChoice)
    {
        Character player = new Character();

        int health = getStats("health");
        player.setDexterity(getStats("dexterity"));
        player.setConstitution(getStats("constitution"));
        player.setHealth(health += player.getConstitution());
        player.setWillpower(getStats("willpower"));
        player.setStrength(getStats("strength"));

        System.out.println("Change Character Class <current ::" + playerChoice + "> y/n ::");
        char changeName = new Scanner(System.in).next().charAt(0);

        if (changeName == 'y' || changeName == 'Y')
            player.setCharSelect(getStats("character class"));
        else
            player.setCharSelect(playerChoice);

        return player;
    }

}
