package by.bsu.objects.lines.parallelism;

import by.bsu.objects.lines.entity.StraightLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParallelGrouping {
    /**Each line corresponds to the list of other lines that are parallel with the given one
     *
     * @param list  all lines
     * @return  HashMap: LINE - {lines that are parallel with LINE}
     */
    public static Map<StraightLine, List<StraightLine>> getGroupsParallel(List<StraightLine> list) {
        Map<StraightLine, List<StraightLine>> map = new HashMap<>();
        if (list != null && !list.isEmpty()) {
            boolean flag;
            while (!list.isEmpty()) {
                flag = false;
                StraightLine line = list.remove(0);
                for (StraightLine lineMap : map.keySet()) {
                    if (lineMap.areParallel(line)) {
                        map.get(lineMap).add(line);
                        flag = true;
                        break;
                    }
                }
                if (!flag) map.put(line, new ArrayList<>());
            }
        }
        return map;
    }

    public static void printParallelGroups(Map<StraightLine, List<StraightLine>> groups){
        //print groups
        for (Map.Entry<StraightLine, List<StraightLine>> group : groups.entrySet()) {
            if (group.getValue().size() > 0) {
                System.out.printf("Line %s is parallel to:%s", group.getKey(), System.lineSeparator());
                for (StraightLine line : group.getValue()) {
                    System.out.printf("    %s;%s", line, System.lineSeparator());
                }
                System.out.println();
            }
        }
    }
}
