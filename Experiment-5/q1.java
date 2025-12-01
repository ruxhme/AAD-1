import java.util.*;

public class q1 {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    private static int[] getArrayInput(Scanner sc) {
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    private static void maxHeapifyDown(int[] arr, int n, int i) {
        int largest = i;     // Initialize largest as root
        int left = 2 * i + 1;  // left child
        int right = 2 * i + 2; // right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);
            // Recursively heapify the affected sub-tree
            maxHeapifyDown(arr, n, largest);
        }
    }

    /**
     * @brief Converts an array into a max-heap.
     */
    private static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        // Start from the last non-leaf node and heapify down
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapifyDown(arr, n, i);
        }
    }
    
    private static void siftUp(int[] arr, int i) {
        // While node is not root and parent is smaller than node
        while (i > 0 && arr[(i - 1) / 2] < arr[i]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2; // Move up to the parent's index
        }
    }
    private static boolean isMinHeap(int[] arr) {
        int n = arr.length;
        // Check all non-leaf nodes
        for (int i = 0; i <= (n / 2) - 1; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // Check if parent is greater than left child
            if (left < n && arr[i] > arr[left]) {
                return false;
            }
            // Check if parent is greater than right child
            if (right < n && arr[i] > arr[right]) {
                return false;
            }
        }
        return true;
    }
    private static void updateKey(int[] arr, int i, int newKey) {
        if (newKey == arr[i]) {
            System.out.println("New key is the same as the old key. No change.");
            return;
        }

        int oldKey = arr[i];
        arr[i] = newKey;

        if (newKey > oldKey) {
            // New key is larger, so it needs to sift UP
            System.out.println("New key is larger. Sifting up...");
            siftUp(arr, i);
        } else {
            // New key is smaller, so it needs to sift DOWN
            System.out.println("New key is smaller. Sifting down...");
            maxHeapifyDown(arr, arr.length, i);
        }
    }
    private static int findKthLargest(int[] arr, int k) {
        int n = arr.length;
        if (k < 1 || k > n) {
            System.out.println("Invalid k value.");
            return -1; // Error code
        }

        // Create a copy of the array to avoid modifying the original
        int[] heap = arr.clone();

        // 1. CREATE-HEAP
        buildMaxHeap(heap);

        int result = 0;
        int heapSize = n;

        // 2. Simulate k "Delete-Element" (Extract-Max) operations
        for (int i = 0; i < k; i++) {
            result = heap[0]; // The max element
            swap(heap, 0, heapSize - 1);
            heapSize--;
            maxHeapifyDown(heap, heapSize, 0);
        }
        return result;
    }
    private static void heapSort(int[] arr) {
        int n = arr.length;

        // 1. Build a max-heap (CREATE-HEAP)
        buildMaxHeap(arr);

        // 2. One by one, extract elements (Delete-Element)
        for (int i = n - 1; i > 0; i--) {
            // Move current root (max element) to the end
            swap(arr, 0, i);
            // Call maxHeapifyDown on the reduced heap (size 'i')
            maxHeapifyDown(arr, i, 0);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- HEAP DATA STRUCTURE (EXPERIMENT-5) ---");
            System.out.println("1. Check if list is a MIN-Priority Queue");
            System.out.println("2. Increase or Decrease key in a Priority Queue");
            System.out.println("3. Find Kth largest element");
            System.out.println("4. Sort array using HEAP-SORT");
            System.out.println("5. Exit");
            System.out.println("----------------------------------------");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            int[] arr; // Use simple array

            switch (choice) {
                case 1:
                    // Task 1: Check for MIN-Heap
                    System.out.println("\n[Task 1: Check for MIN-Heap]");
                    arr = getArrayInput(sc);
                    // Input: 1,3,2,7,4,6,5,8 -> YES
                    // Input: 1,3,4,7,2,5,6,8 -> NO
                    if (isMinHeap(arr)) {
                        System.out.println("Output: YES");
                    } else {
                        System.out.println("Output: NO");
                    }
                    break;

                case 2:
                    // Task 2: Increase or Decrease Key in MAX-Heap
                    System.out.println("\n[Task 2: Update Key in Priority Queue]");
                    System.out.println("Enter the Priority Queue (e.g., 8 5 7 4 1 6 3 2):");
                    arr = getArrayInput(sc);
                    // We assume it's a Max-Heap based on the heap-sort/k-largest tasks
                    System.out.print("Enter index of element to update (0-based): ");
                    int index = sc.nextInt();
                    System.out.print("Enter the new key value: ");
                    int newKey = sc.nextInt();

                    if (index >= arr.length || index < 0) {
                        System.out.println("Error: Invalid index.");
                    } else {
                        updateKey(arr, index, newKey);
                        System.out.print("Updated Priority Queue: ");
                        printArray(arr);
                    }
                    break;

                case 3:
                    // Task 3: Find Kth Largest Element
                    System.out.println("\n[Task 3: Find Kth Largest Element]");
                    arr = getArrayInput(sc);
                    System.out.print("Enter the value of k: ");
                    int k = sc.nextInt();

                    int result = findKthLargest(arr, k);
                    if (result != -1) {
                        System.out.println("The " + k + "th largest element is: " + result);
                    }
                    break;

                case 4:
                    // Task 4: Heap Sort
                    System.out.println("\n[Task 4: Heap Sort (Ascending Order)]");
                    arr = getArrayInput(sc);
                    System.out.print("Original array: ");
                    printArray(arr);
                    heapSort(arr); // Sorts the array in-place
                    System.out.print("Sorted array: ");
                    printArray(arr);
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}