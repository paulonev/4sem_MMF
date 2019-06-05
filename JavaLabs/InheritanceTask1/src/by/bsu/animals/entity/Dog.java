package by.bsu.animals.entity;

import by.bsu.animals.exception.AnimalAgeException;
import java.util.Objects;

import static by.bsu.animals.constants.ProgramConstants.MAX_DOGAGE;
import static by.bsu.animals.constants.ProgramConstants.MAX_PUPPYAGE;

/**This class describes instances of class DOG
 * @author Paul Okunev
 * @version 1.0
 */
public class Dog extends Animal{
    double age;

    public Dog(){}

    /** Constructor
     * @param name  animal's name
     * @param age   dog's age
     * @throws AnimalAgeException   if app tries to set age greater than 30 or less than or equal to MAX_PUPPYAGE
     */
    public Dog(String name, int age) throws AnimalAgeException{
        super(name);
        if(age > MAX_DOGAGE || age <= MAX_PUPPYAGE) throw new AnimalAgeException("Wrong dog's age");
        this.age = age;
    }

    public void setAge(int age) { this.age = age; }

    public double getAge() {
        return age;
    }

    public String getName(){
        return super.getName();
    }

    public String makeVoice() {
        return "Gav gav";
    }

    public String jump() {
        return "Dog jumped";
    }

    public String run() {
        return "Dog ran";
    }

    public String bite() {
        return "Dog can bite you. Be careful";
    }

    @Override
    public String toString(){
        return "Dog[\n" +
                "Name: " + this.getName() + "\n"+
                "Age: " + this.age +
                "\n]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return age == dog.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age);
    }
}
