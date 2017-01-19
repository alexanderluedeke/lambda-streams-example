package lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaExpression {
  public static void main(String[] args) {
    List<String> stringList = Arrays.asList("String1", "String2", "String3");

    stringList.forEach(stringListValue -> {
      if ("String1".equals(stringListValue)) {
        System.out.println(stringListValue);
      }
    });
  }
}