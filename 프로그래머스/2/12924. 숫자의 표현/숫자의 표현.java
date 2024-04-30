class Solution {
    public int solution(int n) {
        int count=0, left=1, right=1, sum=0;
        while (left <= n){
            if (sum == n){
                count++;
                sum -= left;
                left++;
            }
            else if (sum < n){
                sum += right;
                right++;
            }
            else{
                sum -= left;
                left++;
            }
        }
        return count;
    }
}