package com.mjherich.ImpactTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DuplicateElements {
    private List<Integer> elements = new ArrayList<Integer>();

    public DuplicateElements(List<Integer> intList) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i : intList) {
            if (hm.containsKey(i) && hm.get(i) == 1) {
                hm.put(i, 2);
                this.elements.add(i);
            } else {
                hm.put(i, 1);
            }
        }

        Collections.sort(this.elements);
    }

    public List<Integer> getElements() {
        return this.elements;
    }

}
