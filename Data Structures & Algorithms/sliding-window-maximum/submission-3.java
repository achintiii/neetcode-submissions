class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    int[] output = new int[nums.length - k + 1];
    Deque<Integer> queue = new LinkedList<>();
    int left = 0;
    int right = 0;

    while (right < nums.length) {
        while (!queue.isEmpty() && nums[queue.getLast()] < nums[right]) {
            queue.removeLast();
        }

        queue.addLast(right);

        if (queue.getFirst() < left) {
            queue.removeFirst();
        }

        if (right + 1 >= k) {
            output[left] = nums[queue.getFirst()];
            left++;
        }

        right++;
    }

    return output;
}
}
