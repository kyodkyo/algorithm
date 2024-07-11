import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String head1 = o1.split("[0-9]")[0];
            String head2 = o2.split("[0-9]")[0];

            int result = head1.toLowerCase().compareTo(head2.toLowerCase());
            if (result == 0)
                result = convert(o1, head1) - convert(o2, head2);
            return result;
        });
        return files;
    }
    
    public static int convert(String s, String head){
        s = s.substring(head.length());

        String result = "";
        for(char c : s.toCharArray()){
            if (Character.isDigit(c) && result.length()<5)
                result += c;
            else
                break;
        }
        return Integer.valueOf(result);
    }
}
