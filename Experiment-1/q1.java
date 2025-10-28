import java.util.*;
public class q1 {
    private static int[] getArrayFromUser(Scanner sc) {
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    private static void handleSum(Scanner sc) {
        System.out.println("\n--- Problem: Sum of n numbers ---");
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        long sum = calculateSum(n);
        System.out.println("Result: The sum of the first " + n + " numbers is " + sum);
    }

    /** Iterative code for Sum of n numbers */
    private static long calculateSum(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    private static void handleFactorial(Scanner sc) {
        System.out.println("\n--- Problem: Factorial of a number ---");
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        long factorial = calculateFactorial(n);
        System.out.println("Result: The factorial of " + n + " is " + factorial);
    }

    /** Iterative code for Factorial of a number */
    private static long calculateFactorial(int n) {
        if (n < 0) return -1; // Factorial not defined for negative numbers
        if (n == 0) return 1;

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    private static void handleFibonacci(Scanner sc) {
        System.out.println("\n--- Problem: Generating nth Fibonacci number ---");
        System.out.print("Enter the value of n (for the nth Fibonacci number): ");
        int n = sc.nextInt();
        long fib = calculateFibonacci(n);
        System.out.println("Result: The " + n + "th Fibonacci number is " + fib);
    }

    /** Iterative code for nth Fibonacci number */
    private static long calculateFibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        long a = 0;
        long b = 1;

        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    private static void handleLinearSearch(Scanner sc) {
        System.out.println("\n--- Problem: Linear Search ---");
        int[] arr = getArrayFromUser(sc); 
        System.out.print("Enter the target value to search for: ");
        int target = sc.nextInt();
        int index = linearSearch(arr, target);
        
        if (index != -1) {
            System.out.println("Result: Target " + target + " found at index " + index);
        } else {
            System.out.println("Result: Target " + target + " not found in the array.");
        }
    }

    /** Iterative code for Linear Search */
    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found it
            }
        }
        return -1; // Not found
    }
    private static void handleBinarySearch(Scanner sc) {
        System.out.println("\n--- Problem: Binary Search ---");
        int[] arr = getArrayFromUser(sc); 
        System.out.print("Enter the target value to search for: ");
        int target = sc.nextInt();
        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println("Result: Target " + target + " found at index " + index);
        } else {
            System.out.println("Result: Target " + target + " not found in the array.");
        }
    }

    /** Iterative code for Binary Search */
    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids overflow

            if (arr[mid] == target) {
                return mid; // Found it
            } else if (arr[mid] < target) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return -1; // Not found
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- AAD1 (CSE2631) LAB EXPERIMENT-01 MENU ---");
            System.out.println("1. Sum of n numbers"); 
            System.out.println("2. Factorial of a number");
            System.out.println("3. Generating nth Fibonacci number");  
            System.out.println("4. Linear search"); 
            System.out.println("5. Binary search"); 
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    handleSum(sc);
                    break;
                case 2:
                    handleFactorial(sc);
                    break;
                case 3:
                    handleFibonacci(sc);
                    break;
                case 4:
                    handleLinearSearch(sc);
                    break;
                case 5:
                    handleBinarySearch(sc);
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        sc.close();
    }
}