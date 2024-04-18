//https://leetcode.com/problems/island-perimeter/?envType=daily-question&envId=2024-04-18
// O(row * col * 4) O(1)
class Solution {
    public int islandPerimeter(int[][] grid) {

        int rowLength = grid.length;
        int colLength = grid[0].length;
        int [] dx = {0,0,1,-1};
        int [] dy = {1,-1, 0,0};
        int perimeter =0;
        for(int row=0; row<rowLength; row++){
            
            for(int col=0; col<colLength; col++){
                int neighbours =0;
                if(grid[row][col] == 1){                
                    for(int i=0; i<dx.length; i++){
                        int r = dx[i] + row;
                        int c = dy[i] + col;
                        if(r >= 0 && r < rowLength && c >=0 && c < colLength && grid[r][c] == 1){
                            neighbours++;
                        }
                    }                 
                    perimeter = perimeter + 4 - neighbours;
                }   
            }
        }
        return perimeter; 
    }
}
