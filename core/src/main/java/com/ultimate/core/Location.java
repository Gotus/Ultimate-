package com.ultimate.core;

import com.ultimate.core.Size;

/**
 * Created by Gotus on 30.07.2017.
 */
public abstract class Location {

    protected String name;
    protected int length;
    protected int height;
    protected int[] cells;

    abstract void createLocationArray(int length, int height);
    abstract void createLocationArray(Size size);
}
