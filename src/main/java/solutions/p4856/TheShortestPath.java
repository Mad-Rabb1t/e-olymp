package solutions.p4856;

import java.util.*;

public class TheShortestPath {
    static int[][] g;
    static int[] used;
    static int[] dist;
    static int[] parent;
    static final int INFINITY = 1000000000;

    static void PrintPath(int v) {
        if (v == -1) return;
        PrintPath(parent[v]);
        System.out.print(v + " ");
    }

    static void Relax(int i, int j) {
        if (dist[i] + g[i][j] < dist[j]) {
            dist[j] = dist[i] + g[i][j];
            parent[j] = i;
        }
    }

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        int n = con.nextInt();
        int m = con.nextInt();
        int s = con.nextInt();
        int f = con.nextInt();

        used = new int[n + 1];
        Arrays.fill(used, 0);

        g = new int[n + 1][n + 1];
        for (int[] row : g) Arrays.fill(row, INFINITY);

        for (int i = 1; i <= m; i++) {
            int b = con.nextInt();
            int e = con.nextInt();
            int distance = con.nextInt();
            g[b][e] = g[e][b] = distance;
        }

        dist = new int[n + 1];
        Arrays.fill(dist, INFINITY);
        dist[s] = 0;

        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        for (int i = 1; i < n; i++) {
            int min = INFINITY, v = -1;
            for (int j = 1; j <= n; j++)
                if (used[j] == 0 && dist[j] < min) {
                    min = dist[j];
                    v = j;
                }

            if (v == -1) break;

            for (int j = 1; j <= n; j++)
                if (used[j] == 0 && g[v][j] != INFINITY) Relax(v, j);

            used[v] = 1;
        }

        if (dist[f] == INFINITY)
            System.out.println("-1");
        else {
            System.out.println(dist[f]);
            PrintPath(f);
            System.out.println();
        }
        con.close();
    }
}
