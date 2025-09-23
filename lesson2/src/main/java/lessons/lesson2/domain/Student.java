package lessons.lesson2.domain;


public class Student extends Person {
    private final String university;

    public Student(String name, Integer age, String university) {
        super(name, age);
        this.university = university;
    }

    @Override
    public void introduce() {
        System.out.printf("Hi, im %s, %d years ild. Studying in %s.%n", this.name, this.age, this.university);
    }
}
