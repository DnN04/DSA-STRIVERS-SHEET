// PROBLEM:1- https://leetcode.com/problems/set-matrix-zeroes/
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean zerorow=false;
        boolean zerocol=false;
        //FIRST COL
        for(int i=0;i<m;i++){
            if (matrix[i][0]==0){
                zerocol=true;
            }
        }
        //FIRST ROW
        for(int j=0;j<n;j++){
            if (matrix[0][j]==0){
                zerorow=true;
            }
        }
        //INSIDE MATRIX
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if (matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }      
           }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if((matrix[i][0] == 0)|| (matrix[0][j]==0)){
                    matrix[i][j]=0;
                }

            }
        }

        //first row/col//
        if (zerorow){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
        if(zerocol){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
        }
}

//PROBLEM2= 