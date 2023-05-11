package lesson3;
import java.util.*;


public class Main {
    public static void main(String[] args) {
    //    ex1();
    //    ex2();
        ex3();

    }
    //Пройти по списку из предыдущего задания и удалить повторяющиеся элементы.
    private static void ex3() {
        String[] planetsNamesStringArray = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Neptune", "Uranus", "Pluto"};
        List<String> randomSolarSystem = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            randomSolarSystem.add(planetsNamesStringArray[random.nextInt(planetsNamesStringArray.length)]);
        }
        randomSolarSystem.sort(Comparator.naturalOrder());
        System.out.println(randomSolarSystem);
        for (int i = 0; i < randomSolarSystem.size()-1; i++) {
            String first = randomSolarSystem.get(i);
            String second = randomSolarSystem.get(i+1);
            if (second.equals(first)){
                randomSolarSystem.remove(i);
                i--;
            } else {
                first = randomSolarSystem.get(i+1);
            }
        }
        System.out.println(randomSolarSystem);
    }

//    Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
//    Вывести название каждой планеты и количество его повторений в списке.

    private static void ex2() {
        String[] planetsNamesStringArray = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Neptune", "Uranus", "Pluto"};
        List<String> randomSolarSystem = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            randomSolarSystem.add(planetsNamesStringArray[random.nextInt(planetsNamesStringArray.length)]);
        }
        randomSolarSystem.sort(Comparator.naturalOrder());
        System.out.println(randomSolarSystem);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < planetsNamesStringArray.length; i++) {
            int count=0;
            for (var item: randomSolarSystem){
                if (item.equals(planetsNamesStringArray[i]))
                    count++;
            }
        sb.append(planetsNamesStringArray[i]).append(": ").append(count).append("\n");
        }
        System.out.println(sb);
    }
//    int venus = list.indexOf("Venus");
//    System.out.println(venus);
//    int uranus = list.indexOf("Uranus");
//    System.out.println(uranus);
//    int mercury = list.indexOf("Mercury");
//    System.out.println(mercury);


            


//    Заполнить список десятью случайными числами.
//    Отсортировать список методом sort() и вывести его на экран.

    private static void ex1() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i= 0; i <100; i++){
            list.add(random.nextInt(100));
        }
        Collections.sort(list);
        System.out.println(list);

    }
}
