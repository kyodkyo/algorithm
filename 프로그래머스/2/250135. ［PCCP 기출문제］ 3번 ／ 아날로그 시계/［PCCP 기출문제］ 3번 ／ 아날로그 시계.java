class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int time1 = (h1 * 3600) + (m1 * 60) + s1;
        int time2 = (h2 * 3600) + (m2 * 60) + s2;

        int count = 0;
        if (time1 == 0 || time1 == 43200)
            count++;
        
        for(int t=time1; t<time2; t++){
            int nowH = t/3600;
            int nowM = (t%3600) / 60;
            int nowS = (t%3600) % 60;
            double[] nowAngle = getAngle(nowH, nowM, nowS);

            int nextH = (t+1)/3600;
            int nextM = ((t+1)%3600) / 60;
            int nextS = ((t+1)%3600) % 60;
            double[] nextAngle = getAngle(nextH, nextM, nextS);

            boolean check1 = checkHS(nowAngle, nextAngle);
            boolean check2 = checkMS(nowAngle, nextAngle);

            if (check1 && check2){
                if (Double.compare(nextAngle[0], nextAngle[1]) == 0)
                    count += 1;
                else
                    count += 2;
            }
            else if (check1 || check2)
                count += 1;
        }
        return count;
    }
    
    public static double[] getAngle(int h, int m, int s){
        double hh = (30 * (h%12)) + (0.5 * m) + (1/120d * s);
        double mm = (6 * m) + (0.1 * s);
        double ss = (6 * s);

        return new double[]{hh, mm, ss};
    }

    public static boolean checkHS(double[] now, double[] next){
        if(Double.compare(now[0], now[2]) > 0 && Double.compare(next[0], next[2]) <= 0)
            return true;
        if (Double.compare(now[0], 354) > 0 && Double.compare(now[2], 354) == 0)
            return true;
        return false;
    }

    public static boolean checkMS(double[] now, double[] next){
        if(Double.compare(now[1], now[2]) > 0 && Double.compare(next[1], next[2]) <= 0)
            return true;
        if (Double.compare(now[1], 354) > 0 && Double.compare(now[2], 354) == 0)
            return true;
        return false;
    }
}