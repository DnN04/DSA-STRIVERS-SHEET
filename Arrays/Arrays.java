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
//###########################################################################################################################################
//PROBLEM2= PASCALS TRIANGLE
import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();  // ← YOU MISSED THIS

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int left = triangle.get(i - 1).get(j - 1);
                    int right = triangle.get(i - 1).get(j);
                    row.add(left + right);
                }
            }

            triangle.add(row);
        }

        return triangle;
    }
}
