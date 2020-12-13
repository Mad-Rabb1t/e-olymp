package solutions.p8760;

import java.util.*;

public class DepthFirstSearch
{
    static ArrayList<Integer>[] g;
    static int[] used;
    static int n, m;

    static void dfs(int v)
    {
        System.out.print(v + " ");
        used[v] = 1;
        for(int i = 0; i < g[v].size(); i++)
        {
            int to = g[v].get(i);
            if (used[to] == 0) dfs(to);
        }
    }

    public static void main(String[] args)
    {
        Scanner con = new Scanner(System.in);
        n = con.nextInt();
        m = con.nextInt();
        g = new ArrayList[n+1]; // unchecked
        used = new int[n+1];

        for (int i = 0; i <= n; i++)
            g[i] = new ArrayList<>();

        for (int i = 0; i < m; i++)
        {
            int a = con.nextInt();
            int b = con.nextInt();
            g[a].add(b);
            g[b].add(a);
        }

        int v = con.nextInt();
        dfs(v);
        System.out.println();

        con.close();
    }
}
