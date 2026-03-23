import java.util.Arrays;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    public Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + ":" + riskScore + " (Bal:" + accountBalance + ")";
    }
}

public class assignment {

    // 🔵 Bubble Sort (Ascending by riskScore)
    public static void bubbleSortAsc(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        System.out.println("\nBubble Sort Steps:");

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {

                    // swap
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;

                    // visualize swap
                    System.out.println("Swap: " + arr[j] + " <-> " + arr[j + 1]);
                }
            }

            if (!swapped) break; // early termination
        }

        System.out.println("Total swaps: " + swaps);
    }

    // 🟢 Insertion Sort (DESC by riskScore, then accountBalance)
    public static void insertionSortDesc(Client[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && compare(arr[j], key) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Comparator for DESC sorting
    private static int compare(Client c1, Client c2) {
        if (c1.riskScore != c2.riskScore) {
            return Integer.compare(c1.riskScore, c2.riskScore); // ASC logic
        }
        return Double.compare(c1.accountBalance, c2.accountBalance);
    }

    // 🔴 Get Top 10 highest risk clients
    public static void printTopRisks(Client[] arr, int topK) {
        System.out.println("\nTop " + topK + " Highest Risk Clients:");

        for (int i = 0; i < Math.min(topK, arr.length); i++) {
            System.out.println((i + 1) + ". " + arr[i]);
        }
    }

    // 🚀 Main Method
    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 10000),
                new Client("clientB", 50, 7000)
        };

        // 🔵 Bubble Sort (Ascending)
        bubbleSortAsc(clients);
        System.out.println("\nAfter Bubble Sort (ASC):");
        System.out.println(Arrays.toString(clients));

        // 🟢 Insertion Sort (Descending)
        insertionSortDesc(clients);
        System.out.println("\nAfter Insertion Sort (DESC):");
        System.out.println(Arrays.toString(clients));

        // 🔴 Top Risk Clients
        printTopRisks(clients, 10);
    }
}

