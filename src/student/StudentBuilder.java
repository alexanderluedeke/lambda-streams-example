package student;

import java.util.Optional;

public class StudentBuilder {
  private String name;
  private int totalMarks;

  public StudentBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public StudentBuilder withTotalMarks(int totalMarks) {
    this.totalMarks = totalMarks;
    return this;
  }

  public Student build() {
    return new Student(
        Optional.ofNullable(name).orElse("Unkown"),
        Optional.ofNullable(totalMarks).orElse(0)
    );
  }
}
