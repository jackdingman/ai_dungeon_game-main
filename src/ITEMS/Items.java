package ITEMS;

public abstract class Items {
    String name;
    String description;

    public void SetName(String name) {this.name = name;}
    public void SetDescription(String description){this.description = description;}
    public String getName() { return name; }


    public abstract void SetStats();
    public abstract void SetPlayerBuffs();
}
