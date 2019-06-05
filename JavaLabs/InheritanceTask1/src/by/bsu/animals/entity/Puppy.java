package by.bsu.animals.entity;

import by.bsu.animals.exception.AnimalAgeException;
import java.util.Objects;
import static by.bsu.animals.constants.ProgramConstants.MAX_PUPPYAGE;
import static by.bsu.animals.constants.ProgramConstants.MIN_FEEDPERIOD;

/**This class describes instances of class PUPPY
 * We created puppy with the help of animal and dog.
 * @author Paul Okunev
 * @version 1.0
 */
public class Puppy extends Dog{
    private int feeding_period; //период материнского кормления (в месяцах)

    public Puppy(){}

    /** Constructor
     * @param name              animal's name
     * @param age               puppy's age
     * @param feeding_period    период материнского кормления (в месяцах)
     * @throws AnimalAgeException   if app tries to set age greater than 4 or less than or equal to 0
     */
    public Puppy(String name, int age, int feeding_period) throws AnimalAgeException{
        super.setName(name);
        if(age > MAX_PUPPYAGE || age <= 0 || feeding_period < MIN_FEEDPERIOD) throw new AnimalAgeException("Wrong parameters. Check constants");
        else{
            super.setAge(age);
            this.feeding_period = feeding_period;
        }
    }

    public int getFeeding_period() {
        return feeding_period;
    }

    public void setFeeding_period(int feeding_period) {
        this.feeding_period = feeding_period;
    }

    public double getAge() {
        return this.age;
    }

    public String getName(){
        return super.getName();
    }

    public String makeVoice() {
        return "Tiu tiu";
    }

    public String jump() {
        return "Puppy jumped";
    }

    public String run() {
        return "Puppy ran";
    }

    public String bite(){
        return "Even young puppy can bite you. Don't tease";
    }
    @Override
    public String toString(){
        return "Name: " + this.getName() + "\n"+ "Age: " + this.age + "\n" + "Feeding_period: " + this.feeding_period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Puppy puppy = (Puppy) o;
        return feeding_period == puppy.feeding_period;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), feeding_period);
    }
}
