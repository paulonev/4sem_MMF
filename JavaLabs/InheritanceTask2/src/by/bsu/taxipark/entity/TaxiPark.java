package by.bsu.taxipark.entity;

//import by.bsu.taxipark.builder.Autobuilder;
import by.bsu.taxipark.builder.TaxiParkCreator;
import by.bsu.taxipark.exception.WrongDataException;
import by.bsu.taxipark.read.fileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**10. Таксопарк. Определить иерархию легковых автомобилей. Создать таксопарк.
 * Провести сортировку автомобилей парка по расходу топлива. Подсчитать стоимость автопарка.
 * Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.
 *
 * @author Paul Okunev
 * @version 1.0
 */
public class TaxiPark {
    private List<Car> carPool;

    /**This method refers to createTaxiPark method from TaxiParkCreator class
     *
     * @param filePath               file destination
     * @throws FileNotFoundException when file doesn't exist or wasn't found
     * @throws WrongDataException    when there is a mistake in data file
     * @throws OutOfMemoryError      if couldn't allocate memory for object
     *
     */
    public void setCarPool(String filePath) throws WrongDataException, FileNotFoundException, OutOfMemoryError {
        this.carPool = new TaxiParkCreator().initializeTaxiPark(filePath);
    }

    public void setEconomCarPool(String filePath) throws WrongDataException, FileNotFoundException, OutOfMemoryError{
        this.carPool = new TaxiParkCreator().initializeEconomTaxiPark(filePath);
    }

    public List<Car> getCarPool() {
        return carPool;
    }

}
