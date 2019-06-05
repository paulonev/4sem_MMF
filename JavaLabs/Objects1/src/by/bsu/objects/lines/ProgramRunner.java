package by.bsu.objects.lines;

import by.bsu.objects.lines.entity.StraightLine;
import by.bsu.objects.lines.parallelism.ParallelGrouping;
import by.bsu.objects.lines.randomPicker.NumPicker;

import java.util.*;

public class ProgramRunner {

    public static void main(String[] args) {
        List<StraightLine> listLines = new ArrayList<>();
        // Ax + By + C = 0 - general equation of line on plane
        listLines.add(new StraightLine(0, 2, -3)); //y parallel
        listLines.add(new StraightLine(0, 3, 1000)); //y parallel
        listLines.add(new StraightLine(5, 0, -3)); // x parallel
        listLines.add(new StraightLine(10, 0, 1000)); // x parallel
        listLines.add(new StraightLine(2, -1, -3));
        listLines.add(new StraightLine(-3, -1, 2));
        listLines.add(new StraightLine(-3, -1, 2));
        listLines.add(new StraightLine(-3, -1, 4));
        listLines.add(new StraightLine(-3, -1, 5));
        listLines.add(new StraightLine(-1, -1, 4));
        listLines.add(new StraightLine(-1, -1, 5));

        NumPicker picker = new NumPicker();
        Set<Integer> indexSet = picker.pickRandom(2, listLines.size() - 1);
        System.out.println("Pseudo random indexes: " + indexSet);
        Iterator iterator = indexSet.iterator();
        int i = 1;
        while (iterator.hasNext()) {
            System.out.print("Line " + i + ": ");
            System.out.println(listLines.get((int) iterator.next()).toString());
            i++;
        }

        Iterator iterator1 = indexSet.iterator();
        System.out.println(listLines.get((int) iterator1.next()).getLinesIntersection(listLines.get((int) iterator1.next())));

        for (StraightLine line : listLines) {
            System.out.println();
            System.out.printf("Line: %s;%s", line, System.lineSeparator());
            System.out.printf("Intersection with Ox: %s;%s", line.getPointIntersectionWithX(), System.lineSeparator());
            System.out.printf("Intersection with Oy: %s;%s", line.getPointIntersectionWithY(), System.lineSeparator());
        }
        System.out.println();

        //divide lines into parallel groups
        Map<StraightLine, List<StraightLine>> groups = ParallelGrouping.getGroupsParallel(listLines);
        //print groups
        ParallelGrouping.printParallelGroups(groups);

    }

}
