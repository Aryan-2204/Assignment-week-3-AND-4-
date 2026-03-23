import java.util.ArrayList;

class Transaction {
    String id;
    double fee;
    String timestamp; // HH:mm format

    public Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return id + ":" + fee + "@" + timestamp;
    }
}

public class assignment {

    // 🔵 Bubble Sort (by fee only)
    public static void bubbleSortByFee(ArrayList<Transaction> list) {
        int n = list.size();
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                    swaps++;
                }
            }

            if (!swapped) {
                System.out.println("Early termination at pass " + (i + 1));
                break;
            }
        }

        System.out.println("Bubble Sort swaps: " + swaps);
    }

    // 🟢 Insertion Sort (by fee + timestamp)
    public static void insertionSortByFeeAndTime(ArrayList<Transaction> list) {
        int n = list.size();

        for (int i = 1; i < n; i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 && compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);
        }
    }

    // Comparator (fee first, then timestamp)
    private static int compare(Transaction t1, Transaction t2) {
        if (t1.fee != t2.fee) {
            return Double.compare(t1.fee, t2.fee);
        }
        return t1.timestamp.compareTo(t2.timestamp);
    }

    // 🔴 Outlier Detection (>50)
    public static void detectOutliers(ArrayList<Transaction> list) {
        System.out.println("\nHigh-fee outliers (>50):");
        boolean found = false;

        for (Transaction t : list) {
            if (t.fee > 50) {
                System.out.println(t);
                found = true;
            }
        }

        if (!found) {
            System.out.println("None");
        }
    }

    // 🚀 Process based on batch size
    public static void processTransactions(ArrayList<Transaction> list) {
        int size = list.size();

        if (size <= 100) {
            System.out.println("\nUsing Bubble Sort (by fee)...");
            bubbleSortByFee(list);
        } else if (size <= 1000) {
            System.out.println("\nUsing Insertion Sort (fee + timestamp)...");
            insertionSortByFeeAndTime(list);
        } else {
            System.out.println("\nLarge dataset - advanced sort recommended");
        }

        System.out.println("\nSorted Transactions:");
        for (Transaction t : list) {
            System.out.println(t);
        }

        detectOutliers(list);
    }

    // 🧪 Main Method
    public static void main(String[] args) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        // Sample Input
        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        processTransactions(transactions);
    }
}

