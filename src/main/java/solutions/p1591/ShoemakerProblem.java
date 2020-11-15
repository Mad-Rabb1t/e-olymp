package solutions.p1591;

import java.util.*;

class Job {
    int s, t, id;

    public Job(int s, int t, int id) {
        this.s = s;
        this.t = t;
        this.id = id;
    }
}

public class ShoemakerProblem {
    public static class CustomComp implements Comparator<Job> {
        public int compare(Job a, Job b) {
            if (a.s * b.t == b.s * a.t) return a.id - b.id;
            return a.s * b.t - b.s * a.t;
        }
    }

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        while (con.hasNext()) {
            int n = con.nextInt();
            ArrayList<Job> jobs = new ArrayList<Job>();
            for (int i = 1; i <= n; i++) {
                int s = con.nextInt();
                int t = con.nextInt();
                jobs.add(new Job(s, t, i));
            }

            jobs.sort(new CustomComp());

            for (int i = 0; i < n; i++)
                System.out.print(jobs.get(i).id + " ");
            System.out.println();
        }
        con.close();
    }
}
