package hometask3;
import java.util.*;
import java.util.Scanner;

import static java.util.Collections.list;


public class Main {
    public static void main(String[] args) {
        ex1();
        ex2();
    }
//2. Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так,
//         что на 0й позиции каждого внутреннего списка содержится название жанра, а на остальных позициях - названия книг.
//        Напишите метод для заполнения данной структуры(можно через консоль).
//        Пример:
//        "Классика", "Преступление и наказание", "Война и мир", "Анна Каренина".
//        "Научная фантастика", "Солярис", "Ночной дозор", "Братья Стругацкие".
//        "Детектив", "Десять негритят".
//        "Фантастика", "Хроники Нарнии", "Гарри Поттер и философский камень", "Грозовой перевал".
    private static void ex2() {
        List<String> listOfBooks= new ArrayList<>();
        Scanner iScanner = new Scanner(System.in);
        int countOfGanre = 3;
        for (int i = 0; i < countOfGanre; i++) {
            List<String> listOfGenre = new ArrayList<>();
            System.out.printf("Введите жанр книги: ");
            String genreOfBook = iScanner.nextLine();
            listOfGenre.add(genreOfBook);

            System.out.printf("Введите количество книг данного жанра: ");
            int countOfBooks = Integer.parseInt(iScanner.nextLine());
            for (int j = 0; j < countOfBooks; j++) {
                System.out.printf("Введите название книги: ");
                String nameOfBook = iScanner.nextLine();
                listOfGenre.add(nameOfBook);
            }
            listOfBooks.add(String.valueOf(listOfGenre));
        }
        System.out.println(listOfBooks);
    }

    //1. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа. Пройти по списку, найти и удалить целые числа.
//        Пример: {"Яблоко", "11", "13", "Апельсин", "Дыня", "17"} -> {"Яблоко", "Апельсин", "Дыня"}
    private static void ex1() {
        List<String> list= new ArrayList<>();
        String[] arr = {"Яблоко", "11", "13", "Апельсин", "Дыня", "17"};
        list.addAll(Arrays.asList(arr));
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            try {
                Integer.parseInt(list.get(i));
                list.remove(list.get(i));
                i--;
            } catch (Exception e) {
            }
        }
        System.out.println(list);
    }
}
