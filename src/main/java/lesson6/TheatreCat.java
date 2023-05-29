package lesson6;

public class TheatreCat extends Cat{
    int groupId;
    String ability;

    public TheatreCat(String name, String breed, int age, boolean isMale, String ability, int groupId) {
        super(name, breed, age, isMale);
        this.ability = ability;
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return super.toString() + " " + ability;
    }
}
