package by.bsu.numbers.run;

import by.bsu.numbers.exceptions.InvalidAmountOfDifferentDigitsException;
import by.bsu.numbers.util.NumberSelector;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(8);
        list.add(15);
        list.add(11);
        list.add(123);
        list.add(222);
        list.add(344);
        list.add(8122);
        list.add(7777);
        list.add(5234);

        NumberSelector ns = new NumberSelector(list);

        boolean isWrongInput = true;

        while(isWrongInput) {
            try {
                System.out.print("Input amount of literals: ");
                String input = sc.nextLine();
                int amountDigits = Integer.parseInt(input);

                System.out.print("Input parameter: ");
                input = sc.nextLine();
                int param = Integer.parseInt(input);

                if(amountDigits <= 0){
                    throw new InvalidAmountOfDifferentDigitsException("Numbers cannot be of not" +
                            " positive literal amount. Try again with positive number");
                }
                if(param > amountDigits)
                {
                    throw new InvalidAmountOfDifferentDigitsException("Parameter cannot be greater than" +
                            " amount of literals");
                }

                ArrayList<Integer> parameterizedList = ns.selector(amountDigits,param);
                System.out.println("Amount of suitable numbers: " + parameterizedList.size());

                System.out.println(parameterizedList);
                isWrongInput = false;

            }
            catch (InvalidAmountOfDifferentDigitsException e)
            {
                System.out.println(e.getMessage());
            }
            catch (NumberFormatException e) {
                System.out.println("Input a number, would you");
            }
        }
        System.out.println("Thanks for using my app! Goodbye");
    }
}
