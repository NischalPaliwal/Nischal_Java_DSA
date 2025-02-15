import java.util.ArrayList;

public class diceProblem {
    public static void main(String[] args) {
        dice_1("", 5);
        System.out.println(dice_2("", 5));
    }

    public static void dice_1(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= target; i++) {
            dice_1(p + i, target - i);
        }
    }

    public static ArrayList<String> dice_2(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> result = new ArrayList<>();

        for (int index = 1; index <= target; index++) {
            result.addAll(dice_2(p + index, target - index));
        }

        return result;
    }
}
