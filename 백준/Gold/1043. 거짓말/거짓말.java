import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, m;
    static boolean[] visitedParty, visitedPeople;
    static Queue<Integer> truthQ = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> partyList = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> peopleList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        String[] people = br.readLine().split(" ");
        int k = Integer.parseInt(people[0]);
        for(int i=1; i<=k; i++)
            truthQ.add(Integer.parseInt(people[i]));

        for(int i=0; i<=n; i++)
            peopleList.add(new ArrayList<>());

        for(int i=0; i<m; i++) {
            partyList.add(new ArrayList<>());
            people = br.readLine().split(" ");
            k = Integer.parseInt(people[0]);

            for(int j=1; j<=k; j++){
                partyList.get(i).add(Integer.parseInt(people[j]));
                peopleList.get(Integer.parseInt(people[j])).add(i);
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        visitedPeople = new boolean[n + 1];
        visitedParty = new boolean[m + 1];

        int count = 0;
        while(!truthQ.isEmpty()){
            int t = truthQ.poll();
            visitedPeople[t] = true;

            for(int party : peopleList.get(t)){
                if (!visitedParty[party]){
                    count++;
                    visitedParty[party] = true;
                    checkParty(party);
                }
            }
        }
        return m-count;
    }

    public static void checkParty(int party){
        for(int number : partyList.get(party)){
            if (!visitedPeople[number]) {
                truthQ.add(number);
            }
        }
    }

}