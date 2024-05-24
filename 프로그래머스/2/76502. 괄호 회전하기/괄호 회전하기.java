import java.util.*;

class Solution {
    static Stack<Character> stack;
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            if (isValid(s) && stack.isEmpty())
                answer++;
            s = s.substring(1) + s.charAt(0);
        }
        
        return answer;
    }
    
    public static boolean isValid(String s){
        stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if (c=='(' || c=='[' || c=='{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                
                if (stack.peek() == '(' && c == ')')
                    stack.pop();
                else if (stack.peek() == '{' && c == '}')
                    stack.pop();
                else if (stack.peek() == '[' && c == ']')
                    stack.pop();
                else 
                    return false;
            }
        }
        return true;
    }
}