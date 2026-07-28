class Solution {
    public int[] plusOne(int[] digits) {
        boolean overTen = true;
        for (int i = digits.length - 1; overTen && i >= 0; i--) {
            digits[i] += 1;
            if (digits[i] <= 9) {
                overTen = false;
            } else {
                digits[i] -= 10;
            }
        }
        if (overTen) {
            int[] bigger = new int[digits.length + 1];
            System.arraycopy(digits, 0, bigger, 0, digits.length);
            bigger[0] = 1;
            return bigger;
        }
        return digits;
    }
}
