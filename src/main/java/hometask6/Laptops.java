package hometask6;

public class Laptops {
    String manufacturer;
    String model;
    String bodyColor;
    double screenDiagonal;
    String processor;
    String videoCart;
    int randomAccessMemory;
    int numberOfProcessorCores;
    int hardDiskCapacity;
    boolean wedCamera;
    boolean keyboardBacklight;
    String operatingSystemVersion;
    int guaranteePeriod;
    double price;

    public Laptops(String manufacturer, String model, String bodyColor, double screenDiagonal, String processor, String videoCart, int randomAccessMemory,
                   int numberOfProcessorCores, int hardDiskCapacity, boolean wedCamera, boolean keyboardBacklight,
                   String operatingSystemVersion, int guaranteePeriod, double price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.bodyColor = bodyColor;
        this.screenDiagonal = screenDiagonal;
        this.processor = processor;
        this.videoCart = videoCart;
        this.randomAccessMemory = randomAccessMemory;
        this.numberOfProcessorCores = numberOfProcessorCores;
        this.hardDiskCapacity = hardDiskCapacity;
        this.wedCamera = wedCamera;
        this.keyboardBacklight = keyboardBacklight;
        this.operatingSystemVersion = operatingSystemVersion;
        this.guaranteePeriod = guaranteePeriod;
        this.price = price;
    }
//    StringBuilder builder = new StringBuilder();
//        builder.append(name).append(" ").append(age);
//        return builder.toString();
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(manufacturer).append(" ").append(bodyColor).append(" ").append(screenDiagonal).append(" ").append(price);
        return builder.toString();
    }
}
