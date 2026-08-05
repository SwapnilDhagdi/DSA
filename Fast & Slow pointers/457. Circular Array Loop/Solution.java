class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            int slow = i;
            int fast = i;
            boolean dir = nums[i] > 0;

            while (true) {
                slow = getNext(nums, slow, dir);
                if (slow == -1) break;

                fast = getNext(nums, fast, dir);
                if (fast == -1) break;

                fast = getNext(nums, fast, dir);
                if (fast == -1) break;

                if (slow == fast) return true;
            }

            int cur = i;
            while (true) {
                int next = getNext(nums, cur, nums[cur] > 0);
                nums[cur] = 0;
                if (next == -1) break;
                cur = next;
            }
        }

        return false;
    }

    private int getNext(int[] nums, int index, boolean dir) {
        boolean currDir = nums[index] > 0;
        if (currDir != dir) return -1;

        int n = nums.length;
        int next = ((index + nums[index]) % n + n) % n;

        if (next == index) return -1;

        if ((nums[next] > 0) != dir) return -1;

        return next;
    }
}
