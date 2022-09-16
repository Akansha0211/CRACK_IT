class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if((i == 0 || j==0 || j==m-1 || i==n-1)&& board[i][j] == 'O'){
                    q.add(new int[]{i,j});
                    board[i][j] = 'S'; // mark it as safe
                }
            }
        }
        int[][] dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] rem = q.poll();
                for(int k = 0; k<dir.length; k++){
                    int x = rem[0] + dir[k][0];
                    int y = rem[1] + dir[k][1];
                    if((x>=0 && x<n) && (y>=0 && y<m) && board[x][y]=='O'){
                        q.add(new int[]{x,y});
                        board[x][y] = 'S';
                    }
                }
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] =='S'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}