public class sorting {
    public static void main(String[] args) {
        int[] arr = {12, 32, 54, 23, 37};
//        bubbleSort(arr);
//        selectionSort(arr);
          insertionSort(arr);
          print(arr);
    }

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int last = nums.length - i - 1;
            int max = 0;
            for (int j = 1; j <= last; j++) {
                if (nums[max] < nums[j]) {
                    max = j;
                }
            }
            int temp = nums[max];
            nums[max] = nums[last];
            nums[last] = temp;
        }
    }

    private static void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if(nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
                else {
                    break;
                }
            }
        }
    }

    private static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
