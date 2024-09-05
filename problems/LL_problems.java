import java.util.Stack;

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

public class LL_problems {
    public static void main(String[] args) {

    }

    private static Node stack_approach(Node head) {
        Node temp = head;
        Stack<Integer> st = new Stack<>();
        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = st.peek();
            st.pop();
            temp = temp.next;
        }
        return head;
    }

    private static Node swap_links(Node head) {
        Node current = head;
        Node last = null;
        while (current != null) {
            last = current.back;
            current.back = current.next;
            current.next = last;
            current = current.back;
        }
        return last.back;
    }

    private static Node middle_element(Node head) {
        // first approach
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int mid = (count / 2) + 1;
        while (temp != null) {
            mid--;
            if (mid == 0) break;
            temp = temp.next;
        }
        return temp;
    }

    private static Node tortoise_hare(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node rotatingLL(Node head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        Node tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        if (k % length == 0) {
            return head;
        }
        k = k % length;
        tail.next = head;
        Node newLastNode = findNthNode(head, length - k);
        head = newLastNode.next;
        newLastNode.next = null;
        return head;
    }

    private static Node findNthNode(Node head, int k) {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            if (cnt == k) return temp;
            temp = temp.next;
        }
        return temp;
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
}