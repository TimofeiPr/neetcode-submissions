class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<Integer>());
        for(int num : nums) {
            int size = arr.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> addOn = new ArrayList<>(arr.get(i));
                addOn.add(num);
                arr.add(addOn);
            }
        }
        return arr;
    }
}
