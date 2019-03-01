package by.bsu.matrices.utils;

import by.bsu.matrices.entities.Matrix;
import by.bsu.matrices.entities.Constants;

/**This class contains method used to randomly fulfill 2D arrays
 * @author  Paul Okunev
 * @see     by.bsu.matrices.entities.Matrix
 *
 */
public class ArrayFiller {

    /**This method is used to randomly fulfill int[][] array
     * @param   array  2D array that this method fulfills
     */
    public void fillArray(int[][] array)
    {
        int size = array.length;
        for (int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = (int) ((Math.random()* Constants.MAX_RANGE) + Constants.MIN_RANGE);
            }
        }

    }
}
