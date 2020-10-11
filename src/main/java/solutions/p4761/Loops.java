package solutions.p4761;

import java.util.Arrays;
import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            int[] l = Arrays.stream(input.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            if (l[i] == 1) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
