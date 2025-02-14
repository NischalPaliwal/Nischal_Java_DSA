import java.util.ArrayList;

public class permutation {
    public static void main(String[] args) {
        String p = "";
        String up = "abcd";
        permutation_1(p, up);
        System.out.println(permutation_2(p, up));
    }

    public static void permutation_1(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutation_1(f + ch + s, up.substring(1));
        }
    }

    public static ArrayList<String> permutation_2(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list; 
        }

        char ch = up.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutation_2(f + ch + s, up.substring(1)));
        }

        return ans;
    }
}
