# 3Sum Closest

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Two Pointers](https://img.shields.io/badge/Topic-Two Pointers-blue?style=flat-square)](https://leetcode.com/tag/two-pointers/) [![Topic: Sorting](https://img.shields.io/badge/Topic-Sorting-blue?style=flat-square)](https://leetcode.com/tag/sorting/)

- **LeetCode Link**: [https://leetcode.com/problems/3sum-closest/](https://leetcode.com/problems/3sum-closest/)
- **Problem ID**: 16
- **Language**: Java

## Solution Design

### Method Explanation
- *We solve this problem by leveraging standard data structures or algorithms suitable for the problem constraints.*
- *Make sure to update this section with notes on your implementation approaches.*

### Complexity Analysis
- **Time Complexity**: \(O(N)\) (where \(N\) is the number of elements)
- **Space Complexity**: \(O(1)\) auxiliary space

## Solution Code

```java


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];

        for(int i = 0 ; i < nums.length-2 ; i++){
            int curr = i;

            int st = i+1;
            int end = nums.length-1;
            while(st < end){
                int sum = nums[curr] + nums[st] + nums[end];
                if(Math.abs(sum - target) < Math.abs(ans-target)){
                    ans = sum;
                }

                if(sum == target){
                    return target;
                }
                else if(sum > target){
                    end--;
                }
                else{
                    st++;
                }
            }
        }
        return ans;
    }
}
```
