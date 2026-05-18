class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] output = new int[2];
        output[0] = 0;
        output[1] = (numbers.length - 1);
        System.out.println(numbers.length - 1);
        boolean targetFound = false;

        while (!targetFound) {
            if ((numbers[output[0]] + numbers[output[1]]) == target) {
                targetFound = true;
            } else if ((numbers[output[0]] + numbers[output[1]]) > target) {
                output[1] -= 1; 
            } else {
                output[0] += 1;
            }
        }

        output[0] += 1;
        output[1] += 1;

        return output;
    }
}
