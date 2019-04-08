package streamlibrary;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Leo", 21),
                new Person("Peter", 23),
                new Person("Boris", 18),
                new Person("Alex", 33));

        List<Person>filtered = persons.stream()
                .filter(p -> p.name.startsWith("P"))
                .collect(Collectors.toList());//collect преобразует последовательность в List, Set или Map
        System.out.println(filtered);

        Map<Integer, List<Person>> personByAge = persons.stream()
                .collect(Collectors.groupingBy(p -> p.age));
        personByAge.forEach((age, p) ->
                System.out.format("age %s: %s\n", age, p));
    }

}
