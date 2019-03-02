package by.bsu.matrices.utils;

import by.bsu.matrices.entities.Matrix;
import by.bsu.matrices.entities.Constants;
import by.bsu.matrices.exceptions.MatrixException;

/**This class contains method used to randomly fulfill 2D arrays
 * @author  Paul Okunev
 * @see     by.bsu.matrices.entities.Matrix
 *
 */
public class MatrixFactory {

    /**This method is used to randomly fulfill int[][] array
     * and factorizes matrix object
     * @param   size  size of array to be fulfilled
     */
    public Matrix matrixFactory(int size) throws MatrixException
    {
        //check for negative value of dimension
        if(size < 1) throw new MatrixException("Dimension of matrix cannot be negative");

        int[][] array = new int[size][];
        for (int i=0; i<size; i++)
        {
            array[i] = new int[size];
        }

        for (int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = (int) ((Math.random()* Constants.MAX_RANGE) + Constants.MIN_RANGE);
            }
        }
        return new Matrix(array);
    }
}
