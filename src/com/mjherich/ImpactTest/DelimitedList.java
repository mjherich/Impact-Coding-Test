package com.mjherich.ImpactTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Delimited List Problem
 *
 * The class constructor accepts in a list of integers, sorts them and populates
 * the delimited list while grouping ranges. At first I was going to write a
 * simple method to output the delimited list as a string but then decided to
 * store the list with a range helper class. This way it would be easier to add
 * additional functionality down the line. Also, after doing some testing I decided
 * it would make sense to remove duplicates before processing the list since the
 * core functionality of the class is to group numbers into a range.
 */
public class DelimitedList {
    private List<DLRange> delimitedList = new ArrayList<>();

    public DelimitedList(List<Integer> intList) {
        // Edge cases
        if (intList.size() == 0) {
            return;
        }
        if (intList.size() == 1) {
            this.delimitedList.add(new DLRange(intList.get(0), intList.get(0)));
            return;
        }

        // Remove duplicates from the input
        List<Integer> intListNoDupes = intList.stream()
                .distinct()
                .collect(Collectors.toList());

        // Sort the input
        Collections.sort(intListNoDupes);

        // Range low, high and boolean
        int rangeLow = 0;
        int rangeHigh = 0;
        Boolean isBuildingRange = false;

        // Main loop
        for (int i = 0; i < intListNoDupes.size()-1; i++) {
            int curNum = intListNoDupes.get(i);
            int nextNum = intListNoDupes.get(i+1);

            // Is nextNumber sequential?
            if (curNum + 1 == nextNum) {
                if (isBuildingRange) {
                    rangeHigh = nextNum;
                } else {
                    rangeLow = curNum;
                    rangeHigh = nextNum;
                    isBuildingRange = true;
                }
            } else {
                if (isBuildingRange) {
                    this.delimitedList.add(new DLRange(rangeLow, rangeHigh));
                    isBuildingRange = false;
                } else {
                    this.delimitedList.add(new DLRange(curNum, curNum));
                }
            }
        }

        // Handle last integer
        if (isBuildingRange) {
            this.delimitedList.add(new DLRange(rangeLow, rangeHigh));
        } else {
            int lastNum = intListNoDupes.get(intListNoDupes.size()-1);
            this.delimitedList.add(new DLRange(lastNum, lastNum));
        }
    }

    @Override
    public String toString() {
        String ret = "";

        // If the list is empty return an empty string
        if (this.delimitedList.size() == 0) {
            return ret;
        }

        for (DLRange r : this.delimitedList) {
            ret = ret + r.toString() + ", ";
        }

        // Strip the trailing space and comma
        ret = ret.substring(0, ret.length()-2);

        return ret;
    }

    /**
     * Range class to be set in the DelimitedList
     */
    private class DLRange {
        int low;
        int high;

        public DLRange(int lower, int upper) {
            low = lower;
            high = upper;
        }

        @Override
        public String toString() {
            if (low == high) {
                return Integer.toString(low);
            } else {
                return low + ":" + high;
            }
        }
    }
}
