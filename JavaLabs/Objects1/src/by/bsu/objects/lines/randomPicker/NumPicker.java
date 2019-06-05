package by.bsu.objects.lines.randomPicker;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumPicker {
    private static final Random RANDOM = new Random();
    /**
     * Pick n numbers between 0 (inclusive) and k (inclusive)
     * While there are very deterministic ways to do this,
     * for large k and small n, this could be easier than creating
     * an large array and sorting, i.e. k = 10,000
     */
    public Set<Integer> pickRandom(int n, int k) {
        final Set<Integer> picked = new HashSet<>();
        while (picked.size() < n) {
            picked.add(RANDOM.nextInt(k + 1));
        }
        return picked;
    }

}
