import java.util.*;
public class q1 {
    static Scanner sc = new Scanner(System.in);
    static class SNode {
        int data;
        SNode next;
        SNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class DNode {
        int data;
        DNode next , prev;
        DNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    static class AdjNode {
        int vertex;
        AdjNode next;
        AdjNode(int vertex) {
            this.vertex = vertex;
            this.next = null;
        }
    }
    private SNode sHead = null; 
    private DNode dHead = null; 
    private AdjNode[] adjList = null; 
    private int numVertices = 0;
    // Task 1 ....
     void insertSortedSLL() {
        System.out.print("Enter number of integers to insert: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " integers: ");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            SNode newNode = new SNode(val);
            if (sHead == null || sHead.data >= val) {
                newNode.next = sHead;
                sHead = newNode;
            } else {
                SNode current = sHead;
                while (current.next != null && current.next.data < val) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }
        System.out.println("All " + n + " integers inserted.");
        displaySLL();
    }
     void displaySLL() {
        if (sHead == null) {
            System.out.println("Singly List is empty.");
            return;
        }
        System.out.print("Current Sorted List: ");
        SNode temp = sHead;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
    //Some helper methods...
    private void addNeighbor(int src, int dest) {
        AdjNode newNode = new AdjNode(dest);
        newNode.next = adjList[src];
        adjList[src] = newNode;
    }
    public void displayGraph() {
        if (numVertices == 0 || adjList == null) {
            System.out.println("Graph is empty. Run Task 2 first.");
            return;
        }
        System.out.println("\n--- Adjacency List Representation ---");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ":");
            AdjNode temp = adjList[i];
            while (temp != null) {
                System.out.print(" -> " + temp.vertex);
                temp = temp.next;
            }
            System.out.println();
        }
    }
    // Task 2 ......
    public void matrixToList() {
        System.out.print("Enter number of vertices: ");
        numVertices = sc.nextInt();
        adjList = new AdjNode[numVertices];

        System.out.println("Enter the Adjacency Matrix (" + numVertices + "x" + numVertices + "):");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                int edge = sc.nextInt();
                if (edge == 1) {
                    addNeighbor(i, j);
                }
            }
        }
        System.out.println("Adjacency List constructed successfully.");
        displayGraph();
    }
    // Task 3 ......
    public void addEdge() {
        if (numVertices == 0 || adjList == null) {
            System.out.println("Please construct the graph (Task 2) first.");
            return;
        }
        System.out.print("Enter source vertex (0 to " + (numVertices - 1) + "): ");
        int u = sc.nextInt();
        System.out.print("Enter destination vertex (0 to " + (numVertices - 1) + "): ");
        int v = sc.nextInt();

        if (u >= numVertices || v >= numVertices || u < 0 || v < 0) {
            System.out.println("Invalid vertices.");
            return;
        }
        addNeighbor(u, v);
        addNeighbor(v, u);
        
        System.out.println("Edge added between " + u + " and " + v + ".");
        displayGraph();
    }
    // Task 4 ....
    private void printReverseRecursive(SNode node) {
        if (node == null) return;
        printReverseRecursive(node.next);
        System.out.print(node.data + " ");
    }

    public void SLLReverse() {
        System.out.print("Enter number of integers to insert:  ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("List is empty.");
            return;
        }
        SNode tempHead = null;
        SNode tempTail = null;
        System.out.println("Enter " + n + " integers:");
        for(int i = 0; i < n; i++) {
            int val = sc.nextInt();
            SNode newNode = new SNode(val);
            if (tempHead == null) {
                tempHead = newNode;
                tempTail = newNode;
            } else {
                tempTail.next = newNode;
                tempTail = newNode;
            }
        }
        System.out.print("List printed in reverse: ");
        printReverseRecursive(tempHead);
        System.out.println();
    }
    // Task 5 .....
    public void ReverseDLL() {
        dHead = null; 
        System.out.println("\n--- Task 5: Reverse Doubly Linked List ---");
        System.out.print("Enter number of integers to insert: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Empty list.");
            return;
        }
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            DNode newNode = new DNode(val);
            
            if (dHead == null) {
                dHead = newNode;
            } else {
                DNode temp = dHead;
                while (temp.next != null) temp = temp.next;
                temp.next = newNode;
                newNode.prev = temp;
            }
        }
        System.out.print("Original List: ");
        displayDLL();
        if (dHead != null) {
            DNode temp = null;
            DNode current = dHead;
            while (current != null) {
                temp = current.prev;
                current.prev = current.next;
                current.next = temp;
                current = current.prev; 
            }
            if (temp != null) {
                dHead = temp.prev;
            }
        }
        System.out.print("Reversed List: ");
        displayDLL();
    }
    public void displayDLL() {
        DNode temp = dHead;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
         public static void main(String[]args) {
        q1 solve = new q1();
        while(true) {
            System.out.println("\n============= TASK MENU =============");
            System.out.println("1. Insert into Sorted Singly Linked List ");
            System.out.println("2. Convert Adj Matrix to Adj List ");
            System.out.println("3. Add Edge to Graph ");
            System.out.println("4. Reverse Singly Linked List ");
            System.out.println("5. Reverse Doubly Linked List ");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1: 
                    solve.insertSortedSLL(); 
                    break;
                case 2: 
                    solve.matrixToList(); 
                    break;
                case 3: 
                    solve.addEdge(); 
                    break;
                case 4:
                    solve.SLLReverse();
                    break;
                case 5:
                    solve.ReverseDLL();
                    break;
                case 6:
                    System.out.println("Exiting....");
                    return;
            }
        }

    }
}
