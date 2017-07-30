package Gotus.com;

/**
 * Created by Gotus on 30.07.2017.
 */
public abstract class Location {

    protected String name;
    protected int length;
    protected int height;
    protected int[] worldCells;

    abstract void createLocationArray(int length, int height);
}
