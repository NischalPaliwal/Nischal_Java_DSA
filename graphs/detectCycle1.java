package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int node;
    int pnode;

    Pair(int node, int pnode) {
        this.node = node;
        this.node = node;
    }
}

public class detectCycle1 {
    public static void main(String[] args) {
        
    }

    public static boolean checkForCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        while (!q.isEmpty()) {
            int node = q.peek().node;
            int parent = q.peek().pnode;
            q.remove();

            for (int neighbor : adj.get(node)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(new Pair(neighbor, node));
                } else if (parent != neighbor) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < vis.length; i++) vis[i] = false;
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == false) {
                if (checkForCycle(i, adj, vis)) return true;
            }
        }
        return false;
    }
}
