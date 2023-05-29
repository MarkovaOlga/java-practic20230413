package lesson6;

public class CatShow extends Cat{
    int place;
    String category;

    public CatShow(String name, String breed, int age, boolean isMale, String category,int place) {
        super(name, breed, age, isMale);
        this.category = category;
        this.place = place;
    }
}
