package part3;
/*
Дан массив:["1, 2, 0", "4, 5"] Получить из массива все числа, вернуть в отсортированном виде,
        разделенные запятой, то есть    "0, 1, 2, 4, 5"*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraySorted {

    public static void main(String[] args) {

        String[] stringsArray = new String[]{"1, 2, 0", "4, 5"};

        List<String> listStream = Arrays.stream(stringsArray).
                flatMap(s -> Arrays.stream(s.split(" "))).
                map(s -> s.replace(",", "")).
                sorted().
                collect(Collectors.toList());

        System.out.println(listStream);
    }
}
