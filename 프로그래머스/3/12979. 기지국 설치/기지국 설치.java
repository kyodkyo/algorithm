class Solution {
    public int solution(int n, int[] stations, int w) {
        int pos = 1;
        int i = 0;
        int answer = 0;
        
        while(pos<=n){
            if (i >= stations.length || pos < stations[i] - w){
                answer++;
                pos += (1 + 2 * w);
            } 
            else{
                pos = stations[i] + w + 1;
                i++;
            }
        }

        return answer;
    }
}