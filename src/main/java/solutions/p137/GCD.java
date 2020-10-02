package solutions.p137;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GCD {
    public static void main(String[] args) {
        List<Integer> input = getInput();
        int gcd = findGCD(input, input.size());
        System.out.println(gcd);
    }

    private static List<Integer> getInput() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        return Arrays.stream(scanner.nextLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int findGCD(List<Integer> elems, int n) {
        int result = 0;
        for (int element : elems) {
            result = gcd(result, element);

            if (result == 1) {
                return 1;
            }
        }
        return result;
    }
}
