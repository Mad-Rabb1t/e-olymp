package solutions.p2321;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        int[] ints = Arrays.stream(in.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(ints);
        StringBuilder sb = new StringBuilder();
        for (int i :
                ints) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
