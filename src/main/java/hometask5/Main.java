package hometask5;

import java.util.*;

//1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
//        Пусть дан список сотрудников:
//        Иван Иванов
//        Светлана Петрова
//        Кристина Белова
//        Анна Мусина
//        Анна Крутова
//        Иван Юрин
//        Петр Лыков
//        Павел Чернов
//        Петр Чернышов
//        Мария Федорова
//        Марина Светлова
//        Мария Савина
//        Мария Рыкова
//        Марина Лугова
//        Анна Владимирова
//        Иван Мечников
//        Петр Петин
//        Иван Ежов
// 2. Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
public class Main {
    public static void main(String[] args) {
        ex1();
        ex2();
    }

    private static void ex2() {
        String[] listOfEmpoloyees = {"Иван Иванов", "Светлана Петрова","Кристина Белова","Анна Мусина","Анна Крутова",
                "Иван Юрин","Петр Лыков","Павел Чернов","Петр Чернышов","Мария Федорова","Марина Светлова","Мария Савина",
                "Мария Рыкова","Марина Лугова","Анна Владимирова","Иван Мечников","Петр Петин","Иван Ежов"};
        HashMap<String, Integer> namesOfEmployees = new HashMap<>();
        List<String> names = new ArrayList<>();

        for (String s: listOfEmpoloyees) {
            String[] s2 = s.split(" ");
            String name = s2[0];
            names.add(name);
        }
        names.sort(Comparator.naturalOrder());
        System.out.println(names);
        for (String item: names) {
            int count=1;
            if (!namesOfEmployees.containsKey(item)) {
                 namesOfEmployees.put(item,count);
            } else {
                namesOfEmployees.put(item, namesOfEmployees.get(item) + 1);
            }
        }
//        for (Map.Entry<String, Integer> entry : namesOfEmployees.entrySet()) {
//            System.out.printf("%s : %s%n", entry.getKey(), entry.getValue());
//        }
        namesOfEmployees.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue()
                .reversed()).forEach(System.out::println);
    }
    private static void ex1() {
        HashMap<String, String> phoneBook = new HashMap<>();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Вы хотите добавить номер телефона в справочник? Введите 1, если ДА. Введите 0, если НЕТ.");
            String answer = in.nextLine();
            if (answer.equals("1")) {
                System.out.print("Введите фамилию и имя: ");
                String lastFirstName = in.nextLine();
                System.out.print("Введите номер телефона: ");
                String phoneNumber = in.nextLine();
                if (!phoneBook.containsKey(lastFirstName)) {
                    phoneBook.put(lastFirstName, phoneNumber);
                } else {
                    phoneBook.put(lastFirstName, phoneBook.get(lastFirstName) + ", " +  phoneNumber);
                }
            } else {
                break;
            }
        }
        Map<String, String> sortedPhoneBook = new TreeMap<>(phoneBook);
        for (Map.Entry<String, String> entry : sortedPhoneBook.entrySet()) {
            System.out.printf("%s\t : \t%s%n", entry.getKey(), entry.getValue());
        }
    }
}

