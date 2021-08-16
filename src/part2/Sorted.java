package part2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*Метод принимает на вход список из строк (можно список из Задания 1).
Возвращает список этих строк в верхнем регистре и отсортированные по убыванию (от Z до А).*/

public class Sorted {
    public static void main(String[] args) {
        List<String> namesList = new ArrayList<>();
        namesList.add("Ivan");
        namesList.add("Vlad");
        namesList.add("Peter");
        namesList.add("Volodya");
        namesList.add("Slava");

        namesList.stream().
                map(s -> (s.toUpperCase())).
                sorted(Comparator.reverseOrder()).
                forEach(s -> System.out.println(s));
    }

}
