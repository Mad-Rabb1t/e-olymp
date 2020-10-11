package solutions.p970;

import java.util.*;
import java.util.stream.Collectors;

public class MajorityElement {
    public static void main(String[] args) {
        HashMap<Integer, Integer> table = new HashMap<>();
        ArrayList<Integer> input = getInput();
        long length = input.size();
        for (Integer integer : input) {
            if (table.containsKey(integer)) {
                int count = table.get(integer) + 1;
                if (count > length / 2) {
                    System.out.println(integer);
                    return;
                } else
                    table.put(integer, count);
            } else
                table.put(integer, 1);
        }
        System.out.println("-1");
    }

    private static ArrayList<Integer> getInput() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        return (ArrayList<Integer>) Arrays.stream(scanner.nextLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
