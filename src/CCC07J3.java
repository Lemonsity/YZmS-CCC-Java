import java.io.*;
public class CCC07J3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        while(!input.equals("halt")) {
            char[] chars = input.toCharArray();
            int seconds = 0;
            seconds += secondCal(chars[0]);
            for (int i = 1; i < chars.length; i++) {
                if (sameKey(chars[i], chars[i - 1]))
                    seconds += 2;
                seconds += secondCal(chars[i]);
            }
            System.out.print(seconds + "\n");
            input = br.readLine();
        }
    }
    public static boolean sameKey(char a, char b) {
        if ((a == 'z' || a == 'w' || a == 'x' || a == 'y') && (b == 'z' || b == 'w' || b == 'x' || b == 'y'))
            return true;
        if ((a == 'p' || a == 'q' || a == 'r' || a == 's') && (b == 'p' || b == 'q' || b == 'r' || b == 's'))
            return true;
        if (a < 's' && b < 's')
            return ((int)a - 97) / 3 == ((int)b - 97) / 3;
        return ((int)a - 98) / 3 == ((int)b - 98) / 3;
    }
    public static int secondCal(char c){
        if (c == 'z' || c == 's')
            return 4;
        if (c < 's')
            return ((int)c - 97) % 3 + 1;
        return ((int)c - 98) % 3 + 1;
    }
}
