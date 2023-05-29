package hometask6;
/* 1. Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
   2. Создать множество ноутбуков.
   3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру.
    Критерии фильтрации можно хранить в Map. Например:

        “Введите цифру, соответствующую необходимому критерию:
        1 - ОЗУ
        2 - Объём ЖД
        3 - Операционная система
        4 - Цвет …
        Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
        Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.*/

import lesson6.Cat;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Laptops laptop1 = new Laptops("Lenovo", "V15 G2ALC", "black", 15.6, "AMD Ryzen 7", "AMD Radeon Graphics",
                8, 8, 512, true, true, "no", 3, 47240);
        Laptops laptop2 = new Laptops("HP", "ProBook 450 G5", "white", 14.0, "Intel Core i5", "Intel HD Graphics 620",
                16, 4, 240, true, true, "no", 2, 38000);
        Laptops laptop3 = new Laptops("Honor", "MagicBook 15", "black", 15.6, "AMD Ryzen 5", "AMD Radeon Graphics",
                8, 6, 1000, true, false, "Windows 10", 2, 35750);
        Laptops laptop4 = new Laptops("MSI", "11UG-699XRU", "red", 16.0, "Intel Core i7", "NVIDIA GeForce",
                16, 8, 1000, true, false, "no", 1, 109560);
        Laptops laptop5 = new Laptops("Acer", "Aspire 5 A514-55", "black", 14.0, "Intel Core i3", "Intel UHD Graphics",
                8, 6, 512, true, false, "Windows 8", 1, 47500);
        Laptops laptop6 = new Laptops("Lenovo", "IdeaPad L3 15ITL6", "white", 14.0, "Intel Pentium Gold", "Intel UHD Graphics",
                4, 8, 512, true, true, "Windows 11", 3, 47240);
        Laptops laptop7 = new Laptops("HP", "PAVILION 15-bc300", "black", 15.6, "Intel Core i5", "NVIDIA GeForce GTX",
                6, 2, 128, false, true, "Windows 10", 3, 34000);
        Laptops laptop8 = new Laptops("Acer", "Nitro 5 AN515-54-50YQ", "black", 15.6, "Intel Core i5", "NVIDIA GeForce GTX",
                12, 4, 512, true, false, "Windows 11", 2, 47900);
        Laptops laptop9 = new Laptops("Lenovo", "ThinkPad E15", "black", 16.0, "AMD Ryzen 7", "AMD Radeon RX Vega 7",
                16, 8, 1000, false, false, "Windows 11", 1, 71990);
        Laptops laptop10 = new Laptops("Asus", "ROG Strix SCAR 17", "grey", 15.6, "AMD Ryzen 9", "NVIDIA GeForce RTX",
                16, 8, 1000, true, true, "no", 1, 259990);

        Set<Laptops> allLaptops = new HashSet<>();
        allLaptops.add(laptop1);
        allLaptops.add(laptop2);
        allLaptops.add(laptop3);
        allLaptops.add(laptop4);
        allLaptops.add(laptop5);
        allLaptops.add(laptop6);
        allLaptops.add(laptop7);
        allLaptops.add(laptop8);
        allLaptops.add(laptop9);
        allLaptops.add(laptop10);
        System.out.println(allLaptops);

        HashMap<String, String> characteristics = new HashMap<>();
        characteristics.put("1", "Производитель");
        characteristics.put("2", "Цвет");
        characteristics.put("3", "Диагональ экрана");
        characteristics.put("4", "Цена");
        Scanner in = new Scanner(System.in);

        HashMap<String, String> customersOrder = new HashMap<>(characteristics.size());
        System.out.print(characteristics);
        while (true) {
            System.out.println("\nВведите цифру, соответствующую необходимому критерию ноутбука. Если хотите завершить ввод параметров, введите 0: ");
            String answer = in.nextLine();
            if (answer.equals("1")) {
                System.out.print("Выберете производителя из списка (Lenovo, HP, Honor, MSI, Acer, Asus): ");
                String manufacturer = in.nextLine();
                customersOrder.put("Производитель", manufacturer);
                continue;
            }
            if (answer.equals("2")) {
                System.out.print("Выберете цвет из списка (black, white, red, grey): ");
                String color = in.nextLine();
                customersOrder.put("Цвет", color);
                continue;
            }
            if (answer.equals("3")) {
                System.out.print("Введите минимальную диагональ экрана: ");
                double screenDiagonal = Double.parseDouble(in.nextLine());
                customersOrder.put("Диагональ экрана", String.valueOf(screenDiagonal));
                continue;
            }
            if (answer.equals("4")) {
                System.out.print("Введите максимальную цену ноутбука: ");
                double price = Double.parseDouble(in.nextLine());
                customersOrder.put("Цена", String.valueOf(price));
                continue;
            } else {
                break;
            }
        }
        System.out.println(customersOrder);

        Set<Laptops> filterOfLaptops = new HashSet<>();
        for (Laptops item : allLaptops) {
            if (customersOrder.containsKey("Производитель")) {
                String manufacturer1 = customersOrder.get("Производитель");
                if (!item.manufacturer.contains(manufacturer1)) continue;
            }
            if (customersOrder.containsKey("Цвет")) {
                String color1 = customersOrder.get("Цвет");
                if (!item.bodyColor.contains(color1)) continue;
            }
            if (customersOrder.containsKey("Диагональ экрана")) {
                double screenDiagonal1 = Double.parseDouble(customersOrder.get("Диагональ экрана"));
                if (item.screenDiagonal <= screenDiagonal1) {
                    continue;
                }
            }
            if (customersOrder.containsKey("Цена")) {
                double price1 = Double.parseDouble(customersOrder.get("Цена"));
                if (item.price >= price1) {
                    continue;
                }
            }
            filterOfLaptops.add(item);
        }
        if (filterOfLaptops.isEmpty()) {
            System.out.println("К сожалению, нет ноутбуков, подходящих под Ваши параметры.");
        } else {
            System.out.println(filterOfLaptops);
        }
    }
}