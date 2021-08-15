package part4;

/*Задание 4#
Используя Stream.iterate сделайте бесконечный стрим рандомных чисел, но не используя Math.random. Реализуйте свой
"линейный конгруэнтный генератор". Для этого начните с x[0] = seed и затем каждый следующий элемент
x[n + 1] = 1 (a x[n] + c) % m, для корректных значений a, c, и m. Необходимо имплементировать метод,
который принимает на вход параметры a, c, m и seed и возвращает Stream<Long>. Для теста используйте данные
a = 25214903917, c = 11 и m = 2^48 (2 в степени 48).

*/


import java.util.stream.Stream;

public class Foo {
    public static void main(String[] args) {
        Long a = 25214903917l;

        Long c = 11l;
        Long m = 0x1_0000_0000_0000L;

        Stream.iterate(1, x -> x < 1000L, x -> Math.toIntExact(((a * x + c) % m))).
                forEach(System.out::println);
    }
}

