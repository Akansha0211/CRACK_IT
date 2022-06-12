class Solution {
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {
        
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i,j));
                }
            }
        }
        
        int[][] dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- >0){
                Pair rem = queue.poll();
                for(int k = 0; k<dir.length; k++){
                    int x = rem.x + dir[k][0];
                    int y = rem.y + dir[k][1];
                    if(x>=0 && y>=0 && x<grid.length && y< grid[0].length && grid[x][y] == 1){
                        grid[x][y] = 2; // rotten
                        queue.add(new Pair(x,y));
                        
                    }
                }
            }
            if(!queue.isEmpty()) time++;
        }
        
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1)return -1;
            }
        }
        return time;
    }
}