package lesson4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ex1();
    }
//    Реализовать консольное приложение, которое:
//    1.Принимает от пользователя строку вида
//    text~num
//    2.Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
//    3.Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
//    4. Продумать систему добавления элементов на индексы, превышающие размер
//    5. Добавить проверки ввода
//    6. Добавить еще команд на выбор
//    public class Examples {
//public static void main(String[] args) {
//Scanner scanner = new Scanner(System.in);
//
//LinkedList<String> linkedList = new LinkedList<>();
////#6 - filter input
////SSSS~NNN - true
////SSS#~NNN - true
////NNN~NNN - true
////SSSS~SSS - fase
////SSS~~NNN
////^[A-Z]{.}~\d{.} - true$
//// String regex = "^(?i)[A-Z]{3,}~\\d{3,} - true$";
//// boolean matches = Pattern.matches(regex, tmpValue);
//// System.out.println(matches);
//boolean isNotCorrect = true;
//String tmpValue;
//int index = 0;
//int tildaPosition = 0;
//do {
//System.out.print(">_");
//tmpValue = scanner.nextLine();
//if (tmpValue.equals("stop")) {
//break;
//}
//tildaPosition = tmpValue.indexOf('~');
////System.out.println(tildaPosition);
//
////check input
    private static void ex1() {
        Scanner in = new Scanner(System.in);
        LinkedList<String> wordList = new LinkedList<>();
        Collections.addAll(wordList, "apple","orange","banana","tomato","strawberry","melon");

        while (true) {
            System.out.println();
            System.out.print("Введите строку: ");
            String inputString = in.nextLine();

            if (inputString.trim().length()==0) {
            // if(inputString.isBlank()) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            if (inputString.equalsIgnoreCase("каша не вари")) {
                break;
            }
            if (inputString.equalsIgnoreCase("print~all")) {
                printAllNotNullValues(wordList);
                continue;
            }
            if (!inputString.contains("~")) {
                System.out.println("Строка не содержит тильду");
                continue;
            }

            String[] parts = inputString.split("~");

            if (parts.length != 2) {
                System.out.println("Ошибка ввода шаблона. Должно быть \"word-num\". Пример: apple~6");
                continue;
            }

            String word = parts[0];
            int num=0;

            try {
                num = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Выражение не содержит числа");
                continue;
            }
            if (num<1) {
                System.out.println("Введите num более 1");
                continue;
            }
            if (word.equalsIgnoreCase("print")) {
                if (isNumberInRange(num,wordList.size()) || valueIsNull(wordList,num)) {
                    System.out.println("Указанного значения не существует");
                } else {
                    System.out.printf("Под номером %d находится слово %s%n", num, wordList.get(num-1));
                    wordList.remove(num -1);
                }
            } else if (isNumberInRange(num, wordList.size())) {
                String oldWord = wordList.get(num -1);

                if (valueIsNull(wordList,num)) {
                    printAddMessage(word, num);
                } else {
                    printSetMessage(word, num, oldWord);
                }
                wordList.set(num -1, word);
            } else {
                int nullCount = num - wordList.size() - 1;
                addNulls(wordList, nullCount);
                wordList.add(word);
                printAddMessage(word, num);
            }
        }
    }

    private static void addNulls(LinkedList<String> wordList, int count) {
        for (int i = 0; i < count; i++) {
            wordList.add(null);
        }
    }

    private static void printSetMessage(String word, int num, String oldWord) {
        System.out.printf("Слово %s заменило на позиции %d слово %s%n", word, num, oldWord);
    }

    private static void printAddMessage(String word, int num) {
        System.out.printf("Слово %s добавлено на позицию %d%n", word, num);
    }

    private static boolean valueIsNull(LinkedList<String> wordList, int num) {
        return wordList.get(num-1) == null;
    }

    private static boolean isNumberInRange(int num, int size) {
        return num >=1 & num<= size;
    }

    private static void printAllNotNullValues(LinkedList<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i) != null) {
                System.out.printf("%d) %s%n", i+1, wordList.get(i));
            }
        }
    }
//        Scanner scanner = new Scanner(System.in);
//        System.out.print(">_");
//
//
//        LinkedList<String> linkedList = new LinkedList<>();
//        String tmpValue;
//        int tildaPosition= 0;
//        int index= 0;
//        boolean isNotCorrect = false;
//        do {
//            tmpValue = scanner.nextLine();
//            tildaPosition = tmpValue.indexOf('~');
//            try {
//                index = Integer.parseInt(tmpValue.substring(tildaPosition + 1));
//            } catch (NumberFormatException e) {
//                System.out.println("Wrong input: " + "position: " + e.getMessage());
//                isNotCorrect = true;
//            }
//        } while (isNotCorrect);
//        linkedList.add(index, tmpValue.substring(0,tildaPosition));
//        printLinkedlist(linkedList);
//
//    }
//
//    private static void printLinkedlist(LinkedList<String> linkedList) {
//        for (int i = 0; i < linkedList.size(); i++) {
//            System.out.printf("[%d]:%s%n",i,linkedList.get(i));
//        }
//
//        }

}
