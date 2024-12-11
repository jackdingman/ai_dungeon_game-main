package MAP;

public class forest implements MapLocation {

    boolean isStarting;
    boolean hasBoss;
    boolean hasTreasure;
    int enemyCount;
    int difficultyLevel;
    MapLocation north;
    MapLocation east;
    MapLocation south;
    MapLocation west;

    forest()
    {




    }

    @Override
    public void setDescription(String description) {}
    @Override
    public void setNorthLocation() {}
    @Override
    public void setSouthLocation() {}
    @Override
    public void setEastLocation() {}
    @Override
    public void setWestLocation() {}
    @Override
    public void setTreasure() {}
    @Override
    public void setEnemyCount() {}
    @Override
    public void setBoss() {}
    @Override
    public void setdifficulty() {}
    @Override
    public void isStartingLocation() {}
    @Override
    public void setReferenceToStart() {}
}
