package com.mjherich.ImpactTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Find Duplicate Elements Problem
 *
 * The constructor takes in a list of integers and produces a
 * list of only the duplicates.
 */
public class DuplicateElements {
    private List<Integer> duplicates = new ArrayList<Integer>();

    public DuplicateElements(List<Integer> intList) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i : intList) {
            if (hm.containsKey(i) && hm.get(i) == 1) {
                hm.put(i, 2);
                this.duplicates.add(i);
            } else {
                hm.put(i, 1);
            }
        }

        Collections.sort(this.duplicates);
    }

    public List<Integer> getDuplicates() {
        return this.duplicates;
    }

}
