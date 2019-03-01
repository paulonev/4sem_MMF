package by.bsu.numbers.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NumberSelectorTest {
    //here to write methods for testing realization

    @Test
    void selectNumbersFromList()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(15);
        list.add(11);
        list.add(123);
        list.add(244);
        NumberSelector ns = new NumberSelector(list);
        int[] expectedArray = {15,11};
        ArrayList<Integer> resultList = ns.selector(2,2);
        int[] resultArray = resultList.stream().toArray(int[]::new);
        assertArrayEquals(expectedArray,resultArray);
    }

}