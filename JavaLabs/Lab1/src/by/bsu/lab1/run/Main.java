package by.bsu.lab1.run;

import by.bsu.lab1.methods.ArrayMethods;
import java.util.Scanner;

/*
*Problem: Input [NUM] numbers from console and output them in descending order of their frequency of appearance
*
*@author  Okunev
*@since   JDK 9.0.1
*@see     by.bsu.lab1.methods.ArrayMethods
*/
public class Main {
    public static void main(String[] args)
    {
        ArrayMethods am = new ArrayMethods();
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            try
            {
                System.out.print("Input amount of numbers or \"e\" to exit: ");
                String input = scan.nextLine();

                if(input.equals("e")) break;
                else
                {
                    int NUM = Integer.parseInt(input); // dimension of array, possible exception
                    int[] numbers = am.createArray(NUM);
                    int[] counters = new int [numbers.length];

                    //создание массива счётчиков
                    for ( int i = 0; i < numbers.length; i++ )
                    {
                        counters[i] = 0;
                        for ( int j = 0; j < numbers.length; j++ )
                            if ( numbers[i] == numbers[j] )
                                counters[i] += 1;
                    }

                    am.arraysSort(numbers,counters);

                    System.out.println("Number\tMeets");
                    for ( int i = 0; i < numbers.length; i += counters[i] )
                        System.out.println(numbers[i] + "\t\t" + counters[i]);
                }

            }
            catch (NumberFormatException ex) {
                System.out.println("Input number, would you.");
                continue;
            }
            catch(NegativeArraySizeException ex)
            {
                System.out.println("Wrong input! Input positive number, please.");
                continue;
            }
        }
        System.out.println("Thanks for using my app! Bye!");
    }
}