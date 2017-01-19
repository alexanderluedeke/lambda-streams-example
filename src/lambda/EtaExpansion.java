package lambda;

import java.util.Arrays;
    import java.util.List;

public class EtaExpansion {
  public static void main(String[] args) {
    List<String> stringList = Arrays.asList("String1","String2","String3");

    // Using method reference instead of
    // stringList.forEach(stringListValue -> System.out.println(stringListValue));
    stringList.forEach(System.out::println);
  }
}