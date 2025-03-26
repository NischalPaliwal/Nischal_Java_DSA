package graphs;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class bipartite_bfs {
    public static void main(String[] args) {
        
    }

    private boolean check(int start, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        for (int i = 0; i < V; i++) color[i] = -1;

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (check(i, adj, color) == false) {
                    return false;
                }
            }
        }
        return true;
    }
}
