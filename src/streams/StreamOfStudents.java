package streams;

import student.Student;
import student.StudentBuilder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamOfStudents {

  private static final StudentBuilder student = new StudentBuilder();
  private static final List<Student> students = Arrays.asList(
    student.withName("Peter").withAge(22).withTotalMarks(3).build(),
    student.withName("Alex").withAge(23).withTotalMarks(1).build(),
    student.withName("Stefan").withAge(24).withTotalMarks(2).build()
  );
  private static final List<Student> moreStudents = Arrays.asList(
    student.withName("Peter").withAge(22).withTotalMarks(3).build(),
    student.withName("Tom").withAge(32).withTotalMarks(1).build(),
    student.withName("Stefan").withAge(24).withTotalMarks(2).build()
  );

  public static void main(String[] args) {
    System.out.println("\nAll students:");
    students.forEach(System.out::println);

    System.out.println("\nGood students:");
    students.stream().filter(isGoodInTests()).map(Student::getName).forEach(System.out::println);

    System.out.println("\nThe best student:");
    students.stream().reduce((s1, s2) ->
      s1.getTotalMarks() > s2.getTotalMarks() ? s1 : s2).ifPresent(System.out::println);

    System.out.println("\nAverage total notes:");
    System.out.println(students.stream().reduce(new Student("", 20, 0), (s1, s2) -> {
      s1.increaseTotalMarksWith(s2);
      return s1;
    }).getTotalMarks() / students.size());

    System.out.println("\nFind first name with an 'e':");
    students.stream().filter(student -> student.getName().contains("e")).findFirst()
      .ifPresent(System.out::println);

    System.out.println("\nFind any name with an 'e':");
    students.stream().filter(student -> student.getName().contains("e")).findAny()
      .ifPresent(System.out::println);

    System.out.println("\nStudents sorted by notes:");
    Comparator<Student> totalMarksComparator = (s1, s2) -> Integer.compare(s1.getTotalMarks(), s2.getTotalMarks());
    students.stream()
      .sorted(totalMarksComparator)
      .forEach(System.out::println);

    System.out.println("\nStudents printed by a consumer:");
    students.forEach(print());

    System.out.println("\nStudents sum of ages:");
    int totalOfAges = students.stream().mapToInt((Student p) -> p.getAge()).sum();
    System.out.println(totalOfAges);

    System.out.println("\nPrint two lists of students in parallel: ");
    IntStream.range(0, maxSize(students, moreStudents)).mapToObj(
      idx -> students.get(idx).getName() + " " + moreStudents.get(idx).getName()
    ).forEach(System.out::println);

    System.out.println("\nCheck two lists of students for equality by name: ");
    System.out.println(
      IntStream.range(0, maxSize(students, moreStudents)).allMatch(
        idx ->
          students.get(idx).getName().equals(moreStudents.get(idx).getName())
      )
    );

    System.out.println("\nPrint all students in one line:");
    List<String> names = students.stream().map(s -> s.getName()).collect(Collectors.toList());
    System.out.println(String.join(", ", names));
  }

  private static Predicate<Student> isGoodInTests() {
    return student -> student.getTotalMarks() > 2;
  }

  private static Consumer<Student> print() {
    return System.out::println;
  }

  private static int maxSize(List<Student> students, List<Student> moreStudents) {
    int size = students.size();
    if (moreStudents.size() > size) {
      size = moreStudents.size();
    }
    ;
    return size;
  }
}