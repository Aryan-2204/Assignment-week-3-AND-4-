import java.util.*;

public class assignment {

    // 🔵 LINEAR SEARCH (First Occurrence)
    public static int linearFirst(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First -> Index: " + i + ", Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Linear First -> Not Found, Comparisons: " + comparisons);
        return -1;
    }

    // 🔵 LINEAR SEARCH (Last Occurrence)
    public static int linearLast(String[] arr, String target) {
        int comparisons = 0;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                index = i;
            }
        }

        System.out.println("Linear Last -> Index: " + index + ", Comparisons: " + comparisons);
        return index;
    }

    // 🟢 BINARY SEARCH (Find any occurrence)
    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                System.out.println("Binary Search -> Index: " + mid + ", Comparisons: " + comparisons);
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary Search -> Not Found, Comparisons: " + comparisons);
        return -1;
    }

    // 🟢 COUNT OCCURRENCES USING BINARY SEARCH
    public static int countOccurrences(String[] arr, String target) {
        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);

        if (first == -1) return 0;

        return last - first + 1;
    }

    private static int firstOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                high = mid - 1; // go left
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private static int lastOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                low = mid + 1; // go right
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // 🚀 MAIN METHOD
    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        // 🔵 Linear Search
        linearFirst(logs, "accB");
        linearLast(logs, "accB");

        // 🟢 Sort before Binary Search
        Arrays.sort(logs);
        System.out.println("\nSorted Logs: " + Arrays.toString(logs));

        // 🟢 Binary Search
        binarySearch(logs, "accB");

        // 🟢 Count duplicates
        int count = countOccurrences(logs, "accB");
        System.out.println("Total occurrences of accB: " + count);
    }
}