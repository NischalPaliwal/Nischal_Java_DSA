class Node {
    int data;
    Node next;
    Node (int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }
    Node (int data1) {
        this.data = data1;
        this.next = null;
    }
}

public class LL_deletion {
    public static void main(String[] args) {
        int[] arr = {12, 23, 34, 45, 56, 67};
        Node head = convertArr2LL(arr);
        print(head);
        print(removeHead(head));
        print(removeTail(head));
        print(removeK(head, 3));
        print(removeElement(head, 23));
    }

    private static Node convertArr2LL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    private static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    private static Node removeHead(Node head) {
        if (head == null) {
            return null;
        }
        head = head.next;
        return head;
    }

    private static Node removeTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node removeK(Node head, int k) {
        if (head == null) {
            return head;
        }
        if (k == 1) {
            head = head.next;
            return head;
        }
        Node temp = head;
        int cnt = 0;
        Node prev = null;
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node removeElement(Node head, int element) {
        if (head == null) {
            return null;
        }
        if (head.data == element) {
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.data == element) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
