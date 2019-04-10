package streamlibrary;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example1 {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("ab2", "ab1", "b1", "c2", "c1");
        myList.stream()//на вход подаем коллекцию myList, запускаем stream
                .filter(s -> s.startsWith("a"))//фильтруем значения начинающиеся с a
                .map(String::toUpperCase)//пройтись по оставшимся стринговым значениям и перевести их в верхний регистр
                .sorted()//сортировка
                .forEach(System.out::println);//вывод на консоль оставшихся значений
                //(во что превращается наш поток::то, что мы хотим сделать)

        Stream.of("a1", "a2", "a3")
                .findFirst()//возвращает первый элемент потока
                .ifPresent(System.out::println);

        IntStream.range(2, 4)//возвращает инкримент числа с начального до конечного (исключая последнее)
                .forEach(System.out::println);

        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)//возвращает поток результат изменения входящего потока
                .average()//возвращает среднее арифметическое
                .ifPresent(System.out::println);

        Stream.of("a715", "ac60", "ab37")
                .map(s -> s.substring(2))//убираем 2 символа  каждой строки массива
                .mapToInt(Integer::parseInt)//преобразуем в int
                .max()//максимальное число
                .ifPresent(System.out::println);

    }
}
