package by.bsu.taxipark.entity;

import by.bsu.taxipark.builder.Autobuilder;
import by.bsu.taxipark.entity.fewPassengersCar.CarClassification;
import by.bsu.taxipark.exception.WrongDataException;
import by.bsu.taxipark.read.fileReader;

import java.io.IOException;
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
    private List<Auto> carPool;

    /**This method refers to createTaxiPark method from Autobuilder class
     *
     * @param filePath              file destination
     * @throws RuntimeException     when file doesn't exist
     * @throws WrongDataException   if automobile doesn't match any category(econom, comfort, business or minivan)
     * @see by.bsu.taxipark.builder.Autobuilder
     */
    public void setCarPool(String filePath) throws WrongDataException,NumberFormatException {
        this.carPool = new Autobuilder().createTaxiPark(fileReader.readFile(filePath));
    }

       public List<Auto> getCarPool() {
        return carPool;
    }

    /**This method filters cars list to econom cars list
     *
     * @param carPool   list to filter
     * @return          filtered list
     */
    public List<Auto> getEconomPool(List<Auto> carPool) {
        List<Auto> economPool = new ArrayList<>();
        for (Auto car : carPool){
            if(car.carClass == CarClassification.ECONOM) economPool.add(car);
        }
        return economPool;
    }

    /**This method filters cars list to comfort cars list
     *
     * @param carPool   list to filter
     * @return          filtered list
     */
    public List<Auto> getComfortPool(List<Auto> carPool) {
        List<Auto> comfortPool = new ArrayList<>();
        for (Auto car : carPool) {
            if (car.carClass == CarClassification.COMFORT) comfortPool.add(car);
        }
        return comfortPool;
    }

    /**This method filters cars list to business cars list
     *
     * @param carPool   list to filter
     * @return          filtered list
     */
    public List<Auto> getBusinessPool(List<Auto> carPool) {
        List<Auto> businessPool = new ArrayList<>();
        for (Auto car : carPool){
            if(car.carClass == CarClassification.BUSINESS) businessPool.add(car);
        }
        return businessPool;
    }

    /**This method filters cars list to minivans list
     *
     * @param carPool   list to filter
     * @return          filtered list
     */
    public List<Auto> getVanPool(List<Auto> carPool) {
        List<Auto> vanPool = new ArrayList<>();
        for (Auto car : carPool){
            if(car.carClass == CarClassification.VAN) vanPool.add(car);
        }
        return vanPool;
    }

}
