import java.util.*;

public class assignment {

    // 🔵 LINEAR SEARCH (unsorted)
    public static int linearSearch(int[] arr, int target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Search -> Found at index " + i +
                        ", Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Linear Search -> Not Found, Comparisons: " + comparisons);
        return -1;
    }

    // 🟢 BINARY SEARCH (Insertion Point / lower_bound)
    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        int comparisons = 0;

        while (low < high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        System.out.println("Lower Bound (Insertion Index): " + low +
                ", Comparisons: " + comparisons);
        return low;
    }

    // 🟢 FLOOR (largest ≤ target)
    public static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Floor: " + ans + ", Comparisons: " + comparisons);
        return ans;
    }

    // 🟢 CEILING (smallest ≥ target)
    public static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Ceiling: " + ans + ", Comparisons: " + comparisons);
        return ans;
    }

    // 🚀 MAIN METHOD
    public static void main(String[] args) {

        int[] unsorted = {50, 10, 100, 25};
        int[] sorted = {10, 25, 50, 100};

        int target = 30;

        // 🔵 Linear Search (unsorted)
        linearSearch(unsorted, target);

        System.out.println("\nSorted Risk Bands: " + Arrays.toString(sorted));

        // 🟢 Binary Variants
        lowerBound(sorted, target);
        floor(sorted, target);
        ceiling(sorted, target);
    }
}}