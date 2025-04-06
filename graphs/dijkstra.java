package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {
    int weight;
    int node;

    Pair(int weight, int node) {
        this.weight = weight;
        this.node = node;
    }
}

public class dijkstra {
    public static void main(String[] args) {
        
    }

    private static int[] dijkstraAlgo(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        int[] dist = new int[V];
        for (int i = 0; i < dist.length; i++) dist[i] = Integer.MAX_VALUE;
        dist[S] = 0;
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            int w = pq.peek().weight;
            int node = pq.peek().node;
            pq.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (w + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = w + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }
}
