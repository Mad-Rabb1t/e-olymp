package solutions.p9002;

import java.util.Scanner;

public class ChocolateLover {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long a = sc.nextInt();
        long b = sc.nextInt();
        long max = 0;

        if (n % 2 == 0) {
            max = (a + b) * n / 2;
        } else {
            long option1 = n / 2 * b + (n + 1) / 2 * a;
            long option2 = n / 2 * a + (n + 1) / 2 * b;
            max = Math.max(option1, option2);
        }
        System.out.println(max);
    }
}
