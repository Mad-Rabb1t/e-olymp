package solutions.p138;

import java.util.Scanner;

public class CashMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] banknotes = {500, 200, 100, 50, 20, 10};
        int sum = 0;
        for (int c : banknotes) {
            int cnt = n/c;
            n = n - cnt*c;
            sum = sum + cnt;
        }
        System.out.println(n==0 ? sum : "-1");
    }
}
