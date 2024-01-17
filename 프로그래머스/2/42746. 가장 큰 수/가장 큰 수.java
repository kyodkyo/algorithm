import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        ArrayList<String> nums = new ArrayList<>();
        for(int n : numbers)
            nums.add(String.valueOf(n));
        
        Collections.sort(nums, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2); 
            }
        });
        
        if (nums.get(0).equals("0"))
            return "0";
        
        for(String s : nums)
            sb.append(s);
        
        return sb.toString();
    }
}