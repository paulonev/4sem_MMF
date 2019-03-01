package by.bsu.lab1.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ArrayMethods {
    public static boolean isNumber(String input)
    {
        if(input == null) return false;
        return input.matches("^([-+])?\\d+$"); //положительное или отрицательное число из нескольких знаков

    }


    /* Method that creates & fulfills array from console
     *
     * @param  num   dimension of array to create
     * @exception  InputMismatchException  arises when input is not integer
     * @return  generated int[] array
     * */
    public int[] createArray(int num)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[num];
        /*
        for (int i = 0; i < num; i++)
        {
            try{
                Scanner in = new Scanner(System.in);
                System.out.print((i + 1) + ": ");
                numbers[i] = in.nextInt();
            }
            catch (java.util.InputMismatchException ex) {
                System.out.println("Wrong input! It should be a number");
                i--;
            }
        }
        */
        for (int i = 0; i < num; i++)
        {
            System.out.print((i + 1) + ": ");
            String s = null;
            try{
                s = reader.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            if(isNumber(s))
            {
                numbers[i] = Integer.parseInt(s);
            } else {
                System.out.println("Wrong input! It should be a number");
                i--;
            }
        }
        return numbers;
    }

/* Method that places elements of arrays in descending order of their frequency
 *
 * @param  []nums       array of numbers
 * @param  []counters   array of numbers' counters
 * */
    public void arraysSort(int[] nums, int[] counters)
    {
        for ( int i = 0; i < nums.length - 1; i++ )
        {
            for ( int j = i + 1; j < nums.length; j++ )
            {
                if ( counters[j] > counters[i] )
                {
                    int tmp = counters[i];
                    counters[i] = counters[j];
                    counters[j] = tmp;

                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
                else if ( counters[i] == counters[j] && nums[i] > nums[j] ) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
}
