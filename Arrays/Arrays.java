/////nqueen
// Online C compiler to run C program online
#include <stdio.h>
#include<math.h>
#include<stdlib.h>

int board[10],n;
int isSafe(int row , int col){
    for(int i=0; i<row ; i++){
        int j = board[i];
        if(j==col || abs(row-i)== abs(j-col)){
            return 0;
        }
    }

    return 1;
}

void printBoard(){
    for(int i=0; i<n;i++){
        for(int j=0;j<n;j++){
            if(board[i]==j){
                printf("Q ");
            }
            else{
                printf(". ");
            }
        }
        printf("\n");
    }
    printf("\n");
}

void nqueen(int row){
    for(int j=0;j<n;j++){
        if(isSafe(row,j)){
            board[row]=j;
            
            if(row==n-1){
                printBoard();
            }
            else{
                nqueen(row+1);
            }
            
        }
    }
}
int main() {

    printf("Enter number of queens: \n");
    scanf("%d",&n);
    nqueen(0);

    return 0;
}


/////////////////
import java.util.*;

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        DSU dsu = new DSU(n);

        for (int[] swap : allowedSwaps) {
            dsu.union(swap[0], swap[1]);
        }

        Map<Integer, List<Integer>> groups = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int parent = dsu.find(i);
            groups.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
        }

        int distance = 0;

        for (List<Integer> group : groups.values()) {
            Map<Integer, Integer> freq = new HashMap<>();

            for (int idx : group) {
                freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
            }

            for (int idx : group) {
                if (freq.getOrDefault(target[idx], 0) > 0) {
                    freq.put(target[idx], freq.get(target[idx]) - 1);
                } else {
                    distance++;
                }
            }
        }

        return distance;
    }
}

class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pa] = pb;
    }
}
import java.util.*;

class Solution {

    public int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                minDist = Math.min(minDist, i - map.get(nums[i]));
            }

            int rev = reverse(nums[i]);
            map.put(rev, i);  // 🔥 store reversed value
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int diff = Math.abs(i - startIndex);
                int dist = Math.min(diff, n - diff);
                minDist = Math.min(minDist, dist);
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
//==============================
import java.util.*;

class Solution {
    long[][] dp;
    
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        
        int n = robot.size();
        int m = factory.length;
        
        dp = new long[n][m];
        for (long[] row : dp) Arrays.fill(row, -1);
        
        return solve(0, 0, robot, factory);
    }
    
    private long solve(int i, int j, List<Integer> robot, int[][] factory) {
        if (i == robot.size()) return 0;
        if (j == factory.length) return Long.MAX_VALUE;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        long res = solve(i, j + 1, robot, factory); // skip factory
        
        long dist = 0;
        for (int k = 0; k < factory[j][1] && i + k < robot.size(); k++) {
            dist += Math.abs(robot.get(i + k) - factory[j][0]);
            long next = solve(i + k + 1, j + 1, robot, factory);
            
            if (next != Long.MAX_VALUE) {
                res = Math.min(res, dist + next);
            }
        }
        
        return dp[i][j] = res;
    }
}
//=======================
class Solution {

    private int dist(int a, int b) {
        if (a == -1 || b == -1) return 0;
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int minimumDistance(String word) {
        int n = word.length();
        int[][] dp = new int[27][27];

        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[26][26] = 0;

        for (int k = 0; k < n; k++) {
            int curr = word.charAt(k) - 'A';
            int[][] next = new int[27][27];

            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {
                    next[i][j] = Integer.MAX_VALUE;
                }
            }

            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {
                    if (dp[i][j] == Integer.MAX_VALUE) continue;

                    next[curr][j] = Math.min(next[curr][j],
                            dp[i][j] + dist(i == 26 ? -1 : i, curr));

                    next[i][curr] = Math.min(next[i][curr],
                            dp[i][j] + dist(j == 26 ? -1 : j, curr));
                }
            }

            dp = next;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                res = Math.min(res, dp[i][j]);
            }
        }

        return res;
    }
}
//11.04
import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (List<Integer> list : map.values()) {
            int size = list.size();
            if (size < 3) continue;

            for (int i = 0; i + 2 < size; i++) {
                int dist = 2 * (list.get(i + 2) - list.get(i));
                ans = Math.min(ans, dist);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
//08.04

class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            for (int i = l; i <= r; i += k) {
                long val = (long) nums[i] * v;
                nums[i] = (int) (val % MOD);
            }
        }

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}
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
//#########################################################################################################################################
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
//############################################################################################################################################################
// PROBLEM:5- https://leetcode.com/problems/sort-colors
// class Solution {
//     public void sortColors(int[] nums) {             //triedand failed
//         int n = nums.length;
//         for(int i=0;i<n;i++){
//            if(nums[i]!=nums[i+1]){
//             int temp = nums[i+1];
//             for(int j=i+1;j<n;j++){
//                 if(nums[j]==nums[i]){
//                     nums[i+1]=nums[j];
//                     nums[j]=temp;
//                 }
//             }
//            }
//         }
   
//     }
// }
//working code
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}
//############################################################################################################################################################
//DAY 6
// PROBLEM:6- https://leetcode.com/problems/sort-colors
// class Solution {
//     public int maxProfit(int[] prices) {       //BUT SOME TEST CASES FAILED AS IT TAKES ONLY LEAST VALUE SOME CHANGES NEEDED
//         int l= prices.length;
//         int min= prices[0];
//         int idx=0;
//         for(int i=1;i<l-1;i++){
//             if(prices[i]<=min){
//                 min= prices[i];
//                 idx=i;
//             }
//         }
//         //System.out.println(idx);
//         int maxv=0;
//         for(int j=idx;j<l;j++){
//             if(j==(l-1)){
//                 break;
//             }
//             if((prices[j+1]-prices[idx])>maxv){
//                 maxv=(prices[j+1]-prices[idx]);
//             }
//             //System.out.println(maxv);
//         }
//         if((maxv==0)||(maxv<0)){
//             return 0;
//         }
//         else{return maxv;}
//     }
// }
// solved but time complexitywas o(n^2) as 2 loops
// class Solution {
//     public int maxProfit(int[] prices) {
//         int l= prices.length;
//         int max=Integer.MIN_VALUE; 
//         for(int i=0;i<l-1;i++){
//             for(int j=i+1;j<l;j++){
//                 if(prices[j]-prices[i]>max){
//                     max=prices[j]-prices[i];
//                 }
//             }
//         }
//         if(max<=0){
//             return 0;
//         }
//         else{return max;}
//     }
// }
//solved using 1 loop O(N)
// class Solution {
//     public int maxProfit(int[] prices) {
//         int max=0;
//         int min=Integer.MAX_VALUE; 
//         for(int i :prices){
//             if(i<min){
//                 min=i;
//             }
//             else if(i-min>max){
//                 max=i-min;
//             }
//         }
//         return max;
//     }
// }
//done

//PROBLEM 7: https://leetcode.com/problems/rotate-image/description/
class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }

    
    }
}
//done

//PROBLEM 8:https://leetcode.com/problems/merge-intervals/
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            // If result is empty or no overlap, add the interval
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                // Merge with the last interval
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
        
    }
}
// DONE
//
////


//////////////////////////////////////
//Problem 9: ARRAY SORTING WITH ROATATED ARRAY

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        for(int k = 0; k < n; k++){
            if(isSorted(nums, k)){
                return true;
            }
        }

        return false;
    }

    public boolean isSorted(int[] nums, int start){
        int n = nums.length;

        for(int i = 0; i < n - 1; i++){
            int curr = nums[(start + i) % n];
            int next = nums[(start + i + 1) % n];

            if(curr > next){
                return false;
            }
        }

        return true;
    }
}
//////////////////////////////////////////////////

class Solution {
    public boolean judgeCircle(String moves) {
        int up = 0, down = 0, left = 0, right = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'U') up++;
            else if (ch == 'D') down++;
            else if (ch == 'L') left++;
            else right++;
        }

        return up == down && left == right;
    }
}

///////////////////////==============
class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;

        long[] power = new long[n];
        long windowSum = 0;

        // Build initial window [0 ... r]
        for (int i = 0; i <= r && i < n; i++) {
            windowSum += stations[i];
        }

        for (int i = 0; i < n; i++) {
            // Add right side
            if (i + r < n && i + r >= 0) {
                if (i + r > r) windowSum += stations[i + r];
            }

            power[i] = windowSum;

            // Remove left side
            if (i - r >= 0) {
                windowSum -= stations[i - r];
            }
        }

        long left = 0, right = (long) 1e14;
        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canAchieve(power, r, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canAchieve(long[] power, int r, int k, long target) {
        int n = power.length;
        long[] added = new long[n];

        long used = 0, curr = 0;

        for (int i = 0; i < n; i++) {
            curr += added[i];

            long total = power[i] + curr;

            if (total < target) {
                long need = target - total;
                used += need;

                if (used > k) return false;

                curr += need;

                int end = Math.min(n - 1, i + 2 * r);
                if (end + 1 < n) {
                    added[end + 1] -= need;
                }
            }
        }

        return true;
    }
}

///////////
import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        
        for (int[] obs : obstacles) {
            set.add(obs[0] + "," + obs[1]);
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 0, y = 0, dir = 0;
        int maxDist = 0;

        for (int cmd : commands) {
            if (cmd == -2) {
                dir = (dir + 3) % 4;
            } else if (cmd == -1) {
                dir = (dir + 1) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (set.contains(nx + "," + ny)) break;

                    x = nx;
                    y = ny;
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}
//======================
class Robot {

    int width, height;
    int x, y;
    int dir; // 0=East, 1=North, 2=West, 3=South

    int[][] directions = {
        {1, 0},   // East
        {0, 1},   // North
        {-1, 0},  // West
        {0, -1}   // South
    };

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        x = 0;
        y = 0;
        dir = 0;
    }

    public void step(int num) {
        int cycle = 2 * (width + height) - 4;
        num %= cycle;

        // Special case
        if (num == 0 && x == 0 && y == 0) {
            dir = 3; // South
            return;
        }

        while (num > 0) {
            int nx = x + directions[dir][0];
            int ny = y + directions[dir][1];

            if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
                dir = (dir + 1) % 4; // turn CCW
            } else {
                x = nx;
                y = ny;
                num--;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        String[] d = {"East", "North", "West", "South"};
        return d[dir];
    }
}
//=======================================================================
