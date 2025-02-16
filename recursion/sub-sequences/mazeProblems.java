import java.util.ArrayList;
import java.util.Arrays;

public class mazeProblems {
    public static void main(String[] args) {
        // System.out.println(count(4, 4));
        // System.out.println(path("", 3, 3));
        boolean[][] bool = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };
        System.out.println(path_with_obs("", bool, 0, 0));
    }

    public static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }

        int left = count(r - 1, c);
        int right = count(r, c - 1);

        return left + right;
    }

    public static ArrayList<String> path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> res = new ArrayList<>();

        if (r > 1) {
            res.addAll(path(p + 'D', r - 1, c));
        }

        if (c > 1) {
            res.addAll(path(p + 'R', r, c - 1));
        }

        if (r > 1 && c > 1) {
            res.addAll(path(p + "Dg", r - 1, c - 1));
        }

        return res;
    }

    public static ArrayList<String> path_with_obs(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        if (!maze[r][c]) {
            return new ArrayList<>();
        }

        maze[r][c] = false;

        ArrayList<String> result = new ArrayList<>();

        if (r < maze.length - 1) {
            result.addAll(path_with_obs(p + 'D', maze, r + 1, c));
        }

        if (c < maze[0].length - 1) {
            result.addAll(path_with_obs(p + 'R', maze, r, c + 1));
        }

        if (r > 0) {
            result.addAll(path_with_obs(p + 'U', maze, r - 1, c));
        }

        if (c > 0) {
            result.addAll(path_with_obs(p + 'L', maze, r, c - 1));
        }

        maze[r][c] = true;
        return result;
    }

    public static void path_with_steps(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;

        if (r < maze.length - 1) {
            path_with_steps(p + 'D', maze, r + 1, c, path, step + 1);
        }

        if (c < maze[0].length) {
            path_with_steps(p + 'R', maze, r, c + 1, path, step + 1);
        }

        if (r > 0) {
            path_with_steps(p + 'U', maze, r - 1, c, path, step + 1);
        }

        if (c > 0) {
            path_with_steps(p + 'L', maze, r, c - 1, path, step + 1);
        }

        maze[r][c] = true;
        path[r][c] = 0;
    }
}