package solutions.p4764;

import java.util.Arrays;
import java.util.Scanner;

public class DegreesOfVertices {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.stream(in.nextLine().split("\\s")).mapToInt(Integer::parseInt).sum());
        }
    }
}
