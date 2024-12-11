package CHARACTER;
import ITEMS.*;

import java.util.Scanner;

public class Inventory {

    static Inventory inv = new Inventory();
    private static int HeldWeapons;
    private static int HeldArmor;
    private static int HeldMagic;
    static Items[] weaponList;
    static Items[] armorList;
    static Magic[] magicList;

    // === add and remove from inventory ===
    public <T> void addToInventory(T someItem)
    {
        // -- add to armor
        if(someItem instanceof Armor)
        {
            addTo(armorList, HeldArmor, someItem, "Armor");
        }
        // add to weapons
        else if(someItem instanceof weapons)
        {
            addTo(weaponList, HeldWeapons, someItem, "Weapons");
        }
        // add to Magic message
        else if(someItem instanceof Magic)
        {
            addTo(magicList, HeldMagic, someItem, "Magic");
        }
    }
    public void removeFromInventory(String listChosen)
    {
        switch(listChosen.toLowerCase())
        {
            case "armor":
                removeFrom(armorList);
                HeldArmor--;
                break;
            case "weapons":
                removeFrom(weaponList);
                HeldWeapons--;
                break;
            case "magic":
                removeFrom(magicList);
                HeldMagic--;
                break;
            default:
                System.out.println("Invalid list chosen");
                break;
        }
    }
    private <T> void removeFrom(T[] someThing)
    {
        int Index = 0;

        // displays items
        for(T items : someThing)
        {
            System.out.println((Index+1) + ".) " + items.toString());
            Index++;
        }

        System.out.println("# of item you'll get rid of");
        int choiceIndex = (new Scanner(System.in).nextInt()) -1;

        // bubbles chosen item to the end of the list and removes
        for(int i = choiceIndex; i < someThing.length - 1; i++)
        {
            T temp = someThing[i];
            someThing[i] = someThing[i + 1];
            someThing[i+ 1] = temp;
        }

        someThing[someThing.length - 1] = null;
    }
    private <T> void addTo(T[] SomeThing, int currentIndex, T addedItem, String container)
    {
        int MMO = (SomeThing.length) - 1; // max - 1
        if(currentIndex == MMO) // subInventory too full
        {
            System.out.println("Too full, remove item from :: " + container);
        }
        else if(currentIndex < MMO) // enough space to add new item
        {
            SomeThing[currentIndex] = addedItem;
            currentIndex++;
        }
        else {

        }
    }

    // === returns the inventory obj ===
    public Inventory getFullInventory(){return inv;};

    // === the multiple sub inventories ===
    public Items[] getWeaponList(){return weaponList;}
    public Items[] getArmorList(){return armorList;}
    public Magic[] getMagicList(){return magicList;}

    // === display inventories ===

    public void ViewInventory(String invSpec)
    {
        switch (invSpec.toLowerCase())
        {
            case "weapons":
                ViewSubInventory(weaponList, "weapons");
                break;
            case "armor":
                ViewSubInventory(armorList, "armor");
                break;
            case "magic":
                ViewSubInventory(magicList, "magic");
                break;
            default:
                ViewInventory();
                break;
        }
    }

    private <T> void ViewSubInventory(T[] objArray, String key)
    {
        int loopCounter = 1;
        System.out.println("your " + key +" :: ");
     for(T obj : objArray){
         System.out.println(loopCounter + " .) " + obj.getClass().getName());
         loopCounter++;
     }

    }
    private void ViewInventory()
    {
        System.out.println("your full inventory is :: ");

        System.out.print("armor :: ");
        for(Items armor : armorList)
        {
            System.out.print(armor.getName() + " | ");
        }
        System.out.print("\nWeapons :: ");
        for(Items weapon : weaponList)
        {
            System.out.print(weapon.getName() + " | ");
        }
        System.out.print("\nMagic :: ");
        for(Magic magic : magicList)
        {
            System.out.print(magic.getName() + " | ");
        }
        System.out.println();
    }


    // === only 1 instance of inventory ===
    private Inventory()
    {
        HeldWeapons = 0;
        HeldArmor = 0;
        HeldMagic = 0;

        weaponList = new Items[4];
        armorList = new Items[2];
        magicList = new Magic[3];
    }


}
