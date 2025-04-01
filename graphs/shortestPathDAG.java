package graphs;

import java.util.ArrayList;
import java.util.Stack;

class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class shortestPathDAG {
    public static void main(String[] args) {
        
    }

    public static int[] shortestPathInDAG(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, st);
            }
        }
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        while(!st.isEmpty()) {
            int node = st.pop();
            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair neighbor : adj.get(node)) {
                    int v = neighbor.first;
                    int wt = neighbor.second;

                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
    }

    private static void dfs(int node, ArrayList<ArrayList<Pair>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        for (Pair neighbor : adj.get(node)) {
            int v = neighbor.first;
            if (!vis[v]) {
                dfs(v, adj, vis, st);
            }
        }
        st.add(node);
    }
}