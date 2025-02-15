import java.util.ArrayList;

public class phoneNumber {
    public static void main(String[] args) {
        System.out.println(pad("", "23"));
    }

    public static ArrayList<String> pad(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';

        ArrayList<String> result = new ArrayList<>();

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char)('a' + i);
            result.addAll(pad(p + ch, up.substring(1)));
        }
        return result;
    }
}
