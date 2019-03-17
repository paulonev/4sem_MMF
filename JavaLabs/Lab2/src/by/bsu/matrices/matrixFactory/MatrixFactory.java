package by.bsu.matrices.matrixFactory;

import by.bsu.matrices.entities.Matrix;
import by.bsu.matrices.entities.Constants;
import by.bsu.matrices.exceptions.MatrixException;

/**This class contains method used to randomly fulfill 2D arrays
 * @author  Paul Okunev
 * @see     by.bsu.matrices.entities.Matrix
 *
 */
public class MatrixFactory {

    /**This method is used to randomly fulfill double[][] array
     * and factorizes matrix object
     *
     * @param size          size of array to be fulfilled
     * @param min_range     minimum value of array's elements
     * @param max_range     maximum value of array's elements
     * @return              generated Matrix object with fulfilled array
     * @throws MatrixException if dimension(size) of array is less than 1 or wrong diapason (MAX less than MIN)
     */
    public Matrix matrixFactory(int size, int min_range, int max_range) throws MatrixException
    {
        //check for negative value of dimension or for impossibility of diapason edges
        if(size < 1 || max_range <= min_range) throw new MatrixException("Dimension of matrix cannot be negative or entered diapason doesn't exist");

        double[][] array = new double[size][];
        for (int i=0; i<size; i++)
        {
            array[i] = new double[size];
        }

        max_range -= min_range;
        for (int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = (Math.random()* max_range) + min_range; //Math.random генерирует вещ. число в диапазоне [0,1)
            }
        }
        return new Matrix(array);
    }
}
