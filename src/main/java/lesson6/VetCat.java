package lesson6;

public class VetCat extends Cat {
    String medicalHistory;
    boolean isSterilized;

    public VetCat(String name, String breed, int age, boolean isMale, boolean isSterilized, String medicalHistory) {
        super(name, breed, age, isMale);
        this.isSterilized = isSterilized;
        this.medicalHistory = medicalHistory;
    }

    @Override
    public String toString() {
        return super.toString()+ " " + medicalHistory;
    }
}