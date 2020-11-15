package solutions.p66;

import java.util.*;

class Segment {
    int start, fin;

    public Segment(int start, int fin) {
        this.start = start;
        this.fin = fin;
    }
}

public class TheDirectorsVisitors {
    public static class MyFun implements Comparator<Segment> {
        public int compare(Segment a, Segment b) {
            return a.fin - b.fin;
        }
    }

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        int n = con.nextInt();
        ArrayList<Segment> seg = new ArrayList<Segment>();

        for (int i = 0; i < n; i++) {
            String s = con.next();
            StringTokenizer st = new StringTokenizer(s, ":");
            int h = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int start = h * 60 + m;

            s = con.next();
            st = new StringTokenizer(s, ":");
            h = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int fin = h * 60 + m;
            seg.add(new Segment(start, fin));
        }

        seg.sort(new MyFun());

        int cur = 0, res = 1;
        for (int i = 1; i < seg.size(); i++) {
            if (seg.get(i).start >= seg.get(cur).fin) {
                cur = i;
                res++;
            }
        }

        System.out.println(res);
        con.close();
    }
}