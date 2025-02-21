package heaps;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    throws Exception {
        Heap<Integer> heap = new Heap<>();

        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);

        System.out.println(heap.remove());

        ArrayList<Integer> list = heap.heapSort();
        System.out.println(list);
    }
}
