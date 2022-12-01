package com.gx.interview.star;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A class to work with {@link Star} collections.
 */
public class StarService {

    /**
     * The method accepts a collection of {@link Star} and checks if all Star's names are unique.
     *
     * @param stars unsorted collection of {@link Star} objects
     * @return true if there are no duplicates, otherwise false.
     * @throws RuntimeException
     */
    public boolean areNamesUnique(List<Star> stars) {
        for (int i = 0; i < stars.size(); i++) {
            for (int j = i+1; j < stars.size(); j++) {
                if(stars.get(i).getName().equals(stars.get(j).getName())){
                    return false;
                };
            }
        }
        return true;
    }

    /**
     * The method searches and returns the Stars closest to the Sun.
     *
     * @param stars unsorted collection of {@link Star} objects
     * @param size  number of Stars to return
     * @return collection of {@link Star} objects
     * @throws RuntimeException
     */
    public List<Star> findClosestStars(List<Star> stars, int size) {
        return stars.stream().sorted(Comparator.comparing(Star::getDistance)).limit(size).collect(Collectors.toList());
    }

    /**
     * It filters out the Stars with the name not matching the regular expression.
     *
     * @param stars             unsorted collection of {@link Star} objects
     * @param regExpr regular expression to match stars' names
     * @return collection of {@link Star} with the name matching the regular expression
     * @throws RuntimeException
     */
    public List<Star> filterByRegExpr(List<Star> stars, String regExpr) {
        return stars.stream().filter(s -> s.getName().matches(regExpr)).collect(Collectors.toList());
    }
}
