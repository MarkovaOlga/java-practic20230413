package hometask2;
import java.io.File;
import java.lang.String;
import java.util.Arrays;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        ex1("D:\\Документы\\от Оли\\печать детям\\Мое обучение\\JAVA\\java-practic20230413");
        ex2();
    }
    //1. Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json-строки.
//        Если значение null, то параметр не должен попадать в запрос.
//        Пример 1:
//        Параметры для фильтрации: {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"}
//        Результат: SELECT * FROM USER WHERE name = 'Ivanov' and country = 'Russia' and city = 'Moscow';
//
//        Пример 2:
//        Параметры для фильтрации: {"name:null", "country:null", "city:null", "age:null"}
//        Результат: SELECT * FROM USER;
//        .
    private static void ex2() {
        String str = "{\"name:Ivanov\" \"country:Russia\" \"city:Moscow\" \"age:null\"}";
        str = str.replaceAll("[\"{}]", "");
        String[] words = str.split(" ");
        System.out.println(Arrays.toString(words));
        StringBuilder newSb = new StringBuilder("SELECT * FROM USER WHERE ");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains("null")) {
                words[i] = "";
                count++;
            } else {
                words[i] = words[i].replace(":", " = '");
                newSb.append(words[i] + "' and ");
            }
        }
        if (count == words.length) {
            newSb.delete(18, 25);
        }
        String lastSb = newSb.toString();
        if (lastSb.endsWith("and "))
            System.out.println(lastSb.substring(0, lastSb.length() - 5)+";");
        else {
            System.out.println(lastSb+";");
        }
    }


    //2.Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида:
//        1 Расширение файла: txt
//        2 Расширение файла: pdf
//        3 Расширение файла:
//        4 Расширение файла: jpg
    private static void ex1(String pathDir) {
        File file = new File(pathDir);
        if (!(file.exists() || file.isDirectory())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int num = 1;
        for (String fileName : file.list()) {
            String expansion ="";
            if (fileName.contains(".")) {
                int i = fileName.lastIndexOf(".");
                expansion = fileName.substring(i+1);
            }
            sb.append(num + " Расширение файла: "+ expansion).append(System.lineSeparator());
            num++;
        }
        System.out.println(sb);
    }
}

