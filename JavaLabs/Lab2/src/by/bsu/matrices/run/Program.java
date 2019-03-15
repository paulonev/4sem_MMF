package by.bsu.matrices.run;

import by.bsu.matrices.exceptions.MatrixException;
import by.bsu.matrices.matrixFactory.MatrixFactory;
import by.bsu.matrices.utils.Handlers;
import by.bsu.matrices.entities.Matrix;

import java.util.*;

/**
 * This class contains "main" method where all program is running
 *
*@author Paul Okunev
*@since JDK 9.0.1
 */

public class Program {
    /**This method is used to combine value inputs
     * so that it could be easier to validate it
     *
     * @param s scanner stream
     * @param textCase message displayed(ui)
     * @return valid input(a number)
     */
    private static int validateInput(Scanner s, String textCase){
        int numberToReturn;
        while(true){
            System.out.print(textCase);
            if(s.hasNextInt()){
                String output = s.nextLine();
                numberToReturn = Integer.parseInt(output);
                break;
            }
            else{
                System.out.println("Input a number, would you");
                s.nextLine(); //!!!
            }
        }
        return numberToReturn;
    }
    public static void main(String[] args)
    {
        try {
            MatrixFactory mf = new MatrixFactory();
            Scanner sc = new Scanner(System.in); //for input
            int dimension, min_range, max_range;

            dimension = validateInput(sc, "Input dimension of matrix: ");
            min_range = validateInput(sc, "Input min range of generating: ");
            max_range = validateInput(sc, "Input max range of generating: ");


            Matrix matrix = mf.matrixFactory(dimension, min_range, max_range);

            Handlers h = new Handlers();
            h.changeMatrix(matrix);

            //output successfully changed matrix of Matrix object
            System.out.println(matrix.toString());
        }
        catch (MatrixException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Thanks for using my app. Goodbye!");
    }
}
