import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main{
    static class Stick{
        int idx;
        int height;

        public Stick(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }

    static Stick[] list;
    static int maxIdx=0, maxHeight=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new Stick[n];
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            int L = Integer.parseInt(line[0]);
            int H = Integer.parseInt(line[1]);
            list[i] = new Stick(L, H);
        }

        Arrays.sort(list, (o1, o2) -> o1.idx - o2.idx);
        for(int i=0; i<n; i++){
            if (maxHeight < list[i].height){
                maxHeight = list[i].height;
                maxIdx = i;
            }
        }

        int sum = list[maxIdx].height;

        int curIdx = list[0].idx;
        int curHigh = list[0].height;
        for(int i=1; i<=maxIdx; i++){
            if (list[i].height >= curHigh){
                sum += ((list[i].idx - curIdx) * curHigh);
                curIdx = list[i].idx;
                curHigh = list[i].height;
            }
        }

        curIdx = list[n-1].idx;
        curHigh = list[n-1].height;
        for(int i=n-1; i>=maxIdx; i--){
            if (list[i].height >= curHigh){
                sum += ((curIdx - list[i].idx) * curHigh);
                curIdx = list[i].idx;
                curHigh = list[i].height;
            }
        }
        System.out.println(sum);
    }
}