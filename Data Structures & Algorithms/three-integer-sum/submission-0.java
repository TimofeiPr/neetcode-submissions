class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> output = new ArrayList<List<Integer>>();

        int j;
        int k;

        for (int i = 0; i < nums.length - 2; i++) {
            j = i+1;
         
            k= nums.length - 1;

            while (j < k) {
                
    int sum = nums[i] + nums[j] + nums[k]; 

                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    Collections.addAll(temp, nums[i], nums[j], nums[k]);
                    if (!output.contains(temp)) {
                        output.add(temp);
                    }
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return output;
    }
}
