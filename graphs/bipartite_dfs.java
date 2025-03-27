import java.util.ArrayList;

public class bipartite_dfs {
    public static void main(String[] args) {
        
    }

    private boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {
        color[node] = col;
        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == -1) {
                if (dfs(neighbor, 1 - col, color, adj) == false) {
                    return false;
                }
            } else if (color[neighbor] == col) {
                return false;
            }
        }

        return true;
    }
}
