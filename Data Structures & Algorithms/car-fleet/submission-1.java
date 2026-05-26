class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double max = 0;
        int output = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], i);
        }

        Arrays.sort(position);

        for (int i = position.length - 1; i >= 0; i--) {
            int pos = position[i];
            int sp = speed[map.get(pos)];
            double time = (double) (target - pos) / sp;
            if (max == 0) {
                max = time;
            } else if (max < time) {
                output++;
                max = time;
            } 
        }
        output++; //for the final fleet
        return output;
    }
}
