class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();
        for(int row = 0; row<matrix.length; row++){
            for(int col = 0; col<matrix[0].length; col++){
                if(matrix[row][col] == 0){
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        // update the elements
        for(int row = 0; row<matrix.length; row++){
            for(int col = 0; col<matrix[0].length; col++){
                if(rows.contains(row) || cols.contains(col)){
                    matrix[row][col] = 0;
                }
            }
        }
    }
}