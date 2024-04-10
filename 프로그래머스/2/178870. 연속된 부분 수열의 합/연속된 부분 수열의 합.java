class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] arr = new int[]{0, sequence.length-1};
        
        int left=0, right=1;
        int sum = sequence[0];
        
        while(left < right){
            if (sum == k){
                if (right-left-1 < arr[1]-arr[0]){
                    arr[0] = left;
                    arr[1] = right-1;
                }
                sum -= sequence[left];
                left++;
            }
            else if (sum > k)
                sum -= sequence[left++];
            else if (right < sequence.length)
                sum += sequence[right++];
            else
                break;
        }
        
        return arr;
    }
}