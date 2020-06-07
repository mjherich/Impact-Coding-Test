package com.mjherich.ImpactTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DelimitedList {
    private List<DLRange> delimitedList = new ArrayList<>();

    /**
     * This constructor accepts in a List of integers, sorts them and populates
     * the delimited list.
     * @param intList
     */
    public DelimitedList(List<Integer> intList) {
        // Edge cases
        if (intList.size() == 0) {
            return;
        }
        if (intList.size() == 1) {
            this.delimitedList.add(new DLRange(intList.get(0), intList.get(0)));
            return;
        }

        // Sort the input
        Collections.sort(intList);

        // Range low, high and boolean
        int rangeLow = 0;
        int rangeHigh = 0;
        Boolean isBuildingRange = false;

        // Main loop
        for (int i = 0; i < intList.size()-1; i++) {
            int curNum = intList.get(i);
            int nextNum = intList.get(i+1);

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
            int lastNum = intList.get(intList.size()-1);
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
