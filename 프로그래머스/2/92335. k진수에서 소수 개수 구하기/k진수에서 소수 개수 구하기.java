class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String temp = Integer.toString(n, k);

        for(String s : temp.split("0")) {
            if(s.equals("")) 
                continue;
            if(isPrime(s))
                answer++;
        }
        return answer;
    }
    
    public boolean isPrime(String s){
        long n = Long.parseLong(s);
        if(n<2) 
            return false;
        if (n==2)
            return true;
        
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}