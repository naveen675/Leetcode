//https://leetcode.com/problems/number-of-islands/
//O(row * col) O(1)
class Solution {
    public void dfs(char[][] map, int x, int y){

        int []dx = {0,0,1,-1};
        int []dy ={1,-1,0,0};
        map[x][y] = 'x';

        for(int i=0; i<4; i++){
            
            int adjx = x + dx[i];
            int adjy = y + dy[i];
            if(adjx >=0 && adjx < map.length && adjy >=0 && adjy < map[0].length && map[adjx][adjy] == '1'){
                dfs(map, adjx, adjy);
            }
        }
    }
    public int numIslands(char[][] grid) {

        int noOfIslands =0;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        for(int row=0; row<rowLength; row++){
            for(int col=0; col<colLength; col++){

                if(grid[row][col] == '1'){
                    noOfIslands++;
                    dfs(grid, row, col);
                }
            }
        }

        return noOfIslands;  
    }
}
