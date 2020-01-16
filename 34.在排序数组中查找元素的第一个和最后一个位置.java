class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = leftBound(nums, target, true);
        int right = leftBound(nums, target, false);
        return new int[]{left, right};
    }

    private int leftBound(int[] nums, int target, boolean left) {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res = mid;
            }
            if (nums[mid] > target || (left && (nums[mid] == target))) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}