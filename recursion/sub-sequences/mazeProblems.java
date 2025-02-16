import java.util.ArrayList;

public class mazeProblems {
    public static void main(String[] args) {
        // System.out.println(count(4, 4));
        System.out.println(path("", 3, 3));
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

    
}
