package oops;

class oop2 {
    static int a = 3;
    static int b;
    static void math(int x) {
      System.out.println("x = " + x);
      System.out.println("a = " + a);
      System.out.println("b = " + b);
    }

    // executes when class is loaded into the memory
    static {
      System.out.println("Static block initialized.");
      b = a * 4;
    }

    public static void main(String args[]) {
      math(32);
      System.out.println("Value of a is " + a);
      System.out.println("Value of b is " + b);
    }
}