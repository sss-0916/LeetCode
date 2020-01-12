class Solution {
    public int removeDuplicates(int[] nums) {
        int i, j;
        for (i = 1, j = 0; i < nums.length; ++i) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        
        return j + 1;
    }
}