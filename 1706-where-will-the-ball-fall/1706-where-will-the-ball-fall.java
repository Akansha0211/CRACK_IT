// class Solution {
//     public int[] findBall(int[][] grid) {
        
//     }
// }

class Solution {
    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for (int i = 0 ; i < grid[0].length ; i++) {
            ans[i] = dropsAt(grid, i);
        }
        return ans;
    }
    
    private int dropsAt(int[][] box, int droppedCol) {
        int r = 0;
        int c = droppedCol;
        boolean isStuck = false;
        while (r < box.length && !isStuck) {
            int nc = c + box[r][c];
            if (nc >= box[0].length || nc < 0) {
                isStuck = true;
                break;
            }
            if (box[r][nc] != box[r][c]) {
                isStuck = true;
            }
            c = nc;
            r += 1;
        }
        return isStuck ? -1 : c;
    }
}