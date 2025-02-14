public class skipChar {
    public static void main(String[] args) {

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

    public static String skip_char_2(String p, String up) {
        if (up.isEmpty()) {
            return "";
        }

        char ch = up.charAt(0);

        if (ch == 'a') {
            return skip_char_2(p, up.substring(1));
        } else {
            return skip_char_2(p + ch, up.substring(1));
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

    
}