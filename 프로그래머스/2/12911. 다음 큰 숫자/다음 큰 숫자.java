class Solution {
    public int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int count = 0;
        for(int i=0; i<binary.length(); i++){
            if (binary.charAt(i) == '1')
                count++;
        }
        
        boolean find = false;
        while(!find){
            n += 1;
            String tmp = Integer.toBinaryString(n);
            int next = 0;
            for(int i=0; i<tmp.length(); i++){
                if (tmp.charAt(i) == '1')
                    next++;
            }
            
            if (next == count){
                find = true;
                break;
            }
        }
        return n;
    }
}