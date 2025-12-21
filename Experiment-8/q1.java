import java.util.*;
public class q1 {
    static Scanner sc = new Scanner(System.in);
    static class MyStack {
        int [] arr; 
        int top;
        MyStack(int size) {
            arr = new int[size];
            top = -1;
        }
        void push(int x) {
            if(top == arr.length - 1) {
                System.out.println("Stack Overflow");
                return;
            }
            arr[++top] = x;
        }
        int pop() {
            if(top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return arr[top--];
        }
        void display() {
            for(int i=0; i<=top; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        boolean isEmpty() { return top==-1; }
    }
    static class MyQueue {
        int[] arr; int front, rear, count, capacity;
        MyQueue(int size) {
            arr = new int[size];
            capacity = size;
            front = 0; rear = -1; count = 0;
        }
        void enqueue(int x) {
            if(count == capacity) {
                System.out.println("Queue Overflow");
                return;
            }
            rear = (rear + 1) % capacity;
            arr[rear] = x;
            count++;
        }
        int dequeue() {
            if(count == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            int x = arr[front];
            front = (front + 1) % capacity;
            count--;
            return x;
        }
        int peek() {
            if(count == 0) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }
        void display() {
            for (int i = 0; i < count; i++) {
                System.out.print(arr[(front + i) % capacity] + " ");
            }
            System.out.println();
        }
        boolean isEmpty() { return count == 0; }
    }
    static class MyDeque {
        int[] arr;
        int front, rear, count, capacity;

        MyDeque(int size) {
            arr = new int[size];
            capacity = size;
            front = -1;
            rear = 0;
            count = 0;
        }
        void insertRear(int x) {
            if (count == capacity) return;
            if (front == -1) {
                front = 0;
                rear = 0;
            } else {
                rear = (rear + 1) % capacity;
            }
            arr[rear] = x;
            count++;
        }
        void deleteFront() {
            if (count == 0) return;
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            count--;
        }
        void deleteRear() {
            if (count == 0) return;
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (rear == 0) {
                rear = capacity - 1;
            } else {
                rear--;
            }
            count--;
        }
        int getFront() {
            return count == 0 ? -1 : arr[front];
        }
        int getRear() {
            return count == 0 ? -1 : arr[rear];
        }
        boolean isEmpty() {
            return count == 0;
        } 
    }
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    static class LinkedListQueue {
        Node front, rear;

        void enqueue(int x) {
            Node newNode = new Node(x);
            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        int dequeue() {
            if (front == null) return -1;
            int x = front.data;
            front = front.next;
            if (front == null) rear = null;
            return x;
        }
        int peek() {
            if (front == null) return -1;
            return front.data;
        }
        void display() {
            Node temp = front;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    // Question 1
    static void runArrayQueue(Scanner sc) {
        System.out.print("Enter size of array queue: ");
        int size = sc.nextInt();
        MyQueue q = new MyQueue(size);

        while (true) {
            System.out.print("\n[ArrayQueue] 1.Enqueue 2.Dequeue 3.Peek 4.Display 0.Back: ");
            int c = sc.nextInt();
            if (c == 0) break;

            switch (c) {
                case 1:
                    System.out.print("Enter value: ");
                    q.enqueue(sc.nextInt());
                    break;
                case 2:
                    int val = q.dequeue();
                    if (val != -1) System.out.println("Dequeued: " + val);
                    else System.out.println("Underflow");
                    break;
                case 3:
                    int top = q.peek();
                    if (top != -1) System.out.println("Front Element: " + top);
                    else System.out.println("Queue is Empty");
                    break;
                case 4:
                    q.display();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    // Question 2
    static void runLLQueue(Scanner sc) {
        LinkedListQueue q = new LinkedListQueue(); 
        
        while (true) {
            System.out.print("\n[LL Queue] 1.Enqueue 2.Dequeue 3.Peek 4.Display 0.Back: ");
            int c = sc.nextInt();
            if (c == 0) break;

            switch (c) {
                case 1:
                    System.out.print("Enter value: ");
                    q.enqueue(sc.nextInt());
                    break;
                case 2:
                    int val = q.dequeue();
                    if (val != -1) System.out.println("Dequeued: " + val);
                    else System.out.println("Underflow");
                    break;
                case 3:
                    int top = q.peek();
                    if (top != -1) System.out.println("Front Element: " + top);
                    else System.out.println("Queue is Empty");
                    break;
                case 4:
                    q.display();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    // Question 3
    static void reverseStack() {
        System.out.print("Enter Stack Size: ");
        int n = sc.nextInt();
        MyStack stack = new MyStack(n);
        MyQueue queue = new MyQueue(n);
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) stack.push(sc.nextInt());

        System.out.print("Original: "); stack.display();
        while (!stack.isEmpty()) queue.enqueue(stack.pop());
        queue.display();
        while (!queue.isEmpty()) stack.push(queue.dequeue());
        System.out.print("Reversed: "); stack.display();
    }
    // Question 4
    static void slidingWindowMaximum() {
        System.out.print("Enter N: "); int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Elements: "); for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.print("Enter K: "); int k = sc.nextInt();
        MyDeque dq = new MyDeque(n);
        System.out.print("Result: ");
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.getFront() <= i - k) dq.deleteFront();
            while (!dq.isEmpty() && arr[dq.getRear()] <= arr[i]) dq.deleteRear();
            dq.insertRear(i);

            if (i >= k - 1) System.out.print(arr[dq.getFront()] + " ");
        }
        System.out.println();
    }
    // Question 5
    static void josephusProblem() {
        System.out.print("Players & N: "); int p = sc.nextInt(); int n = sc.nextInt();
        MyQueue q = new MyQueue(p);
        for (int i = 1; i <= p; i++) q.enqueue(i);
        System.out.print("Eliminated: ");
        while (q.count > 1) {
            for (int i = 0; i < n - 1; i++) q.enqueue(q.dequeue());
            System.out.print(q.dequeue() + " ");
        }
        System.out.println("\nWinner: " + q.peek());
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- LAB EXPERIMENT 08 ---");
            System.out.println("1. Array Queue Implementation");
            System.out.println("2. Linked List Queue Implementation");
            System.out.println("3. Reverse Stack using Queue");
            System.out.println("4. Sliding Window Maximum");
            System.out.println("5. Josephus Problem");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: runArrayQueue(sc); 
                        break;
                case 2: runLLQueue(sc); 
                        break;
                case 3: reverseStack(); 
                        break;
                case 4: slidingWindowMaximum(); 
                        break;
                case 5: josephusProblem(); 
                        break;
                case 6: System.out.println("Exiting..."); 
                        return;
            }
        }
    }
}
