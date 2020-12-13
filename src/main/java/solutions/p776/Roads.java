package solutions.p776;

import java.util.*;

public class Roads {
    static ArrayList<Integer>[] g;
    static boolean[] used;
    static int n, m;

    static void dfs(int v) {
        used[v] = true;
        for (int i = 0; i < g[v].size(); i++) {
            int to = g[v].get(i);
            if (!used[to]) dfs(to);
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        n = con.nextInt();
        m = con.nextInt();

        used = new boolean[n + 1];
        g = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            g[i] = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            int a = con.nextInt();
            int b = con.nextInt();
            g[a].add(b);
            g[b].add(a);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++)
            if (!used[i]) {
                dfs(i);
                cnt++;
            }

        System.out.println(cnt - 1);
        con.close();
    }
}
