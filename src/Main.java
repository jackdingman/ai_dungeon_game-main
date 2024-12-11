/*import java.io.IOException;
import CHARACTER.*;
public class Main {
    public static void main(String[] args) throws IOException {
        CHARACTER.Character player = new CharacterCreation().characterFactory("thief");
        System.out.println(player.toString());

    }
}*/ //Original content within this .java file is above. Revisions I have made are below.

import java.io.IOException;
import java.util.Scanner;

import CHARACTER.*;
import MAP.*;
public class Main {

    public static void main(String[] args) {

        TraversalLogic game = new TraversalLogic(); // Initialize the game
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        String direction;

        /*CHARACTER.Character player = new CharacterCreation().characterFactory("thief");
            System.out.println(player.toString());*/

        singleLetterOutputter("Welcome to the Dungeon Crawler! \n");
        sleep(1500);
        singleLetterOutputter("A grand, ancient throne room. King Acacius, wise and regal, sits upon his majestic throne, his eyes gleaming with purpose. The air is heavy with anticipation as the adventurer enters.\n");
        singleLetterOutputter("KING ACACIUS: What is your name, adventurer? \n");
        sleep(1500);
        //String name = scanner.nextLine();
        String name = "Jack";
        singleLetterOutputter("The perils before you are unknown, ");
        singleLetterOutputter(name + ". ");
        singleLetterOutputter("Be careful and watch your back. " +
                "Please retrieve for me the Sword of Curonis, kept away for centuries on top of a mountain.\n" +
                "It is guarded by Vorthak the Fury, an ice elemental who is kept chained to the sword as a punishment from the Gods. \n");
        singleLetterOutputter("Let's take you to the armory to get outfitted.\n ");
        singleLetterOutputter("Please decide between the following character classes (mage, priest, thief, warrior):\n  ");

        //String characterClass = scanner.nextLine(); // character classification input

        CHARACTER.Character player = new CharacterCreation().characterFactory("mage");
        System.out.println(player.toString());


        //Output first story prompt
        //Output directional options - must be particular to node
        //User enters chosen direction - pushed current location on Deque
        //New story prompt
        //Output directions + ability to fight. To go directions other than backwards, you must fight.

        while (running) {
            NodeElement current = game.getCurrent();
            singleLetterOutputter("You are currently at: " + current.locationName + "\n");
            current.locationDescription(); // print description of area



            if (current.hasMonster()) {
                System.out.println("A monster is here! Prepare for battle!");

                // Start the battle
                Enemy monster = current.getMonster();  // Get the enemy associated with the node
                Battle battle = new Battle(player, monster);  // Initialize the battle
                battle.start();  // Start the battle

                // After the battle, the player can continue exploring or exit
                if (player.isAlive()) {
                    System.out.println("The battle is over. You can continue exploring.");
                    current.clearMonster();
                } else {
                    //System.out.println("You have been defeated. Game Over.");
                    running = false;  // End the game if the player dies
                    break; // breaks out of the loop, actually ends the game
                }
            }
            System.out.println(current.getAvailableDirections()); //movement options, particular to the node

            System.out.print("Enter a direction to move (or 'exit' to quit): ");
            direction = scanner.nextLine().trim().toLowerCase();
            System.out.println("\n");

            if (direction.equals("exit")) {
                running = false;
                System.out.println("Thanks for playing!");
            } else if (direction.equals("backward")) {
                game.backward();
            } else if (direction.equals("left") || direction.equals("right") || direction.equals("forward")) {
                game.move(direction);
            } else {
                System.out.println("Invalid direction. Try again.");
            }
        }
        scanner.close();

    }

    public static void sleep(Integer time) {
        try {
            // Pause execution for entered amount of milliseconds
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // Handle the exception if the thread is interrupted
            System.err.println("Sleep was interrupted!");
        }
    }

    public static void singleLetterOutputter(String entry) {

        char[] toArray = entry.toCharArray();

        for (char c : toArray) {
            System.out.print(c);
            sleep(0); //optimal 30 for game experience
        }

        //System.out.println();
    }
}