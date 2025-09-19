package lessons.lesson2;


public class Student extends Person {
    String university;

    public Student(String name, Integer age, String university) {
        super(name, age);
        this.university = university;
    }

    public void introduce() {
        System.out.printf("Hi, im %s, %d years ild. Studying in %s.%n", this.name, this.age, this.university);
    }
}
