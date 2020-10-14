package solutions.p8236;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import static java.lang.Math.abs;

public class SortEvensAndOdds {
    private static class CustomComp implements Comparator<Integer> {

        @Override
        public int compare(Integer x, Integer y) {
            if (abs(x % 2) != abs(y % 2))
                return abs(y % 2) - abs(x % 2);
            if (x % 2 == 0) return y - x;
            return x - y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        Arrays.stream(in.nextLine().split("\\s")).map(Integer::parseInt).sorted(new CustomComp())
                .forEach(i -> System.out.print(i + " "));
    }
}
