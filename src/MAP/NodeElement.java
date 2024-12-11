package MAP;
import CHARACTER.Enemy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NodeElement{
    public String locationName;                        //location used as an identifier for the node
    boolean locationVisited;                    //boolean for tracking whether the location has been visited yet
    boolean bossDefeated;                       //boolean for tracking whether a boss has been defeated within a node.
    NodeElement left, right, forward, backward; // for connections within the map
    String description;
    private Enemy monster;

    public NodeElement(String locationName, Enemy monster){
        this.locationName = locationName;
        this.locationVisited = false;
        this.bossDefeated = false;
        this.description = description;
        this.monster = monster;
    }
    public void locationDescription(){
    //for descriptions of location
        if(locationName=="Fork in the Road"){
            System.out.println("The dirt path splits ahead, one side curving into a shadowed forest, the other winding uphill towards a vast and dark cave. A weathered signpost stands crooked, " +
                    "its arrows faded with age. The soft rustle of leaves and distant bird calls fill the air.");
        }
        if(locationName=="Forest Path"){
            System.out.println("Dappled sunlight filters through the dense canopy of ancient trees, casting shifting patterns on the mossy ground. The path is narrow and winding, bordered by ferns and tangled roots. The distant call of a crow echoes, and the earthy scent of damp wood fills your lungs.");
        }
        if(locationName=="Field"){
            System.out.println("An expanse of tall grass stretches endlessly, swaying gently in the breeze. Wildflowers in shades of violet and yellow pepper the landscape, and a lone tree stands in the distance, its branches reaching skyward. The horizon shimmers with a golden hue as the sun dips low.");
        }
        if(locationName=="Cliff"){
            System.out.println("Jagged rocks jut out over a sheer drop, the wind howling past in sharp bursts. Below, waves crash violently against the cliffs, spraying a fine mist into the air. The sky is a tapestry of clouds, shifting from steel gray to fiery orange as the sun sets.");
        }
        if(locationName=="Interior Cave"){
            System.out.println("The air is cool and damp, the faint drip of water echoing through the cavernous space. Stalagmites rise like jagged teeth from the floor, and bioluminescent fungi glow faintly along the walls, casting an eerie, pale light. Shadows dance with each flicker of your torch.");
        }
        if(locationName=="Cave Entrance"){
            System.out.println("Rough stone walls frame the dark maw of the cave, a faint chill emanating from within. Vines hang like curtains from the rocky overhang, and the ground is scattered with loose pebbles and patches of moss. The muffled sound of wind hints at unseen depths.");
        }
        if(locationName=="Drawbridge"){
            System.out.println("Chains groan as the drawbridge lowers over a murky moat. Its wooden planks creak underfoot, worn smooth from years of use. Beyond, the towering gates of the castle loom, their iron hinges rusted but still imposing. The scent of damp earth and old stone fills the air.");
        }
        if(locationName=="Mountain"){
            System.out.println("The peak looms above, shrouded in wisps of cloud. Sharp, craggy paths wind upward, flanked by sheer drops and patches of stubborn alpine flowers. The air grows thinner with every step, carrying the faint tang of snow and the distant cry of an eagle.");
        }
        if(locationName=="Cavern"){
            System.out.println("A vast chamber stretches out before you, its ceiling lost in darkness. Columns of stone rise like ancient monoliths, and a subterranean lake reflects the faint light of glowing crystals embedded in the walls. The air hums faintly, as if the cavern itself is alive.");
        }
        if(locationName=="Dirt Path"){
            System.out.println("The well-trodden path stretches ahead, flanked by wild hedges and the occasional marker stone. Dust rises with each step, the scent of dry earth mingling with the sweetness of blooming flowers. A warm breeze carries the distant sound of rushing water.");
        }
    }
    public String getLocationName(){
        return locationName;
    }

    public Enemy getMonster(){
        return monster;
    }

    public boolean hasMonster(){
        return monster != null;
    }

    public void clearMonster(){
        this.monster = null;
    }


    public String getAvailableDirections(){
        StringBuilder directions = new StringBuilder("Available directions: ");
        if (left != null) directions.append("left, ");
        if (right != null) directions.append("right, ");
        if (forward != null) directions.append("forward, ");
        directions.append("backward, ");
        if (directions.toString().endsWith(", ")) {
            directions.setLength(directions.length() - 2); // Remove trailing comma and space
        }

        return directions.toString();
    }

}
