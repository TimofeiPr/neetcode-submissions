class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> ints = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    ints.add(i);
                    ints.add(j);
                    return new int[]{ints.get(0), ints.get(1)};
                }
            }
        }
        return new int[0];
    }
}
