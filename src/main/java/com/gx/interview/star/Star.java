package com.gx.interview.star;

/**
 * A star object represnts distance of the star from the Sun.
 */
public class Star {

    private String name;
    private long distance;

    public Star(String name, long distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public long getDistance() {
        return distance;
    }

}
