import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        int[] newArr = Arrays.copyOf(rocks, rocks.length + 1);
        newArr[rocks.length] = distance;

        int min = 1;
        int max = distance;

        int count, temp, mid;
        while (min <= max) {
            count = 0;
            temp = 0;
            mid = (min + max) / 2;

            for (int i = 0; i < newArr.length; i++) {
                if (newArr[i] - temp < mid)
                    count++;
                else
                    temp = newArr[i];
            }
            if (count > n)
                max = mid - 1;
            else {
                answer = mid;
                min = mid + 1;
            }
        }
        return answer;
    }
}