import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0){
            int n = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> teamMap = new HashMap<>();

            String[] input = br.readLine().split(" ");
            int[] seq = new int[n];
            int lastTeam = 0;
            for(int i=0; i<n; i++) {
                seq[i] = Integer.parseInt(input[i]);
                teamMap.put(seq[i], teamMap.getOrDefault(seq[i], 0) + 1);
                lastTeam = Math.max(lastTeam, seq[i]);
            }

            int[] fifthScore = new int[lastTeam + 1];
            int score = 1;
            HashMap<Integer, Integer> scoreMap = new HashMap<>();
            HashMap<Integer, Integer> newTeamMap = new HashMap<>();

            for(int teamNum : seq){
                if (teamMap.get(teamNum) == 6){
                    newTeamMap.put(teamNum, newTeamMap.getOrDefault(teamNum, 0) + 1);

                    if (newTeamMap.get(teamNum) <= 4)
                        scoreMap.put(teamNum, scoreMap.getOrDefault(teamNum, 0) + score);
                    if (newTeamMap.get(teamNum) == 5)
                        fifthScore[teamNum] = score;
                    score++;
                }
            }

            int winner = 0;
            int fifth = 1000;
            int minScore = Integer.MAX_VALUE;
            for(int key : scoreMap.keySet()){
                int temp = scoreMap.get(key);

                if (temp < minScore){
                    minScore = temp;
                    fifth = fifthScore[key];
                    winner = key;
                }
                else if (temp == minScore){
                    if (fifth > fifthScore[key])
                        winner = key;
                }
            }

            sb.append(winner + "\n");
        }
        System.out.println(sb);
    }
}
