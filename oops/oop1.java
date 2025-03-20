package oops;

public class oop1 {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student(101, "Nischal Paliwal", "3-06-2004", 20, 11, 'A');
        // System.out.println(students[0]);
        Integer num = 45;
        System.out.println(num.hashCode());

        Integer a = 5;
        Integer b = 6;

        swap(a, b);
        System.out.println(a + "  " + b); // swapping didn't happened

        final int phoneNo = 701;
        // phoneNo = 343; value of variable cannot be changed
        // final variables must be initialized with a value while declaration
        final int[] arr = {1, 2, 3, 4, 5, 6};
        arr[2] = 1;
        
    }

    static void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
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

    public Student() {
        this ("Raghav");
    }

    public Student(String name) {
        this.name = name;
    }
}