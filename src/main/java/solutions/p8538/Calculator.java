package solutions.p8538;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int op_count = 0;
        while (n > 1) {
            if (n % 3 == 0) n = n / 3;
            else n = n - 1;
            op_count++;
        }
        System.out.println(op_count);
    }
}
