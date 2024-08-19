class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int i=1; i<=s.length()/2; i++)
            answer = Math.min(answer, compress(i, s));
        return answer;
    }
    
    public static int compress(int len, String s){
        String target = s.substring(0, len);

        String ns = "";
        int count = 1;
        for(int i=len; i<s.length(); i+=len){
            String current = s.substring(i, Math.min(i+len, s.length()));

            if (target.equals(current))
                count++;
            else {
                ns = count > 1? ns + count + target : ns + target;
                target = current;
                count = 1;
            }
        }

        ns = count > 1? ns + count + target : ns + target;

        return ns.length();
    }
}