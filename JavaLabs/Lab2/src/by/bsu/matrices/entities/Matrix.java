package by.bsu.matrices.entities;

import by.bsu.matrices.exceptions.MatrixException;
/**This class describes Matrix objects
 *
 * @author  Paul Okunev
 * @see     by.bsu.matrices.exceptions.MatrixException
 */
public class Matrix {
    private int[][] array;

    public Matrix(int n) throws MatrixException
    {
        //check for negative value of dimension
        if(n<1) throw new MatrixException("Dimension of matrix cannot be negative");
        array = new int[n][n];
    }

    public int getVerticalSize(){
        return array.length;
    }

    public int getHorizontalSize(){
        return array[0].length;
    }

    public int[][] getArray() {
        return array;
    }

    public int getElement(int i, int j) throws MatrixException
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

    //check for exiting ranges of array
    private boolean checkRange(int i, int j)
    {
        return i < 0 || i > array.length - 1 || j < 0 || j > array[0].length - 1;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        for (int[] row : array)
        {
            for (int item : row)
            {
                str.append(item + " ");
            }
            str.append("\n");
        }
        return str.toString();
    }
}
