package MAP;

public interface MapLocation
{
    public static MapLocation[] mapLevels = new MapLocation[3];
    public void setDescription(String description);

    public void setNorthLocation();
    public void setSouthLocation();
    public void setEastLocation();
    public void setWestLocation();

    public void setTreasure();
    public void setEnemyCount();
    public void setBoss();
    public void setdifficulty();
    public void isStartingLocation();
    public void setReferenceToStart();

}
