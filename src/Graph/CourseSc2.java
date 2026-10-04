package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSc2 {
    public int[] findOrder(int n, int[][] req) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int i = 0; i < req.length; i++) {
            indegree[req[i][0]]++;
            adj.get(req[i][1]).add(req[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.remove();
            list.add(u);
            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        if (list.size() == n)
            return ans;
        else
            return new int[0];
    }
}