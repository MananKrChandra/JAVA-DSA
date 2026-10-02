package Graph;
import java.util.LinkedList;
import java.util.Queue;
public class NumberofProvinces {
    public int findCircleNum(int[][] mat) {
        int count = 0;
        boolean[] visited = new boolean[mat.length];
        for (int i = 0; i < mat.length; i++) {
            if (!visited[i]) {
                bfs(i, visited, mat);
                count++;
            }
        }
        return count;
    }
    private void bfs(int i, boolean[] visited, int[][] mat) {
        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;
        q.add(i);
        while (!q.isEmpty()) {
            int front = q.remove();
            for (int j = 0; j < mat.length; j++) {
                if (mat[front][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    q.add(j);
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] mat = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        NumberofProvinces obj = new NumberofProvinces();

        int result = obj.findCircleNum(mat);

        System.out.println("Number of Provinces: " + result);
    }
}
