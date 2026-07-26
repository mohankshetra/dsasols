import java.util.*;

class MedianFinder {

    // Max Heap for smaller half
    private PriorityQueue<Integer> left;

    // Min Heap for larger half
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1
        left.offer(num);

        // Step 2
        right.offer(left.poll());

        // Step 3
        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() > right.size()) {
            return left.peek();
        }

        return (left.peek() + right.peek()) / 2.0;
    }
}