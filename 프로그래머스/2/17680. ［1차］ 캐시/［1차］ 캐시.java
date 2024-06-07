import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        ArrayList<String> buffer = new ArrayList<>();
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toLowerCase();
            
            if (cacheSize == 0) {
                time += 5;
                continue;
            }
            
            if (buffer.contains(city)){
                time += 1;
                buffer.remove(city);
                buffer.add(city);
            }
            else {
                time += 5;
                if (cacheSize != 0 && buffer.size() == cacheSize)
                    buffer.remove(0);
                buffer.add(city);
            }
        }
        return time;
    }
}