import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        while(!line.equals("end")){
            String[] horses = line.split("");
            sb.append(isPossible(horses));
            sb.append("\n");
            line = br.readLine();
        }

        System.out.println(sb);
    }

    public static String isPossible(String[] horses){
        int xcount = 0, ocount = 0;
        for(String s : horses){
            if (s.equals("X"))
                xcount++;
            if (s.equals("O"))
                ocount++;
        }

        boolean xwin = checkWin(horses, "X");
        boolean owin = checkWin(horses, "O");

        if (xwin && !owin && xcount == ocount + 1)
            return "valid";

        if (!xwin && owin && xcount == ocount)
            return "valid";

        if (!xwin && !owin && xcount==5 && ocount==4)
            return "valid";

        return "invalid";
    }

    public static boolean checkWin(String[] horses, String target){
        int count = 0;

        if (horses[0].equals(target) && horses[4].equals(target) && horses[8].equals(target))
            count++;
        if (horses[2].equals(target) && horses[4].equals(target) && horses[6].equals(target))
            count++;

        for(int i=0; i<9; i+=3)
            if (horses[i].equals(target) && horses[i+1].equals(target) && horses[i+2].equals(target))
                count++;

        for(int i=0; i<3; i++)
            if (horses[i].equals(target) && horses[i+3].equals(target) && horses[i+6].equals(target))
                count++;

        if (count == 1)
            return true;
        return false;
    }
}