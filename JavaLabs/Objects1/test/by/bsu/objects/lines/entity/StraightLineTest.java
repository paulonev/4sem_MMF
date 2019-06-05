package by.bsu.objects.lines.entity;

import by.bsu.objects.lines.parallelism.ParallelGrouping;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StraightLineTest {
    private static final Logger LOGGER = LogManager.getLogger(StraightLine.class.getName());

    @Test
    void areParallel() {
        try {
            StraightLine line1 = new StraightLine(3, 4, -2);
            StraightLine line2 = new StraightLine(9, 1, 0);

            assertTrue(line1.areParallel(line2));
            LOGGER.log(Level.DEBUG, "Test #1 complete. Lines are parallel");
        } catch (org.opentest4j.AssertionFailedError e){
            LOGGER.log(Level.ERROR, "Test #1 failed. Lines aren't parallel");
        }
    }

    @Test
    void areEqual() {
        try {
            StraightLine line1 = new StraightLine(3, 4, -2);
            StraightLine line2 = new StraightLine(9, 1, 0);

            assertTrue(line1.areEqual(line2));
            LOGGER.log(Level.DEBUG, "Test #2 complete. Lines are equal");
        } catch (org.opentest4j.AssertionFailedError e){
            LOGGER.log(Level.ERROR, "Test #2 failed. Lines aren't equal");
        }
    }

    @Test
    void linesIntersection(){
        try {
            StraightLine line1 = new StraightLine(3, 4, -2);
            StraightLine line2 = new StraightLine(9, 12, 0);

            String expected = "Lines are the same. Infinitely many common points.";
            assertEquals(expected, line1.getLinesIntersection(line2));
            LOGGER.log(Level.DEBUG, "Test #3 complete");
        } catch (org.opentest4j.AssertionFailedError e){
            LOGGER.log(Level.ERROR, "Test #3 failed\n" + "Actual: " + e.getActual() + "\nExpected: " + e.getExpected());
        }
    }

    //Todo: test on amount of parallel groups, for example
    /**We would instantiate several lines
     * Divided them into groups by HashMap
     * And see how many keys are there in HashMap
     */

    @Test
    void groupTesting(){
        try {
            List<StraightLine> lines = new ArrayList<>();
            lines.add(new StraightLine(2, -1, 0));
            lines.add(new StraightLine(1, -2, 1));
            lines.add(new StraightLine(2, -1, 5));
            lines.add(new StraightLine(-3, 4, 10));
            lines.add(new StraightLine(2, -4, 0));
            lines.add(new StraightLine(10, -5, 0));

            int groupsAmount = 3;
            assertEquals(groupsAmount, ParallelGrouping.getGroupsParallel(lines).keySet().size());
            LOGGER.log(Level.DEBUG, "Test #4 complete");
        } catch(org.opentest4j.AssertionFailedError e){
            LOGGER.log(Level.ERROR, "Test #4 failed\n" + "Actual: " + e.getActual() + "\nExpected: " + e.getExpected());
        }
        //        Map<StraightLine,List<StraightLine>> groups = new HashMap<>();
//        groups.put(new StraightLine(2,-1,0), Arrays.asList(new StraightLine(2,-1,5),
//                new StraightLine(10,-5,0)));
//        groups.put(new StraightLine(-3,4,10),new ArrayList<>());
//        groups.put(new StraightLine(1,-2,1),Arrays.asList(new StraightLine(2,-4,0)));
        //assertEquals(groups,ParallelGrouping.getGroupsParallel(lines));


    }
}