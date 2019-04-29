package by.bsu.animals.entity;

import by.bsu.animals.exception.AnimalAgeException;

import java.util.Objects;

/**This class describes instances of class PUPPY
 * We created puppy with the help of animal and dog.
 * @author Paul Okunev
 * @version 1.0
 */
public class Puppy extends Dog{
    protected static final int MAX_PUPPYAGE = 4;

    public Puppy(){}

    /** Constructor
     * @param name  animal's name
     * @param age   puppy's age
     * @throws AnimalAgeException   if app tries to set age greater than 4 or less than or equal to 0
     */
    public Puppy(String name, int age) throws AnimalAgeException{
        super(name,age);
        if(age > MAX_PUPPYAGE || age <= 0) throw new AnimalAgeException("Wrong puppy's age");
        else this.age = age;
    }

    public double getAge() {
        return age;
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
        return "Name: " + this.getName() + "\n"+ "Age: " + this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Puppy puppy = (Puppy) o;
        return age == puppy.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age);
    }
}
