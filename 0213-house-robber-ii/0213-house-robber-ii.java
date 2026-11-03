class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(
            robLinear(nums,0,nums.length-2),
            robLinear(nums,1,nums.length-1)
        );
    }
    public int robLinear(int[] nums, int start, int end){
        int p1 = 0;
        int p2 = 0;
        for(int i=start;i<=end;i++){
            int current = Math.max(p1,p2+nums[i]);
            p2=p1;
            p1=current;
        }
        return p1;
    }
}