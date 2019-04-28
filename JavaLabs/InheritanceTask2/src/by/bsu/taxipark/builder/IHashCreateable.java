package by.bsu.taxipark.builder;

import by.bsu.taxipark.exception.WrongDataException;

import java.util.HashMap;
import java.util.Map;

public interface IHashCreateable {
    /** Method reads information about cars from a file and checks if file exists or is available
     *
     * @param arguments             arguments which to create a HashMap from
     * @return                      HashMap according to the rule on 21st line
     * @throws WrongDataException   if argument list is empty
     */
    static Map<String,Integer> createHashMap(String arguments)throws WrongDataException{
        Map<String, Integer> carKeyMap = new HashMap<>();

        //creating the hashmap: parameter - index
        //model-0,year-1,consumption-2,price-3,maxPassengers-4,maxSpeed-5,airConditioning-6,beverages-7
        if (arguments != null) {
            String[] carKeys = arguments.split(",");
            int counter = 0;
            for (String key : carKeys) {
                carKeyMap.put(key, counter++);
            }
        } else{
            throw new WrongDataException("Unable to find argument list");
        }
        return carKeyMap;
    }

}
