package com.gx.interview.star;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class StarServiceTest {

    static List<Star> testStars;

    @BeforeClass
    public static void beforeClass() throws IOException {

        // prepare test file with 10M stars
        // format: <<star_name>>:<<distance to Sun>>
        List<Integer> numbers = IntStream.range(1, 10000)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);

        testStars = numbers.stream()
                .map(i -> new Star("STAR_" + i, i))
                .collect(Collectors.toList());
    }

    @Test
    public void areNamesUniqueTest() throws IOException {
        assertTrue(new StarService().areNamesUnique(testStars));

        testStars.add(new Star("STAR_100", 100));
        assertFalse(new StarService().areNamesUnique(testStars));
    }

    @Test
    public void testTop3() throws IOException {
        List<Star> closestStars = new StarService().findClosestStars(testStars, 3);
        assertEquals(3, closestStars.size());
        assertEquals(new Star("STAR_1", 1l), closestStars.get(0));
        assertEquals(new Star("STAR_2", 2l), closestStars.get(1));
        assertEquals(new Star("STAR_3", 3l), closestStars.get(2));
    }

    @Test
    public void filterStars() throws IOException {
        List<Star> filteredStars = new StarService().filterByRegExpr(testStars, "[A-Z]+_[0-9]{1}");
        assertEquals(9, filteredStars.size());
        filteredStars.forEach(s -> assertTrue(s.getDistance() < 10));
        filteredStars = new StarService().filterByRegExpr(testStars, "[A-Z]+_1[0-9]{1}");
        assertEquals(10, filteredStars.size());
        filteredStars.forEach(s -> assertTrue(s.getDistance() > 9 && s.getDistance() < 20));
    }
}
