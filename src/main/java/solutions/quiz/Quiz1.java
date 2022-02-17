package solutions.quiz;

import java.util.Scanner;

public class Quiz1 {

    interface Summa {
        int f(int a, int b);
    }

    public static void main(String[] args) {
        Summa s = (x, y) -> {
            int sum = 0;
            for (int i = x; i <= y; i++) {
                sum = sum + i * i;
            }
            return sum;
        };

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int result = s.f(a, b);
        System.out.println(result);
    }
}
