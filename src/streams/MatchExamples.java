package streams;

import student.Student;
import student.StudentBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MatchExamples {

  private static final StudentBuilder student = new StudentBuilder();
  private static final List<Student> students = Arrays.asList(
    student.withName("Peter").withAge(19).withTotalMarks(3).build(),
    student.withName("Alex").withAge(21).withTotalMarks(1).build(),
    student.withName("Stefan").withAge(34).withTotalMarks(2).build()
  );

  public static void main(String[] args) {
    System.out.println("\nAll students:");
    students.forEach(System.out::println);

    System.out.print("\nAre all students over 20?");
    System.out.printf(" %s",
      students.stream().allMatch(isOld(20))
    );

    System.out.print("\nAre all students over 16?");
    System.out.printf(" %s",
      students.stream().allMatch(isOld(16))
    );

    System.out.print("\nIs any students over 30?");
    System.out.printf(" %s",
      students.stream().anyMatch(isOld(30))
    );

    System.out.print("\nIs no students over 50?");
    System.out.printf(" %s",
      students.stream().noneMatch(isOld(50))
    );
  }

  private static Predicate<Student> isOld(int threshold) {
    return student -> student.getAge() > threshold;
  }
}
