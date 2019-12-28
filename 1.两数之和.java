class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                break;
            }
            map.put(nums[i], i);
        }
        
        return new int[]{map.get(target - nums[i]), i};
    }
}