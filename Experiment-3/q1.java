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
        // System.out.println("Using array: " + Arrays.toString(arr));
        return arr;
    }
    private static void handleSelectionSort(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        selectionSort(arr);
        System.out.println("Sorted Array: ");
        for(int num: arr){
            System.out.print(num+" ");
        }
    }
    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    private static void handleArrayReduction(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        arrayReduction(arr);
    }

    /** Re-implemented without ArrayList. Modifies the array in-place. */
    private static void arrayReduction(int[] arr) {
        int n = arr.length;
        int currentPositiveCount = 0;
        for (int x : arr) {
            if (x > 0) currentPositiveCount++;
        }

        while (currentPositiveCount > 0) {
            int minPositive = Integer.MAX_VALUE;
            // Find the smallest positive element
            for (int x : arr) {
                if (x > 0 && x < minPositive) {
                    minPositive = x;
                }
            }

            // If no positive elements were found, break
            if (minPositive == Integer.MAX_VALUE) {
                break;
            }

            int newPositiveCount = 0;
            // Subtract and count new positive elements
            for (int i = 0; i < n; i++) {
                if (arr[i] > 0) {
                    arr[i] = arr[i] - minPositive;
                    if (arr[i] > 0) {
                        newPositiveCount++;
                    }
                }
            }

            System.out.println("Elements left: " + newPositiveCount);
            currentPositiveCount = newPositiveCount; // Update count for next loop
        }
    }
    private static void handleMergeSorted(Scanner sc) {
        System.out.println("Enter first sorted array:");
        int[] arr1 = getArrayFromUser(sc);
        System.out.println("Enter second sorted array:");
        int[] arr2 = getArrayFromUser(sc);

        int[] merged = mergeSortedArrays(arr1, arr2);
        System.out.println("Merged Sorted Array: ");
        for (int num : merged) {
            System.out.print(num + " ");
        }
    }

    private static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        while (i < n1) result[k++] = arr1[i++];
        while (j < n2) result[k++] = arr2[j++];
        
        return result;
    }
    private static void handleCheckReverse(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        boolean canBeSorted = checkReverse(arr);
        System.out.println("Result: Can array be sorted by reversing one subarray? " + canBeSorted);
    }

    private static boolean checkReverse(int[] arr) {
        int n = arr.length;
        int[] sortedArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArr);

        int start = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] != sortedArr[i]) {
                start = i;
                break;
            }
        }
        if (start == -1) return true;

        int end = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != sortedArr[i]) {
                end = i;
                break;
            }
        }

        for (int i = start, j = end; i <= end; i++, j--) {
            if (arr[i] != sortedArr[j]) {
                return false;
            }
        }
        return true;
    }
    private static void handleFindFirstRepeated(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        int repeated = findFirstRepeated(arr);
        if (repeated != -1) {
            System.out.println("Result: First repeated element is: " + repeated);
        } else {
            System.out.println("Result: No repeated elements found.");
        }
    }

    private static int findFirstRepeated(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }
    private static void handlePrintDuplicates(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        printDuplicates(arr);
    }

    /** Re-implemented without ArrayList. Prints directly to console. */
    private static void printDuplicates(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Result: No duplicate elements found.");
            return;
        }

        Arrays.sort(arr);
        
        boolean hasAnyDuplicate = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                hasAnyDuplicate = true;
                break;
            }
        }

        if (!hasAnyDuplicate) {
            System.out.println("Result: No duplicate elements found.");
            return;
        }

        System.out.print("Result: Duplicate elements are: ");
        boolean isFirstDuplicatePrinted = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                // Check if it's the first occurrence of this duplicate number
                if (i == 0 || arr[i] != arr[i - 1]) {
                    if (!isFirstDuplicatePrinted) {
                        System.out.print(", ");
                    }
                    System.out.print(arr[i]);
                    isFirstDuplicatePrinted = false;
                }
            }
        }
        System.out.println(); // Final newline
    }
    private static void handleFindMissingNumber(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        int missing = findMissingNumber(arr);
        System.out.println("Result: The missing number is: " + missing);
    }

    private static int findMissingNumber(int[] arr) {
        int m = arr.length; // m = n-1
        int n = arr[m-1]-arr[0]+1;
        long expectedSum = (long) n * (arr[m-1]+arr[0]) / 2;
        long actualSum = 0;
        for (int x : arr) {
            actualSum += x;
        }
        return (int) (expectedSum - actualSum);
    }
    private static void handleMinMaxDifference(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        if (arr.length < 2) {
            System.out.println("Result: Need at least 2 elements.");
            return;
        }
        
        int minVal = arr[0];
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minVal) minVal = arr[i];
            if (arr[i] > maxVal) maxVal = arr[i];
        }
        System.out.println("Result: Maximum difference is: " + (maxVal - minVal));

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < sortedArr.length - 1; i++) {
            int diff = sortedArr[i + 1] - sortedArr[i];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        System.out.println("Result: Minimum difference is: " + minDiff);
    }
    private static void handleMaxFrequency(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        int maxFreqElement = findMaxFrequencyElement(arr);
        System.out.println("Result: Element with maximum frequency is: " + maxFreqElement);
    }

    private static int findMaxFrequencyElement(int[] arr) {
        if (arr.length == 0) return -1;
        
        // Arrays.sort(arr);
        
        int maxElement = arr[0];
        int maxCount = 0;
        int currentElement = arr[0];
        int currentCount = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == currentElement) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    maxElement = currentElement;
                }
                currentElement = arr[i];
                currentCount = 1;
            }
        }
        
        if (currentCount > maxCount) {
            maxElement = currentElement;
        }
        
        return maxElement;
    }
    private static void handleSumOfDistinct(Scanner sc) {
        int[] arr = getArrayFromUser(sc);
        long sum = sumOfDistinctElements(arr);
        System.out.println("Result: Sum of distinct elements is: " + sum);
    }

    private static long sumOfDistinctElements(int[] arr) {
        if (arr.length == 0) return 0;
        
        Arrays.sort(arr);
        
        long sum = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                sum += arr[i];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- AAD1 (CSE2631) LAB EXPERIMENT-03 MENU (Pure Array Version) ---");
            System.out.println("1. Selection sort");
            System.out.println("2. Array reduction");
            System.out.println("3. Merging two sorted arrays");
            System.out.println("4. Check reverse");
            System.out.println("5. Finding first repeated elements in an array");
            System.out.println("6. Print duplicates in a list");
            System.out.println("7. Find the missing number in an array");
            System.out.println("8. Find element pair with min/max difference");
            System.out.println("9. Find element which appears maximum number of times");
            System.out.println("10. Find the sum of distinct elements");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleSelectionSort(scanner);
                    break;
                case 2:
                    handleArrayReduction(scanner);
                    break;
                case 3:
                    handleMergeSorted(scanner);
                    break;
                case 4:
                    handleCheckReverse(scanner);
                    break;
                case 5:
                    handleFindFirstRepeated(scanner);
                    break;
                case 6:
                    handlePrintDuplicates(scanner);
                    break;
                case 7:
                    handleFindMissingNumber(scanner);
                    break;
                case 8:
                    handleMinMaxDifference(scanner);
                    break;
                case 9:
                    handleMaxFrequency(scanner);
                    break;
                case 10:
                    handleSumOfDistinct(scanner);
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
