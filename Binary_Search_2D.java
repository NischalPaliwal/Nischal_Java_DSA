import java.util.Scanner;
public class Binary_Search_2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int fibo = (int)Math.pow((1 + Math.sqrt(5)) / 2, n) - (int)Math.pow((1 - Math.sqrt(5)) / 2, n); 
        System.out.println(fibo / (int)Math.sqrt(5));
    }
}
