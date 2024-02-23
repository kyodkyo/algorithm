import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s)
            return new int[]{-1};
        
        int base = s/n;
        int[] arr = new int[n];
        Arrays.fill(arr, base);
        
        for(int i=0; i<s%n; i++)
            arr[i]++;
        Arrays.sort(arr);
        return arr;
    }
}