package solutions.p8556;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Chain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] a = Arrays.stream(in.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] nex = new int[n];
        Stack<Integer> s = new Stack<>();
        s.push(1);

        for (int j = 1; j < n; j++) {
            if (a[s.peek()] >= a[j]) s.push(j);
            else {
                while (!s.empty() && a[s.peek()] < a[j]) {
                    int i = s.pop();
                    nex[i] = j;
                }
                s.push(j);
            }
        }

        int[] dp = new int[nex.length];
        for (int i = 1; i < nex.length; i++) {
            dp[i] = nex[i] == 0 ? 0 : dp[nex[i]] + 1;
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }
}
