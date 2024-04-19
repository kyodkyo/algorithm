import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    static int n, answer=-1, countOn=1, countOff=0;
    static boolean[] current, result;
    static boolean[] startOn, startOff;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        current = inputSwitch(br.readLine());
        result = inputSwitch(br.readLine());

        startOn = new boolean[n];
        startOff = new boolean[n];

        for(int i=0; i<n; i++){
            if (i <= 1){
                startOn[i] = !current[i];
                startOff[i] = current[i];
            }
            else {
                startOn[i] = current[i];
                startOff[i] = current[i];
            }
        }

        for(int i=1; i<n; i++){
            if (startOn[i-1] != result[i-1]){
                switchOn(i, startOn);
                countOn++;
            }
            if (startOff[i-1] != result[i-1]){
                switchOn(i, startOff);
                countOff++;
            }

            if (Arrays.equals(startOn, result)){
                if (Arrays.equals(startOn, startOff))
                    answer = Math.min(countOn, countOff);
                else
                    answer = countOn;
                break;
            }
            else if (Arrays.equals(startOff, result)){
                answer = countOff;
                break;
            }
        }
        System.out.println(answer);
    }

    public static void switchOn(int i, boolean[] name){
        name[i-1] = !name[i-1];
        name[i] = !name[i];

        if (i<n-1)
            name[i+1] = !name[i+1];
    }

    public static boolean[] inputSwitch(String str){
        boolean[] check = new boolean[n];
        for(int i=0; i<n; i++){
            if (str.charAt(i) == '1')
                check[i] = true;
            else if (str.charAt(i) == '0')
                check[i] = false;
        }
        return check;
    }
}