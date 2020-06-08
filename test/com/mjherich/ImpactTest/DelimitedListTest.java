package com.mjherich.ImpactTest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DelimitedListTest {

    @Test
    public void populatesDelimitedList() {
        // Test case 1
        List<Integer> inputList0 = Arrays.asList(9000);
        DelimitedList dl0 = new DelimitedList(inputList0);
        assertEquals("9000", dl0.toString());

        // Test case 2
        List<Integer> inputList1 = Arrays.asList(9000, 9001);
        DelimitedList dl1 = new DelimitedList(inputList1);
        assertEquals("9000:9001", dl1.toString());

        // Test case 3
        List<Integer> inputList3 = Arrays.asList(1,2,3,44,5,0,-9,-7,-8,42,43,46,56);
        DelimitedList dl3 = new DelimitedList(inputList3);
        assertEquals("-9:-7, 0:3, 5, 42:44, 46, 56", dl3.toString());

        // Test case 4
        List<Integer> inputList4 = Arrays.asList(10,8,9,-2,4,0,-1,12);
        DelimitedList dl4 = new DelimitedList(inputList4);
        assertEquals("-2:0, 4, 8:10, 12", dl4.toString());

        // Test case 5
        List<Integer> inputList5 = new ArrayList<Integer>();
        DelimitedList dl5 = new DelimitedList(inputList5);
        assertEquals("", dl5.toString());
    }

    @Test
    public void handlesDuplicateValues() {
        List<Integer> inputList1 = Arrays.asList(1,2,-7,2,3,0,10,1,-9,-10,10,-7);
        DelimitedList dl3 = new DelimitedList(inputList1);
        assertEquals("-10:-9, -7, 0:3, 10", dl3.toString());
    }
}