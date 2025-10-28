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
        System.out.println("\n--- Problem: Sum of n numbers (Recursive) ---");
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        long sum = recursiveSum(n);
        System.out.println("Result: The sum of the first " + n + " numbers is " + sum);
    }

    private static long recursiveSum(int n) {
        // Base case
        if (n <= 0) {
            return 0;
        }
        // Recursive step
        return n + recursiveSum(n - 1);
    }
    private static void handleFactorial(Scanner sc) {
        System.out.println("\n--- Problem: Factorial of a number (Recursive) ---");
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        long factorial = recursiveFactorial(n);
        System.out.println("Result: The factorial of " + n + " is " + factorial);
    }

    private static long recursiveFactorial(int n) {
        // Base case
        if (n == 0) {
            return 1;
        }
        // Recursive step
        return (long) n * recursiveFactorial(n - 1);
    }
    private static void handleFibonacci(Scanner sc) {
        System.out.println("\n--- Problem: Generating nth Fibonacci number (Recursive) ---");
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        long fib = recursiveFibonacci(n);
        System.out.println("Result: The " + n + "th Fibonacci number is " + fib);
    }

    private static long recursiveFibonacci(int n) {
        // Base case 1
        if (n == 0) {
            return 0;
        }
        // Base case 2
        if (n == 1) {
            return 1;
        }
        // Recursive step
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }
    private static void handleLinearSearch(Scanner sc) {
        System.out.println("\n--- Problem: Linear Search (Recursive) ---");
        int[] arr = getArrayFromUser(sc);
        System.out.print("Enter the target value to search for: ");
        int target = sc.nextInt();
        int index = recursiveLinearSearch(arr, target, 0);

        if (index != -1) {
            System.out.println("Result: Target " + target + " found at index " + index);
        } else {
            System.out.println("Result: Target " + target + " not found in the array.");
        }
    }

    private static int recursiveLinearSearch(int[] arr, int target, int index) {
        // Base case: Not found
        if (index == arr.length) {
            return -1;
        }
        // Base case: Found
        if (arr[index] == target) {
            return index;
        }
        // Recursive step: Check the rest of the array
        return recursiveLinearSearch(arr, target, index + 1);
    }
    private static void handleBinarySearch(Scanner sc) {
        System.out.println("\n--- Problem: Binary Search (Recursive) ---");
        System.out.println("(Note: For Binary Search, elements MUST be entered in sorted order!)");
        int[] arr = getArrayFromUser(sc);
        System.out.print("Enter the target value to search for: ");
        int target = sc.nextInt();
        int index = recursiveBinarySearch(arr, target, 0, arr.length - 1);

        if (index != -1) {
            System.out.println("Result: Target " + target + " found at index " + index);
        } else {
            System.out.println("Result: Target " + target + " not found in the array.");
        }
    }

    private static int recursiveBinarySearch(int[] arr, int target, int low, int high) {
        // Base case: Not found
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        // Base case: Found
        if (arr[mid] == target) {
            return mid;
        }
        // Recursive step: Search left half
        if (target < arr[mid]) {
            return recursiveBinarySearch(arr, target, low, mid - 1);
        }
        // Recursive step: Search right half
        return recursiveBinarySearch(arr, target, mid + 1, high);
    }
    private static void handleDecimalToHex(Scanner sc) {
        System.out.println("\n--- Problem: Decimal to Hexadecimal (Recursive) ---");
        System.out.print("Enter a decimal integer: ");
        int n = sc.nextInt();
        System.out.print("Result: The hexadecimal representation is 0x");
        if (n == 0) {
            System.out.print("0");
        } else {
            decimalToHex(n);
        }
        System.out.println();
    }

    private static void decimalToHex(int n) {
        // Base case
        if (n == 0) {
            return;
        }

        // Recursive step: Call first, so digits print in correct order
        decimalToHex(n / 16);

        int remainder = n % 16;
        char hexDigit;
        if (remainder < 10) {
            hexDigit = (char) ('0' + remainder);
        } else {
            hexDigit = (char) ('A' + remainder - 10);
        }
        System.out.print(hexDigit);
    }
    private static void handleTowerOfHanoi(Scanner sc) {
        System.out.println("\n--- Problem: Tower of Hanoi (Recursive) ---");
        System.out.print("Enter the number of disks: ");
        int n = sc.nextInt();
        System.out.println("Result: The steps to solve are:");
        towerOfHanoi(n, 'A', 'C', 'B'); // A=Source, C=Destination, B=Auxiliary
    }

    private static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        // Base case
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }
        // Recursive step 1: Move n-1 disks from source to auxiliary
        towerOfHanoi(n - 1, fromRod, auxRod, toRod);
        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        // Recursive step 2: Move n-1 disks from auxiliary to destination
        towerOfHanoi(n - 1, auxRod, toRod, fromRod);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- AAD1 (CSE2631) LAB EXPERIMENT-02 MENU ---");
            System.out.println("1. Sum of n numbers (Recursive)"); // [cite: 15]
            System.out.println("2. Factorial of a number (Recursive)"); // [cite: 16]
            System.out.println("3. Generating nth Fibonacci number (Recursive)"); // [cite: 17]
            System.out.println("4. Linear search (Recursive)"); // [cite: 18]
            System.out.println("5. Binary search (Recursive)"); // [cite: 19]
            System.out.println("6. Decimal to Hexadecimal (Recursive)"); // [cite: 20]
            System.out.println("7. Tower of Hanoi (Recursive)"); // [cite: 22]
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleSum(scanner);
                    break;
                case 2:
                    handleFactorial(scanner);
                    break;
                case 3:
                    handleFibonacci(scanner);
                    break;
                case 4:
                    handleLinearSearch(scanner);
                    break;
                case 5:
                    handleBinarySearch(scanner);
                    break;
                case 6:
                    handleDecimalToHex(scanner);
                    break;
                case 7:
                    handleTowerOfHanoi(scanner);
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}