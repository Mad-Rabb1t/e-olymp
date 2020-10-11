package solutions.p4763;

import java.util.Arrays;
import java.util.Scanner;

public class FromListOfEdgesToAdjacencyMatrix {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = Integer.parseInt(input.next());
        int[][] array = new int[n][n];
        for (int[] row : array) Arrays.fill(row, 0);
        while (m-- > 0) {
            int i = input.nextInt() - 1, j = input.nextInt() - 1;
            array[i][j] = 1;
            array[j][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}