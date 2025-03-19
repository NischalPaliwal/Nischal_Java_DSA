package graphs;
import java.util.*;

public class dfs {
    public static void main(String[] args) {
        
    }

    public void dfs_code(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfs) {
        visited[node] = true;
        dfs.add(node);

        for (Integer neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs_code(neighbor, adj, visited, dfs);
            }
        }
        return;
    }
}
