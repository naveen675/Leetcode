//https://leetcode.com/problems/maximal-rectangle/?envType=daily-question&envId=2024-04-13
// O(row * (col * col));


class Solution {
    public int [] getLeftMin(int [] A){

        int [] min= new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<A.length; i++){
           int elm = A[i];

           while(stack.size() != 0 && elm <= A[stack.peek()]){ stack.pop(); }

           if(stack.size() != 0){ min[i] = stack.peek(); }
           else{ min[i] = -1;}

           stack.push(i); 
        }
        return min;
    }
    public int [] getRightMin(int [] A){

        int [] min = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=A.length-1; i>=0; i--){

            int elm = A[i];
            while(stack.size() != 0 && elm <= A[stack.peek()]){ stack.pop(); }

            if(stack.size() != 0){ min[i] = stack.peek(); }
            else{ min[i] = A.length; }

            stack.push(i);
        }
        return min;
    }

    public int getMaxArea(int [] A){
        /*  This approach is to find the max area of given histogram which */
        int [] leftMin = getLeftMin(A);        
        int [] rightMin = getRightMin(A); 
        long area = 0;

        for(int i=0; i<A.length; i++){
            area = Math.max(area, (long)A[i] * ((long)rightMin[i] - (long)leftMin[i] - (long)1));
        }
        return (int)area;
    }

    public int maximalRectangle(char[][] matrix) {

        int rowLength = matrix.length;
        int colLength = matrix[0] .length;
        int [] histogram = new int[colLength];
        int largeRectWithOne = 0;
        //System.out.println(getMaxArea(new int[]{3,2,4,5,3,2,4,2}));
        for(int row=0; row<rowLength; row++){
            for(int col=0; col<colLength; col++){

                if(matrix[row][col] == '1' ) { histogram[col]++; }      // to calculate height of histogram with continues ones in wor wise
                else{ histogram[col] = 0; }                          // edge case if there is break in 1 in rowwise
                                                                   // then height will become zero    
            }
            int area = getMaxArea(histogram);
            largeRectWithOne = Math.max(largeRectWithOne, area);
        }
        return largeRectWithOne;
    }
}
