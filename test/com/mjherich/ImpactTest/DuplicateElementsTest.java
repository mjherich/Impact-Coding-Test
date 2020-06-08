package com.mjherich.ImpactTest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateElementsTest {

    @Test
    public void FindDuplicateElementsTest() {
        // Test 1
        List<Integer> list1 = Arrays.asList(1,22,1,3,3,4,5,6,7,7,99,99,1,98,99);
        DuplicateElements d1 = new DuplicateElements(list1);
        List<Integer> expected1 = Arrays.asList(1,3,7,99);
        assertEquals(expected1, d1.getElements());

        // Test 2 (no duplicates)
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        DuplicateElements d2 = new DuplicateElements(list2);
        List<Integer> expected2 = Arrays.asList(); // Empty list
        assertEquals(expected2, d2.getElements());

        // Test 3
        List<Integer> list3 = Arrays.asList(2,2,42,10,3,1,3,5,6,7,4,1,42);
        DuplicateElements d3 = new DuplicateElements(list3);
        List<Integer> expected3 = Arrays.asList(1,2,3,42);
        assertEquals(expected3, d3.getElements());

        // Test 4
        List<Integer> list4 = Arrays.asList(11,10,9,11,10,9);
        DuplicateElements d4 = new DuplicateElements(list4);
        List<Integer> expected4 = Arrays.asList(9,10,11);
        assertEquals(expected4, d4.getElements());

    }
}