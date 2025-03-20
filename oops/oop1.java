package oops;

public class oop1 {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student(101, "Nischal Paliwal", "3-06-2004", 20, 11, 'A');
        // System.out.println(students[0]);
    }
}

// store data of 5 students
class Student {
    private int rollNo;
    private String name;
    private String dob;
    private int age;
    private int standard;
    private char section;

    public Student(int rollNo, String name, String dob, int age, int standard, char section) {
        this.rollNo = rollNo;
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.standard = standard;
        this.section = section;
    }
}