package Recursion;

public class RotatedBS {

    static int RBS(int[] arr, int low, int high, int target) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) return mid;

        // Left half is sorted
        if (arr[low] <= arr[mid]) {

            if (target >= arr[low] && target < arr[mid]) {
                return RBS(arr, low, mid - 1, target);
            }

            return RBS(arr, mid + 1, high, target);
        }

        // Right half is sorted
        if (target > arr[mid] && target <= arr[high]) {
            return RBS(arr, mid + 1, high, target);
        }

        return RBS(arr, low, mid - 1, target);
    }

    public static void main(String[] args) {
        System.out.println(RBS(new int[]{4, 5, 1, 2, 3}, 0, 4, 5));
    }
}