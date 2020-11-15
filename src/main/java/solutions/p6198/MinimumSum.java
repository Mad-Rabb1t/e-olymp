package solutions.p6198;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        List<Long> input1 = Arrays.stream(sc.nextLine().split("\\s")).map(Long::parseLong)
                .sorted().collect(Collectors.toList());

        List<Long> input2 = Arrays.stream(sc.nextLine().split("\\s")).map(Long::parseLong)
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        long sum = 0;
        for (int i = 0; i < input1.size(); i++) {
            sum += input1.get(i) * input2.get(i);
        }

        System.out.println(sum);
    }
}
