package solutions.p5198;

import java.util.Arrays;
import java.util.Scanner;

public class ModularExponentiation {
    private static class Triplet{
        int x;
        int n;
        int m;

        protected Triplet(int x, int n, int m){
            this.x = x;
            this.n = n;
            this.m = m;
        }
    }
    public static void main(String[] args) {
        System.out.print(calculate(getInput()));
    }

    private static int calculate(Triplet input) {
        return (((int) Math.pow(input.n, input.x)) % input.m) - 1;
    }

    private static Triplet getInput() {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        return new Triplet(input[0], input[1], input[2]);
    }
}
