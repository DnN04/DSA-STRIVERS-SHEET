

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