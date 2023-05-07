package lesson2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Напишите метод, который вернет содержимое текущей папки в виде массива строк.
//        Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
//        Обработайте ошибки с помощью try-catch конструкции. В случае возникновения исключения, оно должно записаться в лог-файл.


    }
}
//    public static void main(String[] args) {
////        Дано число N (>0) и символы c1 и c2.
////                Написать метод, который вернет строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с c1.
//
//        Scanner cs = new Scanner(System.in);
//        char c1= 'A';
//        char c2= 'b';
//        System.out.println("Input amount of chars: ");
//        int amountOfChar = cs.nextInt();
//        String result = "";
//        char tempC = c2;
//        for (int i = 0; i< amountOfChar; i++) {
//            if (tempC == c1) {
//                result+=c2;
//                tempC = c2;
//            } else {
//                result+= c1;
//                tempC = c1;
//            }
//        }
//        System.out.println(result);
//    }
    /*второй вариант:
    Scanner cs = new Scanner(System.in);
    System.out.print("Input amount of chars: ");
    int amountOfChar = cs.nextInt();

    String[] c= new String[] {"A","b"};

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < amountOfChar; i++) {
        result.append(c[i % 2]);
    }
}
третье решение:

char a = 'A';
char b = 'b';
int n = 5;
String str = "" + a + b;
str = str.repeat(n / 2) + ((n % 2 == 1) ? a : "");

System.out.println(str);



//
//public static void main(String[] args) {
////        Напишите метод, который сжимает строку.
////        Пример: вход aaaabbbcdd.
//    String alfabet = "aaaabbbcdd";
//    String result = "";
//    int count = 1;
//
//    for (int i = 0; i< alfabet.length()-1; i++) {
//        if (alfabet.charAt(i+1) == alfabet.charAt(i)) {
//            count++;
//        }
//        else if (alfabet.charAt(i+1) != alfabet.charAt(i) && count == 1) {
//            result+=alfabet.charAt(i);
//            count = 1;
//        } else {
//            result += Character.toString(alfabet.charAt(i))+count;
//            count = 1;
//        }
//    }
//    result += Character.toString(alfabet.charAt(alfabet.length()-1))+count;
//    System.out.println(result);
//}
//}

    public static void main(String[] args) {
//        Напишите метод, который сжимает строку.
//        Пример: вход aaaabbbcdd.
        String alfabet = "aaaabbbcdd";
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 0; i< alfabet.length()-1; i++) {
            if (alfabet.charAt(i+1) != alfabet.charAt(i)) {;
                result.append(alfabet.charAt(i));
                if (count !=1) {
                    result.append(count);
                }
                count = 0;
            }
            count++;
        }
        result.append((alfabet.charAt(alfabet.length() - 1))).append(count);
        System.out.println(result);
    }
//} */
