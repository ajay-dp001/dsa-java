package oops.functionalprog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionalInterfaceDemo {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();

    Consumer<String> c1Adding = s -> list.add(s);
    Consumer<String> c1 = list::add;

    Consumer<String> c2Print = s -> System.out.println(s);
    Consumer<String> c2 = System.out::println;

    Consumer<String> c3 = c1.andThen(c2);

    //FlatMap Concept
    List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    List<Integer> l2 = Arrays.asList(2, 4, 6);
    List<Integer> l3 = Arrays.asList(3, 5, 7);

    List<List<Integer>> listOfList = Arrays.asList(l1, l2, l3);
    System.out.println(listOfList);
    Function<List<?>, Integer> sizeOfList = List::size;
    Function<List<Integer>, Stream<Integer>> flatMapper = Collection::stream;
    listOfList.stream()
        .map(sizeOfList)
        .forEach(System.out::println);

    listOfList.stream()
        .flatMap(flatMapper)
        .forEach(System.out::println);
  }

}
