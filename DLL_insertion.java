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

public class DLL_insertion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = convertArr2DLL(arr);
        print(insertBeforeHead(head, 11));
        print(insertBeforeTail(head, 12));
        print(insertBeforeKthElement(head, 14, 3));
        print(insertbeforeNode(head.next.next, 7));
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

    private static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node insertBeforeHead(Node head, int val) {
        Node newHead = new Node(val, head, null);
        head.back = newHead;
        return newHead;
    }

    private static Node insertBeforeTail(Node head, int val) {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.back;
        Node node = new Node(val, tail, prev);
        prev.next = node;
        tail.back = node;
        return head;
    }

    private static Node insertBeforeKthElement(Node head, int val, int k) {
        if (k == 1) {
            return insertBeforeHead(head, val);
        }
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            if (count == k) break;
            temp = temp.next;
        }
        Node prev = temp.back;
        Node node = new Node(val, temp, prev);
        prev.next = node;
        temp.back = node;
        return head;
    }

    private static void insertbeforeNode(Node temp, int val) {
        Node prev = temp.back;
        Node newNode = new Node(val, temp, prev);
        prev.next = newNode;
        temp.back = newNode;
    }
}