class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            if (numbers[i] % 2 == 0)
                answer[i] = numbers[i] + 1;
            else {
                StringBuilder sb = new StringBuilder();
                String s = Long.toBinaryString(numbers[i]);
                
                if (!s.contains("0")){
                    sb.append("10");
                    sb.append(s.substring(1).replace("0", "1"));
                } else {
                    int last = s.lastIndexOf("0");
                    int first = s.indexOf("1", last);
                    
                    sb.append(s, 0, last).append("1");
                    sb.append("0");
                    sb.append(s.substring(first + 1));
                }
                answer[i] = Long.parseLong(sb.toString(), 2);
            }
            
        }
        
        return answer;
    }
}    
