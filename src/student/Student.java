package student;

public class Student {
  private String name;
  private int totalMarks;

  public Student(String name, int totalMarks) {
    this.name = name;
    this.totalMarks = totalMarks;
  }

  public String getName() {
    return name;
  }

  public int getTotalMarks() {
    return totalMarks;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", totalMarks=" + totalMarks +
        '}';
  }

  // NOT NICE
  public void setName(String name) {
    this.name = name;
  }

  public void setTotalMarks(int totalMarks) {
    this.totalMarks = totalMarks;
  }

  public void increaseTotalMarksWith(Student s2) {
    totalMarks += s2.totalMarks;
  }
}