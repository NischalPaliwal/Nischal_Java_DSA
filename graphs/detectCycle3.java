package graphs;

import java.util.ArrayList;

public class detectCycle3 {
    public static void main(String[] args) {
        
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                if (dfs(neighbor, adj, vis, pathVis) == true) {
                    return true;
                }
            }
            else if (pathVis[neighbor]) return true;
        }

        pathVis[node] = false;
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, pathVis) == true) return true;
            }
        }

        return false;
    }
}