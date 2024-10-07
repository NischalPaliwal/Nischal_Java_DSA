import java.util.ArrayList;

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

    // linear search with recursion ->
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

    static ArrayList<Integer> find2(int[] arr, int index, int target, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return find2(arr, index + 1, target, list);
    }

    // binary search in a rotated array ->
    static int searchInRotated(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        
        int middle = start + (end - start) / 2;

        if (arr[middle] == target) {
            return middle;
        }

        if (arr[start] <= arr[middle]) {
            if (target >= arr[start] && target <= arr[middle]) {
                return searchInRotated(arr, target, start, middle - 1);
            }
            else {
                return searchInRotated(arr, target, middle + 1, end);
            }
         }

         if (target >= arr[middle] && target <= arr[end]) {
            return searchInRotated(arr, target, middle + 1, end);
         }

         return searchInRotated(arr, target, start, middle - 1);
    }
}