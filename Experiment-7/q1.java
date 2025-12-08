import java.util.*;

public class q1 {
    // Question 1
    static class ArrayStack {
        private int[] arr;
        private int top;
        private int capacity;

        public ArrayStack(int size) {
            arr = new int[size];
            capacity = size;
            top = -1;
        }
        public void push(int x) {
            if (isFull()) {
                System.out.println("Stack Overflow");
                return;
            }
            arr[++top] = x;
        }
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return arr[top--];
        }
        public int peek() {
            if (!isEmpty()) return arr[top];
            return -1;
        }
        public boolean isEmpty() { return top == -1; }
        public boolean isFull() { return top == capacity - 1; }
        
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return;
            }
            System.out.print("[");
            for (int i = 0; i <= top; i++) {
                System.out.print(arr[i] + (i < top ? ", " : ""));
            }
            System.out.print("]");
        }
    }
    // Question 2
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; this.next = null; }
    }
    static class LinkedListStack{
        private Node top;
        public LinkedListStack() { this.top = null; }
        public void push(int x) {
            Node newNode = new Node(x);
            newNode.next = top;
            top = newNode;
        }
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }
            int val = top.data;
            top = top.next;
            return val;
        }
        public int peek() {
            if (isEmpty()) return -1;
            return top.data;
        }
        public boolean isEmpty() { return top == null; }
        
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return;
            }
            System.out.print("[");
            printRecursive(top);
            System.out.println("]");
        }
        private void printRecursive(Node current) {
            if (current == null) return;
            printRecursive(current.next);
            System.out.print(current.data + (current == top ? "" : ", "));
        }
    }
    // Question 3
    public static void sortedInsert(ArrayStack s, int item) {
        if(s.isEmpty() || item > s.peek()) {
            s.push(item);
        } else {
            int top = s.pop();
            sortedInsert(s, item);
            s.push(top);
        }
    }
    // Question 4
    public static void sortStack(ArrayStack s) {
        if(!s.isEmpty()) {
            int top = s.pop();
            sortStack(s);
            sortedInsert(s, top);
        }
    }
    // Question 5
    public static void insertAtBottom(ArrayStack s, int item) {
        if(s.isEmpty()) {
            s.push(item);
        } else {
            int top = s.pop();
            insertAtBottom(s, item);
            s.push(top);
        }
    }
    // Question 6
    public static void reverseStack(ArrayStack s) {
        if (!s.isEmpty()) {
            int top = s.pop();
            reverseStack(s);
            insertAtBottom(s, top);
        }
    }
    // Helper methods
    static void fillStack(ArrayStack s, Scanner sc) {
        System.out.print("Enter number of elements in the stack: ");
        int n = sc.nextInt();
        if (n > 0) {
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                s.push(sc.nextInt());
            }
        }
    }
    static void runArrayStack(Scanner sc) {
        System.out.print("Enter size of array stack: ");
        int size = sc.nextInt();
        ArrayStack s = new ArrayStack(size);
        
        while(true) {
            System.out.print("\n[ArrayStack] 1.Push 2.Pop 3.Peek 4.Display 0.Back: ");
            int c = sc.nextInt();
            if (c == 0) break;
            
            switch(c) {
                case 1: 
                    System.out.print("Enter value: ");
                    s.push(sc.nextInt()); 
                    break;
                case 2: 
                    int popped = s.pop();
                    if(popped != -1) System.out.println("Popped: " + popped);
                    break;
                case 3: 
                    System.out.println("Top Element: " + s.peek()); 
                    break;
                case 4: 
                    s.display(); 
                    break;
            }
        }
    }
    static void runLLStack(Scanner sc) {
        LinkedListStack s = new LinkedListStack();
        while(true) {
            System.out.print("\n[LL Stack] 1.Push 2.Pop 3.Display 4.Peek 0.Back: ");
            int c = sc.nextInt();
            if (c == 0) break;
            
            switch(c) {
                case 1: 
                    System.out.print("Enter value: ");
                    s.push(sc.nextInt()); 
                    break;
                case 2: 
                    int popped = s.pop();
                    if(popped != -1) System.out.println("Popped: " + popped);
                    break;
                case 3: 
                    s.display(); 
                    break;
                case 4:
                    s.peek();
                    break;
            }
        }
    }
    static void runSortedInsert(Scanner sc) {
        ArrayStack s = new ArrayStack(20);
        System.out.println("Please enter elements in Ascending Order.");
        fillStack(s, sc);
        
        System.out.print("Current Stack: "); s.display();
        System.out.println();
        System.out.print("Enter element to insert: ");
        int val = sc.nextInt();
        
        sortedInsert(s, val);
        System.out.print("Result: "); s.display();
    }
    static void runSortStack(Scanner sc) {
        ArrayStack s = new ArrayStack(20);
        fillStack(s, sc);
        
        System.out.print("Before Sorting: "); s.display();
        sortStack(s);
        System.out.println();
        System.out.print("After Sorting:  "); s.display();
    }
    static void runInsertBottom(Scanner sc) {
        ArrayStack s = new ArrayStack(20);
        fillStack(s, sc);
        
        System.out.print("Current Stack: "); s.display();
        System.out.println();
        System.out.print("Enter value to insert at bottom: ");
        int val = sc.nextInt();
        
        insertAtBottom(s, val);
        System.out.print("Result: "); s.display();
    }
    static void runReverse(Scanner sc) {
        ArrayStack s = new ArrayStack(20);
        fillStack(s, sc);
        
        System.out.print("Original: "); s.display();
        reverseStack(s);
        System.out.println();
        System.out.print("Reversed: "); s.display();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n========== EXPERIMENT 07 MENU ==========");
            System.out.println("1. Array Stack Implementation");
            System.out.println("2. Linked List Stack Implementation");
            System.out.println("3. Problem: Insert into Sorted Stack");
            System.out.println("4. Problem: Sort a Stack");
            System.out.println("5. Problem: Insert at Bottom");
            System.out.println("6. Problem: Reverse a Stack");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1: runArrayStack(sc); 
                        break;
                case 2: runLLStack(sc); 
                        break;
                case 3: runSortedInsert(sc); 
                        break;
                case 4: runSortStack(sc); 
                        break;
                case 5: runInsertBottom(sc); 
                        break;
                case 6: runReverse(sc); 
                        break;
                case 0: 
                    System.out.println("Exiting...");
                    sc.close(); 
                    return;
                default: 
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}