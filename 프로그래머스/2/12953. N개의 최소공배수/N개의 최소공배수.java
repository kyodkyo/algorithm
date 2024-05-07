class Solution {
    public int solution(int[] arr) {
        int res = 1;
        for(int i=0; i<arr.length; i++)
            res = (res * arr[i]) / gcd(res, arr[i]);
        
        return res;
    }
    
    public static int gcd(int n1, int n2) {
        if (n1%n2 == 0)
            return n2;
        return gcd(n2, n1%n2);
    }
}