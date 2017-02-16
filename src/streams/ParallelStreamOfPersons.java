package streams;

import student.Student;
import student.StudentBuilder;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamOfPersons {

  private static StudentBuilder student = new StudentBuilder();
  private static List<Student> students = Arrays.asList(
      student.withName("Peter").withAge(22).withTotalMarks(3).build(),
      student.withName("Alex").withAge(23).withTotalMarks(1).build(),
      student.withName("Stefan").withAge(24).withTotalMarks(2).build()
  );

  public static void main(String[] args) {
    System.out.println("\nAll students:");
    students.forEach(System.out::println);

    // allMatch
    boolean areAllPeopleOlderThan20 = students.parallelStream().allMatch(p -> p.getAge() > 20);
    System.out.println(areAllPeopleOlderThan20);

    // noneMatch
    boolean areNoPeopleOlderThan20 = students.parallelStream().noneMatch(p -> p.getAge() > 20);
    System.out.println(areNoPeopleOlderThan20);

    // anyMatch
    boolean areAnyPeopleOlderThan20 = students.parallelStream().anyMatch(p -> p.getAge() > 20);
    System.out.println(areAnyPeopleOlderThan20);
  }
}
