package Graph;

import java.util.*;

public class Pathmaxprob {
    class Pair implements Comparable<Pair> {
        int node;
        double prob;
        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
        public int compareTo(Pair other) {
            return Double.compare(this.prob, other.prob);
        }
    }
    public double maxProbability(int n, int[][] edges, double[] Prob, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new Pair(v, Prob[i]));
            adj.get(v).add(new Pair(u, Prob[i]));
        }
        double[] ans = new double[n];
        ans[start] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Pair(start, 1));
        while (!pq.isEmpty()) {
            Pair top = pq.remove();
            if (top.prob < ans[top.node])
                continue;
            for (Pair p : adj.get(top.node)) {
                double calc = top.prob * p.prob;
                if (calc > ans[p.node]) {
                    ans[p.node] = calc;
                    pq.add(new Pair(p.node, calc));
                }
            }
        }
        return ans[end];
    }
}