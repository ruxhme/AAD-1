import java.util.*;
public class q1 {
    private static int[] getArrayFromUser(Scanner sc) {
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    private static void checkIfSorted(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        if (arr.length <= 1) { // Use arr.length
            System.out.println("Output: Yes (list is trivially sorted)");
            return;
        }

        boolean isAscending = true;
        boolean isDescending = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isAscending = false;
            }
            if (arr[i] < arr[i + 1]) {
                isDescending = false;
            }
        }

        if (isAscending) {
            System.out.println("Output: Yes ascending");
        } else if (isDescending) {
            System.out.println("Output: Yes descending");
        } else {
            System.out.println("Output: No");
        }
    }
    private static void findPairsWithDiff(Scanner sc) {
        System.out.print("Enter the value: ");
        int value = sc.nextInt();
        System.out.println("Enter the data for list X: ");
        int[] X = getArrayFromUser(sc);
        System.out.println("Enter the data for list Y: ");
        int[] Y = getArrayFromUser(sc);
        System.out.print("Output: ");
        boolean found = false;
        for (int x : X) {
            for (int y : Y) {
                if (Math.abs(x - y) == value) {
                    if (found) {
                        System.out.print(", ");
                    }
                    System.out.print("(" + x + "," + y + ")");
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.print("No pairs found.");
        }
        System.out.println();
    }
    private static void findKthSmallest(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        System.out.print("Enter the value of k (k <= " + arr.length + "): ");
        int k = sc.nextInt();  
        if (k <= 0 || k > arr.length) {
            System.out.println("Invalid k.");
            return;
        }
        Arrays.sort(arr);
        if (k == 1) {
            System.out.println("Output: " + arr[0]);
            return;
        }
        int distinctCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                distinctCount++;
            }
            if (distinctCount == k) {
                System.out.println("Output: " + arr[i]);
                return;
            }
        }
    }
    private static void findPairSumEqualsRest(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            System.out.println("Output: No such pair exists.");
            return;
        }
        int targetSum = totalSum / 2;
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        boolean found = false;

        while (left < right) {
            int currentSum = arr[left] + arr[right];
            
            if (currentSum == targetSum) {
                System.out.println("Output: " + arr[left] + ", " + arr[right]);
                found = true;
                break;
            } else if (currentSum < targetSum) {
                left++; 
            } else {
                right--; 
            }
        }

        if (!found) {
            System.out.println("Output: No such pair exists.");
        }
    }
    private static void NumberOfTriangles(Scanner sc) {
        System.out.println("Enter the edges: ");
        int[] edges = getArrayFromUser(sc);
        if (edges.length < 3) {
            System.out.println("Output: 0 (Need at least 3 edges)");
            return;
        }
        Arrays.sort(edges);
        int count = 0;
        for (int i = edges.length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (edges[left] + edges[right] > edges[i]) {
                    count += (right - left);
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        System.out.println("Output: " + count);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n========== LAB EXPERIMENT 4 ==========");
            System.out.println("1. Check if List is Sorted");
            System.out.println("2. Find Pairs with Absolute Difference");
            System.out.println("3. Find K-th Smallest Element");
            System.out.println("4. Find Pair Sum = Rest of Sum");
            System.out.println("5. Count Triangles from Edges");
            System.out.println("0. Exit");
            System.out.println("=========================================");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt(); // Will crash if you type a letter

            switch (choice) {
                case 1:
                    checkIfSorted(sc);
                    break;
                case 2:
                    findPairsWithDiff(sc);
                    break;
                case 3:
                    findKthSmallest(sc);
                    break;
                case 4:
                    findPairSumEqualsRest(sc);
                    break;
                case 5:
                    NumberOfTriangles(sc);
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    sc.close(); 
                    return;          
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}