import java.util.*;

class Solution {
    
    static class Music implements Comparable<Music> {
        int num;
        String genre;
        int play;

        public Music(int num, String genre, int play){
            this.num = num;
            this.genre = genre;
            this.play = play;
        }

        @Override
        public int compareTo(Music p){
            if (this.play == p.play)
                return this.num - p.num;
            return p.play - this.play;
        }
    }
    
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            if (hashMap.containsKey(genres[i]))
                hashMap.put(genres[i], hashMap.get(genres[i]) + plays[i]);
            else
                hashMap.put(genres[i], plays[i]);
        }

        List<String> sortList = new ArrayList<>(hashMap.keySet());
        Collections.sort(sortList, (o1, o2) -> hashMap.get(o2).compareTo(hashMap.get(o1)));

        ArrayList<Music> musics = new ArrayList<>();
        for(int i=0; i<genres.length; i++)
            musics.add(new Music(i, genres[i], plays[i]));

        List<Integer> result = new ArrayList<>();

        for(String s : sortList){
            ArrayList<Music> list = new ArrayList<>();

            for(int i=0; i<genres.length; i++){
                if (genres[i].equals(s))
                    list.add(musics.get(i));
            }

            Collections.sort(list);

            if(list.size()==1)
                result.add(list.get(0).num);
            else{
                result.add(list.get(0).num);
                result.add(list.get(1).num);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}