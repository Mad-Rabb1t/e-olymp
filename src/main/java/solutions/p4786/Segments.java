package solutions.p4786;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

class Segment
{
    int start, fin;

    public Segment(int start, int fin)
    {
        this.start = start;
        this.fin = fin;
    }
}


public class Segments {
    public static class SegComp implements Comparator<Segment>
    {
        public int compare(Segment a, Segment b)
        {
            return a.fin - b.fin;
        }
    }

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        int n = Integer.parseInt(con.nextLine());
        ArrayList<Segment> seg = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            String s = con.nextLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            seg.add(new Segment(start,end));
        }

        seg.sort(new SegComp());

        int cur = 0, res = 1;
        for (int i = 1; i < seg.size(); i++)
        {
            if (seg.get(i).start >= seg.get(cur).fin)
            {
                cur = i;
                res++;
            }
        }

        System.out.println(res);
        con.close();

    }

}
