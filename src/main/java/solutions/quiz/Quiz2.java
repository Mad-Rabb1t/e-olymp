package solutions.quiz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz2 {

    static class SumThread extends Thread {
        public int run(List<Integer> list){
            return list.stream().reduce(0, Integer::sum);
        }
    }

    public static void main(String[] args) throws IOException {
        String raw = new String(Files.readAllBytes(Paths.get("input.txt")));
        List<Integer> ints = Arrays.stream(raw.split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> l1 = ints.subList(0, (ints.size() - 1) / 2);
        List<Integer> l2 = ints.subList((ints.size() - 1) / 2, ints.size());
        SumThread sumThread1 = new SumThread();
        SumThread sumThread2 = new SumThread();
        int res1 = sumThread1.run(l1);
        int res2 = sumThread2.run(l2);
        System.out.println(res1 + res2);
    }
}
