package by.bsu.matrices.entities;

import by.bsu.matrices.exceptions.MatrixException;

import java.text.Format;
import java.util.Arrays;

/**This class describes Matrix objects
 * with the only private field - double[][] array
 * @author  Paul Okunev
 * @see     by.bsu.matrices.exceptions.MatrixException
 */
public class Matrix {
    private double[][] array;

    /**
     *
     * @param n the size of square array
     * @throws MatrixException if dimension is less than 1
     */
    public Matrix(int n) throws MatrixException
    {
        //check for negative value of dimension
        if(n<1) throw new MatrixException("Dimension of matrix cannot be negative");
        array = new double[n][n];
    }

    public Matrix(double[][] array) {
        this.array = array;
    }

    public int getVerticalSize(){
        return array.length;
    }

    public int getHorizontalSize(){
        return array[0].length;
    }

    public double[][] getArray() {
        return array;
    }

    public double getElement(int i, int j) throws MatrixException
    {
        if(checkRange(i,j)){
            return array[i][j];
        }
        throw new MatrixException("There is no element with this indexes");
    }

    public void setElement(int i, int j, int val) throws MatrixException
    {
        if(checkRange(i,j)){
            array[i][j] = val;
        }
        throw new MatrixException("Impossible to put value in unreachable storage");
    }

    /**Check for exiting ranges of array
     *
     * @param i row number
     * @param j column number
     * @return TRUE if we exited edges of array , FALSE otherwise
     */
    private boolean checkRange(int i, int j)
    {
        return i < 0 || i > array.length - 1 || j < 0 || j > array[0].length - 1;
    }

    /** Overriden toString with formatted
     *  representation of elements of array
     * @return string representation of Array
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (double[] row : array) {
            for (double elem : row) {
                out.append(String.format("%6.1f", elem));
            }
            out.append("\n");
        }
        return out.toString();
    }
}

