class Solution {
    class Node{
        int currRow;
        int currCol;
        int remSuperPower;
        
        public Node(int r, int c, int s){
            currRow = r;
            currCol = c;
            remSuperPower = s;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        if(n==1 && m ==1)return 0;
        
        int maxRemSuperPower[][] = new int[n][m];
        for(int []row : maxRemSuperPower){
            Arrays.fill(row, -1);
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,k));
        maxRemSuperPower[0][0] = k;
        
        int level= 0;
        int dir[][] = new int[][]{{0,-1}, {0,1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- >0){
                Node currNode = q.poll();
                for(int i = 0;i<dir.length; i++){
                    int nextNodeRow = currNode.currRow + dir[i][0];
                    int nextNodeCol = currNode.currCol + dir[i][1];
                    if(nextNodeRow == n-1 && nextNodeCol == m-1){
                        return level+1;
                    }
                    
                    if(nextNodeRow >=0 && nextNodeRow<n && nextNodeCol>=0 && nextNodeCol<m){ // within matrix bounds        
                        if(grid[nextNodeRow][nextNodeCol] == 1 && currNode.remSuperPower >0 && maxRemSuperPower[nextNodeRow][nextNodeCol] < (currNode.remSuperPower-1)){
                            q.add(new Node(nextNodeRow, nextNodeCol, currNode.remSuperPower-1));
                            maxRemSuperPower[nextNodeRow][nextNodeCol] = currNode.remSuperPower-1;
                        }else if(grid[nextNodeRow][nextNodeCol] == 0 && maxRemSuperPower[nextNodeRow][nextNodeCol] < (currNode.remSuperPower)){
                            q.add(new Node(nextNodeRow, nextNodeCol, currNode.remSuperPower));
                            maxRemSuperPower[nextNodeRow][nextNodeCol] = currNode.remSuperPower;
                        }
                        
                    }
                }
            }
            level++;
        }
        return -1;
    }
}