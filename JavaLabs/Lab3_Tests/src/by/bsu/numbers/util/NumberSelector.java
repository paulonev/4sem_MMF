package by.bsu.numbers.util;

import java.util.ArrayList;
import java.util.HashSet;

//Найти такие p-значные числа, в записи которых встречаются не более k различных цифр
public class NumberSelector {
    //here to write realization
    private ArrayList<Integer> list;

    public NumberSelector() {}

    public NumberSelector(ArrayList<Integer> list) {
        this.list = list;
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }


    /**This method selects numbers from a list that satisfy the requirements
     *
     * @param   amountDigits      required amount of digits in number
     * @param   amountDifDigits   floor amount of different digits in number
     * @return                    list of numbers that are suitable under this task's conditions
     */
    public ArrayList<Integer> selector (int amountDigits, int amountDifDigits)
    {
        ArrayList<Integer> listOfSuitableNumbers = new ArrayList<>();
        int p = amountDigits;
        int k = amountDifDigits;
        for (int item : this.list)
        {
            if(item >= Math.pow(10,p-1) && item < Math.pow(10,p))
            {
                //создается множество цифр каждого числа
                //возврашает только неповторяющиеся числа
                HashSet<Integer> digitsSet = getUniqueListOfNumberLiterals(item);
                if(getAmountOfNumberLiterals(digitsSet) <= k)
                {
                    listOfSuitableNumbers.add(item);
                }
            }
        }
        this.setList(listOfSuitableNumbers);
        return listOfSuitableNumbers;
    }

    /**This is extra method that returns a set of unique literals of a number
     *
     * @param   number    number to be checked
     * @return            set of unique literals of a number
     */
    private HashSet<Integer> getUniqueListOfNumberLiterals(int number)
    {
        ArrayList<Integer> list = new ArrayList<>();
        //разбили на литералы
        while(number != 0)
        {
            list.add(number%10);
            number /= 10;
        }

        return new HashSet<>(list);
    }


    private int getAmountOfNumberLiterals(HashSet<Integer> list)
    {
        return list.size();
    }
}
