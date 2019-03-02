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
        int numberDimension = 2; // select numbers with this amount of digits
        int amountDifDigits = 2;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(15);
        list.add(11);
        list.add(123);
        list.add(244);
        NumberSelector ns = new NumberSelector(list);
        int[] expectedArray = {15,11};
        ArrayList<Integer> resultList = ns.selector(numberDimension,amountDifDigits);
        //convert ArrayList<Integer> to int[]
        //Java 8 has IntStream
        //resultList.stream() returns Stream<Integer>
        //Need to convert Stream<Integer> to tiny IntStream object
        //mapToInt is used for that
        int[] resultArray = resultList.stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(expectedArray,resultArray);
    }

}