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
    public static void main(String[] args)
    {
        MatrixFactory mf = new MatrixFactory();
        Scanner sc = new Scanner(System.in); //for input
        boolean isWrongInput = true;
        int dimension;

        //to check for right input
        while(isWrongInput) {
            try {
                System.out.print("Input dimension of your matrix: ");
                String output = sc.nextLine();
                dimension = Integer.parseInt(output);

                Matrix matrix = mf.matrixFactory(dimension);

                //доделать
                Handlers h = new Handlers();
                h.changeMatrix(matrix);

                //output successfully changed matrix of Matrix object
                System.out.println(matrix.toString());

                isWrongInput = false;
            }
            catch(MatrixException e)
            {
                System.out.println(e.getMessage());
            }
            catch(NumberFormatException e)
            {
                System.out.println("Input a number, would you");
            }
        }
        System.out.println("Thanks for using my app. Goodbye!");

    }
}
