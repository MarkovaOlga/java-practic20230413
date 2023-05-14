package hometask4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ex1();
        ex2();
    }
    //  2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
    private static void ex2() {
        LinkedList<String> wordList = new LinkedList<>();
        String[] newList = {"Я","очень", "люблю", "ходить", "гулять"};
        for (int i = 0; i < newList.length; i++) {
            wordList.add(newList[i]);
        }
        System.out.println(wordList);
        String temp ="";
        for (int i = 0; i < wordList.size()/2; i++) {
            temp = wordList.get(i);
            wordList.set(i, wordList.get(wordList.size()-i-1));
            wordList.set(wordList.size()-i-1, temp);
        }
        System.out.println(wordList);
    }

    //1. Реализовать консольное приложение, которое:
//    Принимает от пользователя и “запоминает” строки.
//    Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//    Если введено revert, удаляет предыдущую введенную строку из памяти.
//

    private static void ex1() {
        Scanner in = new Scanner(System.in);
        ArrayDeque<String> wordList = new ArrayDeque<>();

        while (true) {
            System.out.print("Введите строку: ");
            String inputString = in.nextLine();
            if (inputString.equalsIgnoreCase("stop")) {
                break;
            }
            if (inputString.equalsIgnoreCase("print")){
                System.out.println(wordList);
                String placeOne = wordList.removeFirst();
                String placeTwo = wordList.removeLast();
                wordList.offerFirst(placeTwo);
                wordList.offerLast(placeOne);
                break;
            }
            if (inputString.equalsIgnoreCase("revert")){
                System.out.println(wordList);
                String deleteWord = wordList.removeLast();
                System.out.printf("Слово %s удалено %n", deleteWord);
                System.out.println(wordList);
                continue;
            }
            if (inputString.trim().length()==0) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            wordList.add(inputString);
        }
        System.out.println(wordList);
    }
}
