class Solution {
    class Pair{
        int row;
        int col;
        int remPower;
        Pair(int row, int col, int remPower){
            this.row = row;
            this.col = col;
            this.remPower = remPower;
        }
    }
    public int shortestPath(int[][] grid, int k) {          
        int n = grid.length;
        int m = grid[0].length;
        if(n==1 && m==1)return 0; // ALREADY REACHED DESTINATION
        int[][] maxPower = new int[n][m];
        for(int[] row : maxPower){
            Arrays.fill(row, -1);
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0, k));
        maxPower[0][0] = k;
        int[][] dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                Pair remPair = q.poll();
                for(int j = 0; j<dir.length; j++){
                    int x = remPair.row + dir[j][0];
                    int y = remPair.col + dir[j][1];
                    if(x == n-1 && y == m-1)return (level+1);
                    if((x>=0 && x<n) && (y>=0 && y<m) ){
                        if(grid[x][y] == 1 && remPair.remPower >0 && maxPower[x][y]<(remPair.remPower-1)){
                           q.add(new Pair(x,y, remPair.remPower -1));
                            maxPower[x][y] = remPair.remPower-1; 
                        }else if(grid[x][y] == 0 && maxPower[x][y] <(remPair.remPower)){
                            q.add(new Pair(x, y, remPair.remPower));
                            maxPower[x][y] = remPair.remPower;
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}