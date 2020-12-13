package solutions.p978;

import java.util.Scanner;

public class GetATree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] branch = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            branch[i] = i;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (branch[a] != branch[b]) {
                ans.append(a).append(" ").append(b).append("\n");
                int c = branch[a];
                int d = branch[b];
                for (int j = 0; j <= n; j++) {
                    if (branch[j] == d) branch[j] = c;
                }
            }
        }
        System.out.println(ans.toString().trim());
    }
}
