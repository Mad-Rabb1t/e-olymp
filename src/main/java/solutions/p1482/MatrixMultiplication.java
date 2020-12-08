package solutions.p1482;

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int[][] ab = new int[a][b];
        for (int i = 0; i < a; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < b; j++) {
                ab[i][j] = Integer.parseInt(s[j]);
            }
        }
        String[] s1 = sc.nextLine().split(" ");
        int c = Integer.parseInt(s1[0]);
        int d = Integer.parseInt(s1[1]);
        int[][] cd = new int[c][d];
        if (c != b)
            System.out.println(-1);
        else {
            for (int i = 0; i < c; i++) {
                String[] s2 = sc.nextLine().split(" ");
                for (int j = 0; j < d; j++) {
                    cd[i][j] = Integer.parseInt(s2[j]);
                }
            }
            System.out.printf("%d %d\n", a, d);
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < d; j++) {
                    int sum = 0;
                    for (int k = 0; k < b; k++) {
                        sum = sum + ab[i][k] * cd[k][j];
                    }
                    System.out.println((sum + (j == d - 1 ? "\n" : " ")));
                }
            }
        }
    }
}
