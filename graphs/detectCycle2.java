package graphs;

import java.util.ArrayList;

public class detectCycle2 {
    public static void main(String[] args) {
        
    }

    private boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                if (dfs(neighbor, node, vis, adj)) {
                    return true;
                }
            }
            else if (neighbor != parent) {
                return true;
            } 
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < vis.length; i++) vis[i] = false;
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, vis, adj)) return true;
            }
        }
        return false;
    }
}
