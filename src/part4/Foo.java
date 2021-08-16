package part4;

import java.math.BigInteger;
import java.util.stream.Stream;

/*Задание 4#
Используя Stream.iterate сделайте бесконечный стрим рандомных чисел, но не используя Math.random. Реализуйте свой
"линейный конгруэнтный генератор". Для этого начните с x[0] = seed и затем каждый следующий элемент
x[n + 1] = 1 (a x[n] + c) % m, для корректных значений a, c, и m. Необходимо имплементировать метод,
который принимает на вход параметры a, c, m и seed и возвращает Stream<Long>. Для теста используйте данные
a = 25214903917, c = 11 и m = 2^48 (2 в степени 48).
*/

public class Foo {

    public static void main(String[] args) {
        generatePseudoRandom(25214903917l, 11l, 0x1_0000_0000_0000L, 1l);
    }

    public static void generatePseudoRandom(long a, long c, long m, long seed) {

        BigInteger maxLong = BigInteger.valueOf(Long.MAX_VALUE);

        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigC = BigInteger.valueOf(c);
        BigInteger bigM = BigInteger.valueOf(m);
        BigInteger bigSeed = BigInteger.valueOf(seed);

        Stream.iterate(bigSeed, (BigInteger x) -> {
                    BigInteger xNext = bigA.multiply(x).add(bigC).mod(bigM);
                    if (xNext.compareTo(maxLong) > 0) {
                        xNext = xNext.shiftRight(16);
                    }
                    return xNext;
                }
        ).forEach(bigInteger -> System.out.println(bigInteger));
    }
}

