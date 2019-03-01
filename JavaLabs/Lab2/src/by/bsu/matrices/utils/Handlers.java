package by.bsu.matrices.utils;

import by.bsu.matrices.entities.Matrix;

import java.lang.reflect.Array;
import java.util.*;

/**This class contains main functionality of this application
 *
 * @author Paul Okunev
 * @since JDK 9.0.1
 *
 */
public class Handlers {
    /**This method is used to change array of matrix object according to task 10(Variant C)
     * Plan:
     * 1)define maximum value in matrix
     * 2)define rows and cols that have this maximum (stored in arraylists)
     * 3)exclude repeating values from arraylists
     * 4)delete these rows and cols from a matrix
     *
     * @param matrix Object which int[][] array should be changed
     */
    public void changeMatrix(Matrix matrix) {
        //1)
        int maximumValue = getMaxValue(matrix.getArray());
        //2)
        ArrayList<Integer> rowIndexes = new ArrayList<>();
        ArrayList<Integer> colIndexes = new ArrayList<>();

        defineRowsColsContainMax(maximumValue, matrix.getArray(), rowIndexes, colIndexes);
        //3)
        HashSet<Integer> hs = new HashSet<>(rowIndexes);
        rowIndexes.clear();
        rowIndexes.addAll(hs); //list of unique elems

        HashSet<Integer> hs1 = new HashSet<>(colIndexes);
        colIndexes.clear();
        colIndexes.addAll(hs1);

        Collections.sort(rowIndexes, Collections.reverseOrder());
        Collections.sort(colIndexes, Collections.reverseOrder());

        //4)

        for (int item : rowIndexes) {
            deleteRow(item, matrix.getArray());
        }

        for (int item : colIndexes) {
            deleteCol(item, matrix.getArray());
        }

    }

    /**
     * @param array object's 2D array which is checked for maximum
     * @return      maximum value that is stored in array
     */
    private int getMaxValue(int[][] array) {
        int n = array.length;
        int max = array[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (max < array[i][j]) max = array[i][j];
            }
        }
        return max;
    }

    /**Defines rows and columns of 2D array that contain maximum value and
     * store indexes in arrayLists
     *
     * @param currentMax    maximum value found in array
     * @param array         object's 2D array which is checked
     * @param iIndexes      arrayList of row indexes where maximum(s) are stored
     * @param jIndexes      arrayList of col indexes where maximum(s) are stored
     */
    private void defineRowsColsContainMax(int currentMax, int[][] array,
                                          ArrayList<Integer> iIndexes,
                                          ArrayList<Integer> jIndexes) {
        int arrSize = array.length;
        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                if (array[i][j] == currentMax) {
                    iIndexes.add(i);
                    jIndexes.add(j);
                }
            }
        }
    }

    private void deleteRow(int rowIndex, int[][] array) {
        List<int[]> list = new ArrayList<>(Arrays.asList(array));
        list.remove(rowIndex);
        array = list.toArray(new int[array.length - 1][]);
    }

    private void deleteCol(int colIndex, int[][] array) {
        //транспонировать
        array = tranposeMatrix(array);
        //удалить строку
        deleteRow(colIndex, array);
        //транспонировать
        array = tranposeMatrix(array);
    }

    private int[][] tranposeMatrix(int[][] array)
    {
        //rowMNT - число строк
        //colMNT - число столбцов
        int rowMNT = array.length;
        int colMNT = array[0].length;

        int [][] newArr = new int[colMNT][];

        for (int i=0; i<colMNT; i++)
        {
            newArr[i] = new int[rowMNT];
        }

        for (int i=0; i<colMNT; i++)
        {
            for (int j=0; j<rowMNT; j++)
            {
                newArr[i][j] = array[j][i];
            }
        }
        return newArr;
    }
}
