import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        Arrays.sort(nums);
        
        int answer = 1;
        for(int i=1; i<nums.length; i++){
            if (nums[i] != nums[i-1])
                answer++;
        }
        
        if (answer < nums.length/2)
            return answer;
        else
            return nums.length/2;
    }
}