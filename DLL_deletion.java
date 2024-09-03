class Node {
    int data;
    Node next;
    Node back;

    Node(int data1, Node next1, Node back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
    }
} 

public class DLL_deletion {
    public static void main(String[] args) {
        int[] arr = {23, 21, 56, 67, 93, 54};
        Node head = convertArr2DLL(arr);
        // print(deleteHead(head));
        // System.out.println();
        // print(deleteTail(head));
        // System.out.println();
        // print(removeKthElement(head, 4));
        deleteNode(head.next);
        print(head);
    }

    private static Node convertArr2DLL(int[] arr) {
         Node head = new Node(arr[0]);
         Node prev = head;
         for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
          }
         return head;
        }

    private static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }

    private static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node newTail = tail.back;
        newTail.next = null;
        tail.back = null;

        return head;
    }

    private static Node removeKthElement(Node head, int k) {
        if (head == null) {
            return null;
        }
        int count = 0;
        Node knode = head;
        while (knode != null) {
            count++;
            if (count == k) break;
            knode = knode.next;
        }
        Node prev = knode.back;
        Node front = knode.next;

        if (prev == null && front == null) {
            return null;
        }
        else if (prev == null) {
            return deleteHead(head);
        }
        else if (front == null) {
            return deleteTail(head);
        }
        prev.next = front;
        front.back = prev;
        knode.next = null;
        knode.back = null;

        return head;
    }

    private static void deleteNode(Node temp) {
        Node prev = temp.back;
        Node front = temp.next;
        if (front == null) {
            prev.next = null;
            temp.back = null;
        }

        prev.next = front;
        front.back = prev;

        temp.next = null;
        temp.back = null;
    }

    private static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
