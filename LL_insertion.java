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
}