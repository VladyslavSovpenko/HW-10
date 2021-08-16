package part5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*Напишите метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) который "перемешивает" элементы
из стримов first и second, останавливается тогда, когда у одного из стримов закончатся элементы.

кинуть в цикл 2 массива и поочередно класть в лист, сделать стрим из листа*/
public class NewArray {

    public static void main(String[] args) {

        List<String> firstList = Arrays.asList("A", "B", "C", "D");
        List<String> secondList = Arrays.asList("1", "2", "3");
        Stream<String> first = firstList.stream();
        Stream<String> second = secondList.stream();

        List<String> collect = zip(first, second).collect(Collectors.toList());
        System.out.println(collect);

    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

        boolean isFirst = false;
        boolean isSecond = true;
        int a = 0;
        int b = 0;

        List<T> list = new ArrayList<>();
        List<T> list1 = first.collect(Collectors.toList());
        List<T> list2 = second.collect(Collectors.toList());

        for (int i = 0; i < list1.size() + list2.size(); i++) {
            if (a == list1.size() || b == list2.size()) {
                break;
            } else if (isFirst == true) {
                list.add(list1.get(a));
                isFirst = false;
                isSecond = true;
                a++;
            } else if (isSecond = true) {
                list.add(list2.get(b));
                isFirst = true;
                isSecond = false;
                b++;
            }
        }
        return list.stream();
    }
}
