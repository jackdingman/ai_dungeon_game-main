package MAP;

import CHARACTER.Attack;
import CHARACTER.Enemy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class TraversalLogic{
    NodeElement current;
    Deque<NodeElement> path = new ArrayDeque<>();
    Map<String, NodeElement> dungeonMap = new HashMap<>();

    public TraversalLogic(){

        Enemy skeletonWarrior = new Enemy("Skeleton Warrior", 30, 0, new Attack("Longsword Melee Attack", 7, 7), new Attack("Spike Ram", 8, 10));
        Enemy slime = new Enemy("Slime", 10, 0, new Attack("Melee Attack", 5,5), new Attack("Poison ooze", 4, 8));
        Enemy snowGolem = new Enemy("Snow Golem", 30, 0,  new Attack("Snow Mace", 5,10), new Attack("Ball of Fury", 10, 15));

        NodeElement beginning = new NodeElement("Fork in the Road", null);
        NodeElement forestPath = new NodeElement("Forest Path", null);
        NodeElement field = new NodeElement("Field", null);
        NodeElement cliff = new NodeElement("Cliff", null);
        NodeElement interiorCave = new NodeElement("Interior Cave", skeletonWarrior);
        NodeElement caveEntrance = new NodeElement("Cave Entrance", null);
        NodeElement drawbridge = new NodeElement("Drawbridge", slime);
        NodeElement mountain = new NodeElement("Mountain", snowGolem);
        NodeElement cavern = new NodeElement("Cavern", null);
        NodeElement dirtPath = new NodeElement("Dirt Path", null);

        dungeonMap.put("Forest Path", forestPath);
        dungeonMap.put("Field", field);
        dungeonMap.put("Cliff", cliff);
        dungeonMap.put("Cave Entrance", caveEntrance);
        dungeonMap.put("Drawbridge", drawbridge);
        dungeonMap.put("Wizard's Lair", mountain);

        beginning.left = caveEntrance; //from fork to woods
        //beginning.forward = caveEntrance; // from fork to castle
        beginning.right = forestPath;

        //movement from hole
        //hole.backward = beginning;

        //movement from cave entrance
        caveEntrance.left = drawbridge;
        caveEntrance.forward = interiorCave;
        caveEntrance.right = cliff;
        //caveEntrance.backward = beginning;

        //movement from forest path
        forestPath.left = cliff;
        forestPath.right = field;

        //movement from Drawbridge
        drawbridge.left = mountain;
        drawbridge.right = cavern;
        //drawbridge.backward = caveEntrance;

        //movement from Interior Cave
        interiorCave.left = drawbridge;
        interiorCave.right = cliff;
        //interiorCave.backward; = caveEntrance;

        //movement from cliff
        cliff.left = caveEntrance;
        cliff.right = interiorCave;

        //movement from field
        field.forward = dirtPath;

        current = beginning;
        path.push(current);

    }

    public void move(String direction) { // Method to move to a new node in the specified direction

        NodeElement nextNode;

        if (direction.equals("backward")) { //BACKWARD IS NOT BEING CALLED WITHIN MOVE METHOD
            // Handle backward movement
            if (current.backward != null) { //can't be null, or player would be exiting the map
                nextNode = current.backward;
            } else {
                System.out.println("No way to move backward from here.");
                return;
            }
        } else {
            // Handle directions other than backwards
            nextNode = switch (direction) {
                case "left" -> current.left;
                case "right" -> current.right;
                case "forward" -> current.forward;
                default -> null; // If the direction is invalid, nextNode is null
            };
        }

        // Check if the chosen direction is valid
        if (nextNode != null) {
            nextNode.backward = current; // Dynamically set the backward reference for the next node
            path.push(current);          // Push current node onto the Deque before moving
            current = nextNode;          // Update the current node to the new location
            current.locationVisited = true;  // Mark the new location as visited
            System.out.println("Moved to: " + current.locationName); // Print the new location
        } else {
            System.out.println("No path in that direction."); // Print if there's no path
        }
    }

    // Method to move back to the previous node
    public void backward() {
        // Check for previous node to go back to (Deque size > 1)
        if (path.size() > 1) {
            current = path.peek(); // Peek at the top of the Deque for the previous node
            System.out.println("Backtracked to: " + current.locationName); // Print the backtracked location
            path.pop(); //remove node for new current
        } else {
            System.out.println("You're at the starting point and can't go back further."); //print if you cannot go back anymore

        }
    }

    public NodeElement getCurrent() { //retrieves current node
        return current;
    }

}