class Solution {
    class Pair{
        int x; 
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                //mark all corner O as safe and apply bfs on them 
                if((i == 0  || i== rows-1 || j == 0 || j == cols-1) && board[i][j] == 'O'){
                    Queue<Pair> queue = new LinkedList<>();
                    board[i][j] = 'S';
                    queue.add(new Pair(i,j));
                    while(!queue.isEmpty()){
                        Pair rem = queue.poll();
                        for(int k = 0; k<dir.length; k++){
                            int x = rem.x + dir[k][0];
                            int y = rem.y + dir[k][1];
                            if((x>=0 && y>=0 && x<rows && y< cols) && board[x][y] == 'O'){
                                board[x][y] = 'S';
                                queue.add(new Pair(x,y));
                            }
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(board[i][j] == 'S'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                 }
            }
        }
    }
}