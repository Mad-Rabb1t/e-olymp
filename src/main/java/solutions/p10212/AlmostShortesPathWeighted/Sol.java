package solutions.p10212.AlmostShortesPathWeighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sol {
    static final int INF = 1000000000;
    static ArrayList<Set<Integer>> leave;
    static int[][] g;
    static int[][] gR;
    static int[] u;
    static int[] d;
    static int[] uR;
    static int[] dR;

    static void rel(int i, int j) {
        if (d[i] + g[i][j] < d[j]) {
            d[j] = d[i] + g[i][j];
        }
    }

    static void relR(int i, int j) {
        if (dR[i] + gR[i][j] < dR[j]) {
            dR[j] = dR[i] + gR[i][j];
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                if (n == 0 && m == 0) break;
                int s = sc.nextInt();
                int k = sc.nextInt();
                leave = new ArrayList<>();

                u = new int[n];
                uR = new int[n];
                Arrays.fill(u, 0);
                Arrays.fill(uR, 0);

                g = new int[n][n];
                gR = new int[n][n];

                for (int[] row : g) Arrays.fill(row, INF);
                for (int[] rowR : gR) Arrays.fill(rowR, INF);

                Sol.d = new int[n];
                dR = new int[n];
                Arrays.fill(Sol.d, INF);
                Arrays.fill(dR, INF);
                Sol.d[s] = 0;
                dR[k] = 0;

                for (int i = 0; i < m; i++) {
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    int p = sc.nextInt();
                    g[u][v] = p;
                    gR[v][u] = p;
                }

                for (int i = 0; i < n; i++) {
                    int min = INF, v = -1;
                    for (int j = 0; j < n; j++)
                        if (u[j] == 0 && Sol.d[j] < min) {
                            min = Sol.d[j];
                            v = j;
                        }

                    if (v == -1) break;

                    for (int j = 0; j < n; j++)
                        if (u[j] == 0 && g[v][j] != INF) rel(v, j);

                    u[v] = 1;
                }

                for (int i = n - 1; i >= 0; i--) {
                    int min = INF, v = -1;
                    for (int j = n - 1; j >= 0; j--)
                        if (uR[j] == 0 && dR[j] < min) {
                            min = dR[j];
                            v = j;
                        }

                    if (v == -1) break;

                    for (int j = n - 1; j >= 0; j--)
                        if (uR[j] == 0 && gR[v][j] != INF) relR(v, j);

                    uR[v] = 1;
                }


                for (int i = 0; i < n; i++) {
                    leave.add(new HashSet<>());
                    for (int j = 0; j < n; j++) {
                        if (Sol.d[i] + dR[j] + g[i][j] == Sol.d[k]) {
                            g[i][j] = INF;
                        }
                    }
                }

                u = new int[n];
                Sol.d = new int[n];
                Arrays.fill(Sol.d, INF);
                Sol.d[s] = 0;

                for (int i = 0; i <= n - 1; i++) {
                    int min = INF, v = -1;
                    for (int j = 0; j <= n - 1; j++) {
                        if (u[j] == 0 && Sol.d[j] < min) {
                            min = Sol.d[j];
                            v = j;
                        }
                    }

                    if (v == -1) break;

                    for (int j = 0; j <= n - 1; j++) {
                        if (u[j] == 0 && g[v][j] != INF) rel(v, j);
                    }

                    u[v] = 1;
                }
                if (Sol.d[k] == INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(Sol.d[k]);
                }
            }
        }
    }
}

