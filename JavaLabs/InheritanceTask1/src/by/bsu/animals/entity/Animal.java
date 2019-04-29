package by.bsu.animals.entity;

import java.util.Objects;

/**This class describes basic instance - an animal
 * @author Paul Okunev
 * @version 1.0
 */
public class Animal {
    private String name;

    public Animal(){}
    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString(){
        return "Animal: " + this.name;
    }
}
