class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        while(count != Integer.bitCount(++n))
            ;
        return n;
    }
}