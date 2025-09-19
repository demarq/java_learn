package lessons.lesson2;

public class Person {
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.printf("Hi, I'm %s, %d years old%n", this.name, this.age);
    }
}
