package student;

public class Student {
  private String name;
  private int age;
  private int totalMarks;

  public Student(String name, int age, int totalMarks) {
    this.name = name;
    this.age = age;
    this.totalMarks = totalMarks;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getTotalMarks() {
    return totalMarks;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", age='" + age + '\'' +
        ", totalMarks=" + totalMarks +
        '}';
  }

  public void increaseTotalMarksWith(Student s2) {
    totalMarks += s2.totalMarks;
  }
}