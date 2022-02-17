package solutions.quiz;

import java.util.Scanner;

public class Quiz3 {

    interface Divisor {
        int minDivisor(int n);
    }

    public static void main(String[] args) {
        Divisor d = (n) -> {
            if (n % 2 == 0) return 2;
            double sqrtOfN = Math.floor(Math.sqrt(n));
            for (int i = 3; i < sqrtOfN; i+=2) {
                if (n % i == 0) return i;
                if (i == sqrtOfN) return 1;
            }
            return -1;
        };

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = d.minDivisor(n);
        System.out.println(result);
    }
}
