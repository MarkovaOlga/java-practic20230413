package lesson6;

import java.util.Objects;

public class Cat {
    String name;
    String breed;
    int age;
    boolean isMale;

    public Cat(String name, String breed, int age, boolean isMale) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.isMale = isMale;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" ").append(age);
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, breed, isMale);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Cat)){
            return false;
        }
        Cat temp = (Cat) obj;
        return temp.age == this.age && temp.isMale==this.isMale && temp.breed.equals(this.breed) && temp.name.equals(this.name);
    }
}
