class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 1. Handle empty or null matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int targetRow = -1;

        for (int i = 0; i < rows; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][cols - 1]) {
                targetRow = i;
                break; 
            }
        }

        if (targetRow == -1) {
            return false;
        }

        return Arrays.binarySearch(matrix[targetRow], target) >= 0;
    }
}
