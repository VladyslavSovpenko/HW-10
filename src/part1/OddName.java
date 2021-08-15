package part1;
/*Метод принимает на вход список имен. Вернуть строку в виде: "1. Ivan, 3. Peter ...", с именами из списка,
 стоящими под нечетным индексом (1, 3 и т.д.).
*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OddName {
    public static void main(String[] args) {
        OddName oddName = new OddName();
        List<String> namesList = new ArrayList<>();
        namesList.add("Ivan");
        namesList.add("Vlad");
        namesList.add("Peter");
        namesList.add("Volodya");
        namesList.add("Slava");

        List<String> namesOddList = IntStream.range(0, namesList.size()).
                filter(s -> (s % 2 == 0)).
                mapToObj(i -> namesList.get(i)).
                collect(Collectors.toList());
        System.out.println(oddName.print(namesOddList));
    }

    public String print(List<String> list) {
        int a = 1;
        String text = "";
        for (int i = 0; i < list.size(); i++) {
            text = text + a + "." + " " + list.get(i) + ", ";
            a += 2;

        }
        return text;
    }
}
