public class recursion {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(isSorted(nums, 0));
        System.out.println(find(nums, 0, 4));
        System.out.println(findFromStart(nums, 0, 4));
        System.out.println(findFromLast(nums, nums.length - 1, 4));
    }

    // check if the array is sorted or not ->
    static boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        return arr[index] < arr[index + 1] && isSorted(arr, index + 1);
    }

    // Linear search with recursion ->
    static boolean find(int[] arr, int index, int target) {
        if (index == arr.length) {
            return false;
        }
        return arr[index] == target || find(arr, index + 1, target);
    }

    static int findFromStart(int[] arr, int index, int target) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return findFromStart(arr, index + 1, target);
    }

    static int findFromLast(int[] arr, int index, int target) {
        if (index == -1) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return findFromLast(arr, index - 1, target);
    }
}