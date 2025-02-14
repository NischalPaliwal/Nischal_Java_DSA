import java.util.ArrayList;

public class subSeq {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subSet(arr));
    }

    public static void skip_char_1(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        if (ch == 'a') {
            skip_char_1(p, up.substring(1));
        } else {
            skip_char_1(p + ch, up.substring(1));
        }
    }

    public static String skip_char_2(String up) {
        if (up.isEmpty()) {
            return "";
        }

        char ch = up.charAt(0);

        if (ch == 'a') {
            return skip_char_2(up.substring(1));
        } else {
            return ch + skip_char_2(up.substring(1));
        }
    }

    public static void skipString(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        if (up.startsWith("apple")) {
            skipString(p, up.substring(5));
        } else {
            skipString(p + up.charAt(0), up.substring(1));
        }
    }

    public static void subSeq_1(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subSeq_1(p + ch, up.substring(1));
        subSeq_1(p, up.substring(1));
    }

    public static ArrayList<String> subSeq_2(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        
        ArrayList<String> left = subSeq_2(p + ch, up.substring(1));
        ArrayList<String> right = subSeq_2(p, up.substring(1));

        left.addAll(right);
        return left;
    }

    public static ArrayList<ArrayList<Integer>> subSet(int[] arr) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }
}