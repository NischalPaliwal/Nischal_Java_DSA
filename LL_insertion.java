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

class LL_insertion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node head = convertArr2LL(arr);
        print(insertHead(head, 12));
        print(insertTail(head, 21));
        print(insertK(head, 33, 5));
        print(insertBeforeElement(head, 17, 7));
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

    private static Node insertHead(Node head, int val) {
        Node temp = new Node(val, head);
        return temp;
    }

    private static Node insertTail(Node head, int val) {
        if (head == null) return new Node(val);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
        return head;
    }

    private static Node insertK(Node head, int value, int k) {
        if (head == null) {
            if (k == 1) {
                return new Node(value);
            } else {
                return null;
            }
        }
        if (k == 1) {
            return new Node(value, head);
        }
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            if (cnt == (k - 1)) {
                Node n = new Node(value);
                n.next = temp.next;
                temp.next = n;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private static Node insertBeforeElement(Node head, int value, int element) {
        if (head == null) {
            return null;
        }
        if (head.data == element) {
            return new Node(value, head);
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == element);
            Node n = new Node(value, temp.next);
            temp.next = n;
            break;
        }
        temp = temp.next;
        return head;
    }
}