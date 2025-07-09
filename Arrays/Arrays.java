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
//###########################################################################################################################################
//PROBLEM3= PERMUTATION
class Solution {
    public void nextPermutation(int[] nums) {
        int l = nums.length;
        int idx = -1;

        // 1️⃣ Find the first index 'idx' from the end where nums[i] < nums[i+1]
        for (int i = l - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // 2️⃣ If no such index exists, reverse the array and return
        if (idx == -1) {
            reverse(nums, 0, l - 1);
            return;
        }

        // 3️⃣ Find the smallest number greater than nums[idx] to the right
        for (int i = l - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                // swap nums[i] and nums[idx]
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        // 4️⃣ Reverse the right part after idx
        reverse(nums, idx + 1, l - 1);
    }
    // Helper method to reverse part of the array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
//############################################################################################################################################################
// PROBLEM:4- https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        // int l = nums.length;
        // int sum=0;
        // int max= Integer.MIN_VALUE;
        // for(int i=0;i<l;i++){
        //     for(int j=i;j<l;j++){
        //         sum+=nums[j];
        //         max=Math.max(sum,max);
        //         //System.out.println(max);
        //     }
        //     sum=0;
        // }
        //  return max;

        int maxSoFar = nums[0];  // First element is already counted
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSoFar = Math.max(maxSoFar, currSum);
        }
        return maxSoFar;
    }
}
//DAY 5


