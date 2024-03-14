import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static class Player implements Comparable<Player> {
        String name;
        int level;

        public Player(String name, int level){
            this.name = name;
            this.level = level;
        }

        @Override
        public int compareTo(Player p){
            return this.name.compareTo(p.name);
        }
    }
    static ArrayList<ArrayList<Player>> rooms = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int limit = Integer.parseInt(input[1]);

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            int level = Integer.parseInt(line[0]);
            String name = line[1];

            boolean findRoom = false;
            for(int j=0; j<rooms.size(); j++){
                int roomLevel = rooms.get(j).get(0).level;

                if (rooms.get(j).size() < limit && roomLevel-10 <= level && level <= roomLevel+10){
                    rooms.get(j).add(new Player(name, level));
                    findRoom = true;
                    break;
                }
            }

            if (!findRoom){
                ArrayList<Player> list = new ArrayList<>();
                list.add(new Player(name, level));
                rooms.add(list);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(ArrayList<Player> room : rooms){
            Collections.sort(room);

            if (room.size() == limit)
                sb.append("Started!\n");
            else
                sb.append("Waiting!\n");

            for(Player p : room)
                sb.append(p.level + " " + p.name + "\n");
        }
        System.out.println(sb);
    }
}