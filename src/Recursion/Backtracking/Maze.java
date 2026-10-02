package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {
     static int count(int r,int c){
         if(r==1||c==1) return 1;
         int left=count(r-1,c);
         int right=count(r,c-1);
         return left+right;
     }
    static int countdia(int r,int c){
        if(r==1||c==1) return 1;
        int left=countdia(r-1,c);
        int right=countdia(r,c-1);
        int dia=countdia(r-1,c-1);
        return left+right+dia;
    }
    static List<String> paths(String p, int r, int c) {
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> ans = new ArrayList<>();

        if (r > 1) {
            ans.addAll(paths(p + "D", r - 1, c));
        }

        if (c > 1) {
            ans.addAll(paths(p + "R", r, c - 1));
        }

        return ans;
    }
    static List<String> pathsdiagonal(String p, int r, int c) {
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();
        if (r > 1) {
            ans.addAll(pathsdiagonal(p + "-D-", r - 1, c));
        }
        if (c > 1) {
            ans.addAll(pathsdiagonal(p + "-R-", r, c - 1));
        }
        if (r > 1 && c > 1) {
            ans.addAll(pathsdiagonal(p + "-DIAGONAL-", r - 1, c-1));
        }
        return ans;
    }
    static List<String> pathsDiagonal(String p, boolean[][] maze, int r, int c) {
        // Obstacle
        if (!maze[r][c]) {
            return new ArrayList<>();
        }
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();
        if (r < maze.length - 1) {
            ans.addAll(pathsDiagonal(p + "D ", maze, r + 1, c));
        }
        if (c < maze[0].length - 1) {
            ans.addAll(pathsDiagonal(p + "R ", maze, r, c + 1));
        }
        if (r < maze.length - 1 && c < maze[0].length - 1) {
            ans.addAll(pathsDiagonal(p + "Diag ", maze, r + 1, c + 1));
        }
        return ans;
    }
    static List<String> pathsall(String p, boolean[][] maze, int r, int c) {
        if (!maze[r][c]) {
            return new ArrayList<>();
        }
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();
        maze[r][c]= false;
        if (r < maze.length - 1) {
            ans.addAll(pathsall(p + "D", maze,r + 1, c));
        }

        if (c < maze[0].length - 1) {
            ans.addAll(pathsall(p + "R", maze,r, c + 1));
        }
        if (r>0){
            ans.addAll(pathsall(p + "U", maze,r-1, c));
        }
        if (c>0){
            ans.addAll(pathsall(p + "L", maze,r, c-1));
        }
        maze[r][c]= true;
        return ans;
    }
    static List<String> ppathsall(String p, boolean[][] maze, int[][] path, int r, int c, int step) {

        // Obstacle or already visited
        if (!maze[r][c]) {
            return new ArrayList<>();
        }

        // Destination reached
        if (r == maze.length - 1 && c == maze[0].length - 1) {

            path[r][c] = step;

            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();

            List<String> list = new ArrayList<>();
            list.add(p);

            path[r][c] = 0;   // Backtrack destination
            return list;
        }

        List<String> ans = new ArrayList<>();

        // Mark current cell as visited
        maze[r][c] = false;
        path[r][c] = step;

        // Down
        if (r < maze.length - 1) {
            ans.addAll(ppathsall(p + "D", maze, path, r + 1, c, step + 1));
        }

        // Right
        if (c < maze[0].length - 1) {
            ans.addAll(ppathsall(p + "R", maze, path, r, c + 1, step + 1));
        }

        // Up
        if (r > 0) {
            ans.addAll(ppathsall(p + "U", maze, path, r - 1, c, step + 1));
        }

        // Left
        if (c > 0) {
            ans.addAll(ppathsall(p + "L", maze, path, r, c - 1, step + 1));
        }

        // Backtracking
        maze[r][c] = true;
        path[r][c] = 0;

        return ans;
    }

    public static void main(String[] args) {

        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        int[][] path = new int[maze.length][maze[0].length];

        List<String> paths = ppathsall("", maze, path, 0, 0, 1);

        System.out.println("All Paths:");
        System.out.println(paths);
    }
}

