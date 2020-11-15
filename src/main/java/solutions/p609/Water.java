package solutions.p609;

import java.util.*;
import java.util.stream.Collectors;

public class Water {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split("\\s");
        int k = Integer.parseInt(in[1]);
        Deque<Long> cans = Arrays.stream(sc.nextLine().split("\\s")).map(Long::parseLong)
                .sorted().collect(Collectors.toCollection(ArrayDeque::new));
        if (cans.stream().anyMatch(c -> c > k)) {
            System.out.println("Impossible");
            return;
        }

        int carry = 0;
        while (cans.size() > 1) {
            if (cans.peekFirst() + cans.peekLast() <= k) {
                cans.removeFirst();
            }
            cans.removeLast();
            carry++;
        }
        if (cans.size() == 1) carry++;
        System.out.println(carry);
    }
}
