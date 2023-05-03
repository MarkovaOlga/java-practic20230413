package hometask1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.time.LocalTime.*;

////1. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
//2. Задать одномерный массив и найти в нем минимальный и максимальный элементы;
//3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
// заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
// Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
//4. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
//        "Доброе утро, <Имя>!", если время от 05:00 до 11:59
//        "Добрый день, <Имя>!", если время от 12:00 до 17:59;
//        "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//        "Доброй ночи, <Имя>!", если время от 23:00 до 4:59

public class Main {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
    }
//4. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
//    //        "Доброе утро, <Имя>!", если время от 05:00 до 11:59
////        "Добрый день, <Имя>!", если время от 12:00 до 17:59;
////        "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
////        "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
    private static void ex4() {
        LocalTime time = now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        String newTime=time.format(formatter);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Введите Ваше имя: ");
        String name = myScanner.nextLine();
        int currentTime = Integer.parseInt(newTime);
        if (currentTime>=550 & currentTime<=1159){
            System.out.printf("Доброе утро, %s!%n", name);
        }
        if (currentTime>=1200 & currentTime<=1759){
            System.out.printf("Добрый день, %s!%n", name);
        }
        if (currentTime>=1800 & currentTime<=2259){
            System.out.printf("Добрый вечер, %s!%n", name);
        }
        if (currentTime>=2300 & currentTime<=2359 | currentTime>=0 & currentTime<=459){
            System.out.printf("Доброй ночи, %s!%n", name);
        }
    }


//3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
//   заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
//// Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
    private static void ex3() {
        int[][] newArr = new int[5][5];
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[i].length; j++) {
                if (i==j) {
                    newArr[i][j] = 1;
                }
                System.out.printf("%d", newArr[i][j]);
            }
            System.out.println();
        }
    }

    //2. Задать одномерный массив и найти в нем минимальный и максимальный элементы;
    private static void ex2() {
        Random random = new Random();
        int[] array = new int[7];
        for (int i=0; i<array.length; i++){
            array[i]=random.nextInt(1,20);
        }
        System.out.println(Arrays.toString(array));
        int maxValue = array[0];
        int minValue = array[0];
        for (int i=1; i < array.length; i++){
            if (maxValue<array[i]){
                maxValue=array[i];
           }
        }
        System.out.println("Максимальное значение: " + maxValue);
        for (int i=1; i < array.length; i++){
            if (minValue>array[i]){
                minValue=array[i];
            }
        }
        System.out.println("Минимальное значение: " + minValue);
    }
//
//    //1. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
    private static void ex1() {
        System.out.println(Arrays.toString(createArray(5, 8)));
    }
    static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}
